package io.swagger.client.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class LoggingProperties   {
  

  public enum TypeEnum {
      ALL("ALL"), INTERVAL("INTERVAL"), NONE("NONE"), ON_CHANGE("ON_CHANGE"), ON_TS_CHANGE("ON_TS_CHANGE");

      private String value;

      TypeEnum(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  private TypeEnum type = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoggingProperties {\n");
    
    sb.append("  type: ").append(type).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
