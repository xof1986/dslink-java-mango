package org.dsa.iot.mango;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.MangoDSLApi;
import io.swagger.client.model.*;
import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.actions.ActionResult;
import org.dsa.iot.dslink.node.actions.Parameter;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vertx.java.core.Handler;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Peter Weise on 9/3/15.
 */
public class MangoFolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MangoFolder.class);

    private Node node;
    protected MangoDSLApi api;
    protected ApiClient client;
    private MangoConn conn;
    private boolean loggedin = false;
    protected ArrayList<Node> nodesToUpdate = new ArrayList<>();
    protected ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    protected ScheduledFuture<?> updateHandle = null;
    protected Runnable update = null;
    private int updateRate = 5;

    public MangoFolder(Node child, MangoDSLApi api, ApiClient client, MangoConn conn) {
        this.node = child;
        this.api = api;
        this.client = client;
        this.conn = conn;
    }

    //initialize user node settings and create actions for the server level node
    public void init() {
        client.setNode(node);
        client.setFolder(this);

        loggedin = true;

        setActions();

        getHierarchy();

        startPointUpdates();
    }

    //set actions for the server level node
    private void setActions() {
        Action editAct = editAction();
        node.createChild("edit").setAction(editAct).setSerializable(false).build();

        Action outAct = logoutAction();
        node.createChild("delete").setAction(outAct).setSerializable(false).build();

        Action refreshAct = refreshAction();
        node.createChild("refresh").setAction(refreshAct).setSerializable(false).build();


    }

    //create action object for editing node attributes
    private Action editAction() {
        Action act = new Action(Permission.READ, new EditHandler());
        act.addParameter(new Parameter("name", ValueType.STRING, new Value(node.getName())));
        act.addParameter(new Parameter("url", ValueType.STRING, new Value(node.getAttribute("url").toString())));
        act.addParameter(new Parameter("default polling interval", ValueType.NUMBER, new Value(updateRate)));
        return act;
    }

    //action handler for the edit action
    private class EditHandler implements Handler<ActionResult> {
        public void handle(ActionResult event) {
            String name = event.getParameter("name").toString();
            if (!name.equals(node.getName())) {
                node.setDisplayName(name);
            }
            String url = event.getParameter("url").getString();
            if (!url.equals(node.getAttribute("url"))) {
                node.setAttribute("url", new Value(url));
                client.setBasePath(url);
            }
            int delay = event.getParameter("default polling interval").getNumber().intValue();
            if (delay != conn.link.updateRate) {
                conn.link.updateRate = delay;
                updateHandle.cancel(true);
                updateHandle = scheduler.scheduleAtFixedRate(update, conn.link.updateRate, conn.link.updateRate, TimeUnit.SECONDS);
            }
        }
    }

    //create action object for logging out
    private Action logoutAction() {
        Action act = new Action(Permission.READ, new LogoutHandler());
        return act;
    }

    //action handler for the logout action
    private class LogoutHandler implements Handler<ActionResult> {
        public void handle(ActionResult event) {
            loggedin = false;
            nodesToUpdate.clear();
            conn.logout();
        }
    }

    //create action object for refreshing the point hierarchy
    private Action refreshAction() {
        Action act = new Action(Permission.READ, new RefreshHandler());
        return act;
    }

    //action handler for the refresh action
    private class RefreshHandler implements Handler<ActionResult> {
        public void handle(ActionResult event) {
            getHierarchy();
        }
    }

    //build the node hierarchy from the user node, down the folder nodes, to the data point
    //using the API method.  This method includes setting attributes for children
    //and setting the initial value for for each point
    protected void getHierarchy() {
        try {
            ResponseEntityPointHierarchyModel ph =  api.getPointHierarchy();
            //String sc = ph.getStatusCode().toString();
            //String b = ph.getBody().toString();
            //String h = ph.getHeaders().toString();
            //LOGGER.info("Get Hierarchy procedure\nStatus code:\t{}\nBody:\t{}\nHeaders:\t{}\n", sc, b, h);
            LOGGER.info("Point Hierarchy completed");
        } catch (ApiException e) {
            LOGGER.info("getHierarchy\n\tcode: {}\n\tmessage: {}\n\theader: {}\n\tbody: {}\n{}", e.getCode(), e.getMessage(), e.getResponseHeaders(), e.getResponseBody(), e);
        }
    }

    private void getHistory() {

    }

    //scheduled method to update data points that are expected to change value periodically
    //the update rate is settable
    private void startPointUpdates() {
        update = new Runnable() {
            public void run() {
                if (loggedin) {
                    synchronized (nodesToUpdate) {
                        for (int i = 0; i < nodesToUpdate.size(); i++) {
                            Node no = nodesToUpdate.get(i);
                            try {
                                Node original = client.getNode();
                                client.setNode(no);
                                String xid = no.getAttribute("xid").getString();
                                ResponseEntityRealTimeModel rtm = api.get(xid);
                                String b = rtm.getBody().toString();
                                int beginIndex = b.indexOf("type: ");
                                int endIndex = b.indexOf("\n", beginIndex);
                                String type = b.substring(beginIndex + 6, endIndex);
                                beginIndex = b.indexOf("value: ");
                                endIndex = b.indexOf("\n", beginIndex);
                                String value = b.substring(beginIndex + 7, endIndex);
                                Value val = null;
                                switch (type) {
                                    case "Numeric":
                                        Float num = Float.valueOf(value);
                                        val = new Value(num);
                                        break;
                                    case "Binary":
                                        Boolean bool = Boolean.getBoolean("value");
                                        val = new Value(bool);
                                        break;
                                    case "Multistate":
                                        LOGGER.info("bodyBuilder:RealTimeModel - unimplemented data type: MULTISTATE");
                                        break;
                                    case "Image":
                                        LOGGER.info("bodyBuilder:RealTimeModel - unimplemented data type: IMAGE");
                                        break;
                                    case "Alphanumeric":
                                        String s = String.valueOf(value);
                                        val = new Value(s);
                                        break;
                                }
                                no.setValue(val);
                                client.setNode(original);
                            } catch (ApiException e) {
                                LOGGER.error("Data point has no data - {}", no.getDisplayName());
                                no.setValue(null);
                                //LOGGER.info("startPointUpdates\n\tcode: {}\n\tmessage: {}\n\theader: {}\n\tbody: {}\n{}", e.getCode(), e.getMessage(), e.getResponseHeaders(), e.getResponseBody(), e);
                            }
                        }
                    }
                }
            }
        };
        updateHandle = scheduler.scheduleAtFixedRate(update, conn.link.updateRate, conn.link.updateRate, TimeUnit.SECONDS);
    }
}
