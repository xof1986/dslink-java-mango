package org.dsa.iot.mango;

import io.swagger.client.ApiException;
import io.swagger.client.model.JsonArrayStream;
import io.swagger.client.model.ResponseEntityJsonArrayStream;
import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.value.Value;
import org.dsa.iot.historian.database.Database;
import org.dsa.iot.historian.utils.QueryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Peter Weise on 9/14/15.
 */

//only one of the overridden methods below are used in this implementation: query()
//the rest are not needed
public class Db extends Database {

    private static final Logger LOGGER = LoggerFactory.getLogger(Db.class);
    private final MangoFolder folder;

    //set the global variables
    public Db(String name, MangoFolder folder) {
        super(name, null);
        this.folder = folder;
    }

    @Override
    public void write(String path, Value value, long ts) {
        throw new UnsupportedOperationException();
    }

    //access the data history based query parameters
    @Override
    public void query(String path, long from, long to, Handler<QueryData> handler) {
        try {
            Date f = new Date(from);
            Date t = new Date(to);
            ResponseEntityJsonArrayStream[] rejas = folder.api.getPointValues(path, f, t, null, null, null);
            ResponseEntityJsonArrayStream j = rejas[0];
            JsonArrayStream jas = j.getBody();
            List<JsonObject> list = jas.getJsonArray();
            for (JsonObject jo : list) {
                Value val = new Value(jo.getNumber("value"));
                long ts = jo.getNumber("timestamp").longValue();
                QueryData qd = new QueryData(val, ts);
                handler.handle(qd);
            }
        } catch (ApiException e) {
            LOGGER.info("Data point history query failed\n{}", e);
        }

        handler.handle(null);
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
