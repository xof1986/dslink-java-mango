package org.dsa.iot.mango;

import io.swagger.client.ApiException;
import io.swagger.client.api.MangoDSLApi;
import io.swagger.client.model.*;
import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.NodeBuilder;
import org.dsa.iot.dslink.node.Writable;
import org.dsa.iot.dslink.node.actions.Action;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.node.value.ValuePair;
import org.dsa.iot.dslink.node.value.ValueType;
import org.dsa.iot.historian.stats.GetHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonArray;
import org.vertx.java.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter Weise on 9/4/15.
 */
public class MangoBodyBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MangoBodyBuilder.class);

    private MangoConn conn;
    private MangoFolder folder;
    private final MangoDSLApi api;

    public MangoBodyBuilder (MangoConn conn) {
        this.conn = conn;
        this.api = conn.getApi();
    }

    public void setBuilder(MangoFolder folder) {
        this.folder = folder;
    }

    //method to build the body portion of most data models
    //some of these models call bodyBuilder recursively
    //creation of nodes below the user node level is done here
    //or by helper methods called within this method
    @SuppressWarnings("unchecked")
    public <T> T bodyBuilder(Class<?> ret, String body, Node node) throws ApiException {
        Object instance = null;
        final String clazzName = ret.getName();
        switch (clazzName) {
            case "io.swagger.client.model.UserModel":
                try {
                    JsonObject jo = new JsonObject(body);
                    UserModel model = new UserModel();
                    model.setUsername(jo.getString("username"));
                    model.setEmail(jo.getString("email"));
                    //Todo
                    //complete the PermissionsModel and DataPointPermissionsModel once there is something to test
                    PermissionsModel pm = new PermissionsModel();
                    List<String> dsx = new ArrayList<>();
                    JsonArray ja = jo.getArray("dataSourceXids");
                    if (ja != null)
                        dsx = ja.toList();
                    pm.setDataSourceXids(dsx);
                    model.setPermissions(pm);
                    model.setDisabled(jo.getBoolean("disabled"));
                    model.setPassword(jo.getString("password"));
                    model.setHomeUrl(jo.getString("homeUrl"));
                    model.setReceiveAlarmEmails(UserModel.ReceiveAlarmEmailsEnum.valueOf(jo.getString("receiveAlarmEmails")));
                    model.setMuted(jo.getBoolean("muted"));
                    model.setTimezone(jo.getString("timezone"));
                    model.setSystemTimezone(jo.getString("systemTimezone"));
                    instance = model;
                } catch (Exception e) {
                    LOGGER.info("UserModel loading error\n{}", e);
                }
                break;
            case "io.swagger.client.model.PointHierarchyModel":
                try{
                    JsonObject jo = new JsonObject(body);
                    PointHierarchyModel model = new PointHierarchyModel();
                    String name = jo.getString("name");
                    String root = name.toLowerCase();
                    if (name.equals("")) {
                        name = "Unnamed";
                    }
                    model.setName(name);
                    Node child;
                    if (root.equals("root")) {
                        child = node;
                    } else {
                        child = node.createChild(name).setSerializable(false).build();
                    }
                    List<DataPointSummaryModel> points = new ArrayList<>();
                    for (Object o : jo.getArray("points")) {
                        DataPointSummaryModel dpsm = pointBuilder(o.toString(), child);
                        points.add(dpsm);
                    }
                    if (points.size() > 0) model.setPoints(points);
                    model.setId(jo.getInteger("id"));
                    List<PointHierarchyModel> folders = new ArrayList<>();
                    for (Object j : jo.getArray("subfolders")) {
                        PointHierarchyModel f = bodyBuilder(ret, j.toString(), child);
                        folders.add(f);
                    }
                    if (folders.size() > 0) model.setSubfolders(folders);
                    instance = model;
                } catch (Exception e) {
                    LOGGER.info("PointHierarchyModel loading error\n{}", e);
                }
                break;
            case "io.swagger.client.model.RealTimeModel":
                JsonObject jo = new JsonObject(body);
                RealTimeModel model = new RealTimeModel();
                model.setName(jo.getString("name"));
                String type = jo.getString("type");
                model.setType(type);
                Value val;
                switch (type) {
                    case "Numeric":
                        node.setValueType(ValueType.NUMBER);
                        node.setAttribute("type", new Value(type));
                        Number num = jo.getNumber("value");
                        model.setValue(num);
                        val = new Value(num);
                        node.setValue(val);
                        break;
                    case "Binary":
                        node.setValueType(ValueType.BOOL);
                        node.setAttribute("type", new Value(type));
                        boolean b = jo.getBoolean("value");
                        model.setValue(b);
                        val = new Value(b);
                        node.setValue(val);
                        break;
                    case "Multistate":
                        LOGGER.info("bodyBuilder:RealTimeModel - unimplemented data type: MULTISTATE");
                        break;
                    case "Image":
                        LOGGER.info("bodyBuilder:RealTimeModel - unimplemented data type: IMAGE");
                        break;
                    case "Alphanumeric":
                        node.setValueType(ValueType.STRING);
                        node.setAttribute("type", new Value(type));
                        String s = jo.getString("value");
                        model.setValue(s);
                        val = new Value(s);
                        node.setValue(val);
                        break;
                }
                String path = jo.getString("path");
                model.setPath(path);
                node.setAttribute("path", new Value(path));
                model.setXid(jo.getString("xid"));
                model.setDeviceName(jo.getString("deviceName"));
                String status = jo.getString("status");
                model.setStatus(status);
                val = new Value(status);
                node.setAttribute("status", val);
                Integer time = jo.getInteger("time");
                model.setTime(time.longValue());
                val = new Value(time);
                node.setAttribute("time", val);
                String unit = jo.getString("unit");
                model.setUnit(unit);
                val = new Value(unit);
                node.setAttribute("unit", val);
                String rendered = jo.getString("renderedValue");
                model.setRenderedValue(rendered);
                val = new Value(rendered);
                node.setAttribute("renderedValue", val);
                instance = model;
                break;
            case "io.swagger.client.model.DataPointModel":
                jo = new JsonObject(body);
                DataPointModel m = new DataPointModel();
                JsonObject pl = jo.getObject("pointLocator");
                PointLocatorVO plvo = pointLocatorBuilder(pl, node);
                m.setPointLocator(plvo);
                m.setDeviceName(jo.getString("deviceName"));
                m.setUnit(jo.getString("unit"));
                DataPointModel.DataTypeEnum dataType = DataPointModel.DataTypeEnum.valueOf(jo.getString("dataType"));
                m.setDataType(dataType);
                JsonObject l = jo.getObject("loggingProperties");
                LoggingProperties lp = new LoggingProperties();
                lp.setType(LoggingProperties.TypeEnum.valueOf(l.getString("type")));
                m.setEnabled(jo.getBoolean("enabled"));
                m.setName("name");
                //ToDo
                //setValidationMessage
                m.setXid(jo.getString("xid"));
                instance = m;
                break;
            case "io.swagger.client.model.PointValueTimeModel":
                jo = new JsonObject(body);
                PointValueTimeModel mo = new PointValueTimeModel();
                mo.setValue(jo.getValue("value"));
                mo.setTimestamp(jo.getLong("timestamp"));
                mo.setAnnotation(jo.getString("annotation"));
                PointValueTimeModel.DataTypeEnum dt = PointValueTimeModel.DataTypeEnum.valueOf(jo.getString("dataType"));
                mo.setDataType(dt);
                instance = mo;
                break;
            case "io.swagger.client.model.JsonArrayStream":
                JsonArray ja = new JsonArray(body);
                JsonArrayStream jas = new JsonArrayStream();
                for (int i  = 0; i < ja.size(); i++) {
                    JsonObject job = ja.get(i);
                    jas.putJsonArray(job);
                }
                instance = jas;
                break;
            default:
                LOGGER.info("Unknown/Unimplemented return type");
                throw new ApiException(501, "Unknown/Unimplemented return type in MangoBodyBuilder: " + clazzName);
        }
        return (T) instance;
    }

    //helper method to build the DataPointSummaryModel body
    //and define data point attributes
    private DataPointSummaryModel pointBuilder(String point, Node node) {
        final JsonObject ob = new JsonObject(point);
        final DataPointSummaryModel model = new DataPointSummaryModel();
        final String name = ob.getString("name");

        NodeBuilder b = node.createChild(ob.getString("xid"));
        {
            b.setSerializable(false);
            b.setDisplayName(name);
            b.setValueType(ValueType.STRING);
            b.setValue(null);
            b.setWritable(Writable.NEVER);
            model.setName(name);
        }
        {
            String dsxid = ob.getString("dataSourceXid");
            model.setDataSourceXid(dsxid);
            Value val = new Value(dsxid);
            b.setAttribute("dataSourceXid", val);
        }

        {
            Integer pfid = ob.getInteger("pointFolderId");
            model.setPointFolderId(pfid);
            Value val = new Value(pfid);
            b.setAttribute("pointFolderId", val);
        }

        final String xid;
        {
            xid = ob.getString("xid");
            model.setXid(xid);
            Value val = new Value(xid);
            b.setAttribute("xid", val);
        }

        {
            String deviceName = ob.getString("deviceName");
            model.setDeviceName(deviceName);
            Value val = new Value(deviceName);
            b.setAttribute("deviceName", val);
        }

        Node child = b.build();
        pointSetter(xid, child);
        setActions(child);
        GetHistory.initAction(child, new Db(xid, api));
        return model;
    }

    //helper method setting point values
    private void pointSetter(String xid, Node node) {
        Node original = conn.getClientNode();
        try {
            conn.setClientNode(node);
            ResponseEntityDataPointModel dp = api.getDataPoint(xid);
            LOGGER.info("Data Point Model complete");
            ResponseEntityRealTimeModel rt = api.get(xid);
            LOGGER.info("Real Time Model complete");
            conn.setClientNode(original);
        } catch (ApiException e) {
            if (e.getCode() == 404) {
                LOGGER.error("Data point doesn't have a value - {}", node.getName());
                node.setValue(null);
            } else {
                LOGGER.info("pointSetter loading error\n{}", e);
            }
            conn.setClientNode(original);
        }
    }

    //helper method to build the PointLocatorVO model
    //this method determines if a data point can be set by the user
    //and adds data points that update periodically to the nodesToUpdate array
    //for use by the ManagerFolder.startPointUpdates method
    private PointLocatorVO pointLocatorBuilder (JsonObject jo, Node n) {
        PointLocatorVO plvo = new PointLocatorVO();
        plvo.setSettable(jo.getBoolean("settable"));
        if (plvo.getSettable()) {
            n.setWritable(Writable.WRITE);
            n.getListener().setValueHandler(new SetPointHandler(n));
        }
        final ArrayList<Node> nodesToUpdate = folder.getNodesToUpdate();
        if (!nodesToUpdate.contains(n))
            nodesToUpdate.add(n);
        return plvo;
    }

    //handler for the user to set a data point's value
    private class SetPointHandler implements Handler<ValuePair> {
        private Node kid;
        public SetPointHandler(Node kid) {
            this.kid = kid;
        }
        @Override
        public void handle(ValuePair event) {
            if (!event.isFromExternalSource()) return;
            sendValue(kid, event);
        }
    }

    //method to take the user's entered data point value
    //and set it to the data point (both in the node as well as in the server)
    private void sendValue(Node n, ValuePair event) {
        String type = n.getAttribute("type").toString();
        PointValueTimeModel dpm = new PointValueTimeModel();
        Value val;
        switch(type) {
            case "Binary":
                boolean entryBool = event.getCurrent().getBool();
                val = new Value(entryBool);
                n.setValue(val);
                dpm.setDataType(PointValueTimeModel.DataTypeEnum.BINARY);
                dpm.setValue(entryBool);
                break;
            case "Numeric":
                Number entryNum = event.getCurrent().getNumber();
                val = new Value(entryNum);
                n.setValue(val);
                dpm.setDataType(PointValueTimeModel.DataTypeEnum.NUMERIC);
                dpm.setValue(entryNum);
                break;
            case "Multistate":
                LOGGER.info("sendValue - unimplemented data type: MULTISTATE");
                break;
            case "Image":
                LOGGER.info("sendValue - unimplemented data type: IMAGE");
                break;
            case "Alphanumeric":
                String entryString = event.getCurrent().getString();
                val = new Value(entryString);
                n.setValue(val);
                dpm.setDataType(PointValueTimeModel.DataTypeEnum.ALPHANUMERIC);
                dpm.setValue(entryString);
                break;
            default:
                LOGGER.info("sendValue - unknown data type: {}", type);
        }
        try {
            api.putPointValue(n.getAttribute("xid").getString(), dpm);
        } catch (ApiException e) {
            LOGGER.info("sendValue loading error\n{}", e);
        }
    }

    //set actions to each data point
    private void setActions(Node node) {
        Action deleteAct = folder.deleteAction(node);
        node.createChild("delete").setAction(deleteAct).setSerializable(false).build();
    }
}
