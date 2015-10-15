package org.dsa.iot.mango;

import io.swagger.client.ApiException;
import io.swagger.client.api.MangoDSLApi;
import io.swagger.client.model.JsonArrayStream;
import io.swagger.client.model.ResponseEntityJsonArrayStream;
import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.dslink.util.handler.CompleteHandler;
import org.dsa.iot.dslink.util.json.JsonObject;
import org.dsa.iot.historian.database.Database;
import org.dsa.iot.historian.utils.QueryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

//only one of the overridden methods below are used in this implementation: query()
//the rest are not needed
public class Db extends Database {

    private static final Logger LOGGER = LoggerFactory.getLogger(Db.class);
    private final MangoDSLApi api;

    //set the global variables
    public Db(String name, MangoDSLApi api) {
        super(name, null);
        this.api = api;
    }

    @Override
    public void write(String path, Value value, long ts) {
        throw new UnsupportedOperationException();
    }

    //access the data history based query parameters
    @Override
    public void query(String path, long from, long to, CompleteHandler<QueryData> handler) {
        try {
            Date f = new Date(from);
            Date t = new Date(to);
            ResponseEntityJsonArrayStream[] rejas = api.getPointValues(path, f, t, null, null, null);
            ResponseEntityJsonArrayStream j = rejas[0];
            JsonArrayStream jas = j.getBody();
            List<JsonObject> list = jas.getJsonArray();
            for (JsonObject jo : list) {
            	Object o  = jo.get("value");
            	Value val = null;
            	if(o instanceof Boolean){
            		val = new Value((Boolean)o);
            	}else if (o instanceof Number){
            		val = new Value((Number)o);
            	}else if (o instanceof String){
            		val = new Value((String)o);
            	}
                long ts = jo.get("timestamp");
                QueryData qd = new QueryData(val, ts);
                handler.handle(qd);
            }
        } catch (ApiException e) {
            LOGGER.info("Data point history query failed\n{}", e);
        }

        handler.complete();
    }

    @Override
    public QueryData queryFirst(String path) {
        throw new UnsupportedOperationException();
    }

    @Override
    public QueryData queryLast(String path) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void performConnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public void initExtensions(Node node) {
        throw new UnsupportedOperationException();
    }
}
