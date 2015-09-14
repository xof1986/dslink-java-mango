package io.swagger.client.model;

import org.dsa.iot.mango.MangoConn;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by dglogik on 8/31/15.
 */
public class HttpHeaders {

    private final Map<String, Object> headers;

    public HttpHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public String getCookie() {
        if (headers.containsKey("Set-Cookie")) {
            Object c = headers.get("Set-Cookie");
            String cookie = c.toString();
            return cookie;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(/*"class HttpHeaders */"{\n");
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            sb.append("  ");
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
