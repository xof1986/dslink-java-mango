package io.swagger.client.model;

import io.swagger.annotations.ApiModel;
import org.dsa.iot.dslink.util.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class JsonArrayStream   {

    private List<JsonObject> jsonArray;

    public JsonArrayStream() {
        jsonArray = new ArrayList<>();
    }

    public List<JsonObject> getJsonArray() {
        return jsonArray;
    }

    public void putJsonArray(JsonObject jo) {
        jsonArray.add(jo);
    }

    @Override
    public String toString()  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < jsonArray.size(); i++) {
        JsonObject jo = jsonArray.get(i);
        sb.append("{\n  annotation: ").append(jo.get("annotation")).append("\n");
        sb.append("  value: ").append(jo.get("value")).append("\n");
        sb.append("  timestamp: ").append(jo.get("timestamp")).append("\n");
        sb.append("}\n");
    }
    return sb.toString();
    }
}
