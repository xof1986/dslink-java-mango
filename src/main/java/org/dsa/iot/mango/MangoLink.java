package org.dsa.iot.mango;

import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.NodeBuilder;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.actions.ActionResult;
import org.dsa.iot.dslink.node.actions.EditorType;
import org.dsa.iot.dslink.node.actions.Parameter;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vertx.java.core.Handler;

/**
 * Created by Peter Weise on 8/31/15.
 */
public class MangoLink {

    private static final Logger LOGGER = LoggerFactory.getLogger(MangoLink.class);

    private Node node;
    protected int updateRate = 5;

    public MangoLink (Node node) {
        this.node = node;
    }

    //start global variables and start the link
    public static void start(Node parent) {
        MangoLink mango = new MangoLink(parent);
        mango.init();
    }

    //initialize the link session and add the connection action
    private void init() {
        //node.clearChildren();  //used for testing purposes

        restoreLastSession();

        Action act = setPathAction();
        node.createChild("Add Connection").setAction(act).setSerializable(false).build();
    }

    //reload the nodes and objects used during the last application execution
    //from the Mango master level
    private void restoreLastSession() {
        if (node.getChildren() == null) return;
        for (Node child: node.getChildren().values()) {
            if (child.getAttribute("url") != null) {
                MangoConn conn = new MangoConn(getMe(), child);
                conn.start();
            } else if (child.getAction() == null) {
                node.removeChild(child);
            }
        }
    }

    //set up action for setting the connection information
    private Action setPathAction() {
        Action act = new Action(Permission.READ, new CreateConnHandler());
        act.addParameter(new Parameter("name", ValueType.STRING).setPlaceHolder("Local Host"));
        act.addParameter(new Parameter("url", ValueType.STRING).setPlaceHolder("http://localhost:8000/rest"));
        act.addParameter(new Parameter("username", ValueType.STRING).setPlaceHolder("admin"));
        act.addParameter(new Parameter("password", ValueType.STRING).setPlaceHolder("admin").setEditorType(EditorType.PASSWORD));
        act.addParameter(new Parameter("default polling interval", ValueType.NUMBER, new Value(updateRate)));
        return act;
    }

    //receive URL path and label information as well as username and password,
    //then build the host level node
    private class CreateConnHandler implements Handler<ActionResult> {
        public void handle(ActionResult event) {
            String url = event.getParameter("url", ValueType.STRING).getString();
            String name = event.getParameter("name", ValueType.STRING).getString();
            String username = event.getParameter("username", ValueType.STRING).getString();
            String pw = event.getParameter("password", ValueType.STRING).getString();
            updateRate = event.getParameter("default polling interval", ValueType.NUMBER).getNumber().intValue();
            NodeBuilder b = node.createChild(name);
            b.setAttribute("url", new Value(url));
            b.setAttribute("username", new Value(username));
            b.setPassword(pw.toCharArray());
            Node child = b.build();
            LOGGER.info("Base URL set - {}", child.getAttribute("url"));
            MangoConn conn = new MangoConn(getMe(), child);
            conn.start();
        }
    }

    private MangoLink getMe() { return this; }
}
