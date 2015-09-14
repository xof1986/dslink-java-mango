package io.swagger.client.model;

import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class TranslatableMessage   {
  
  private String key = null;
  private List<Object> args = new ArrayList<Object>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("key")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("args")
  public List<Object> getArgs() {
    return args;
  }
  public void setArgs(List<Object> args) {
    this.args = args;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranslatableMessage {\n");
    
    sb.append("  key: ").append(key).append("\n");
    sb.append("  args: ").append(args).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
