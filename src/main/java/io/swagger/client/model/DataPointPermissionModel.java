package io.swagger.client.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class DataPointPermissionModel   {
  

public enum PermissionEnum {
  READ("READ"), SET("SET");

  private String value;

  PermissionEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private PermissionEnum permission = null;
  private String dataPointXid = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("permission")
  public PermissionEnum getPermission() {
    return permission;
  }
  public void setPermission(PermissionEnum permission) {
    this.permission = permission;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dataPointXid")
  public String getDataPointXid() {
    return dataPointXid;
  }
  public void setDataPointXid(String dataPointXid) {
    this.dataPointXid = dataPointXid;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataPointPermissionModel {\n");
    
    sb.append("  permission: ").append(permission).append("\n");
    sb.append("  dataPointXid: ").append(dataPointXid).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
