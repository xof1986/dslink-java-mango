package io.swagger.client.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Base Data Model
 **/
@ApiModel(description = "Base Data Model")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class DataPointSummaryModel   {
  
  private String name = null;
  private String dataSourceXid = null;
  private Number pointFolderId = null;
  private String xid = null;
  private String deviceName = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dataSourceXid")
  public String getDataSourceXid() {
    return dataSourceXid;
  }
  public void setDataSourceXid(String dataSourceXid) {
    this.dataSourceXid = dataSourceXid;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("pointFolderId")
  public Number getPointFolderId() {
    return pointFolderId;
  }
  public void setPointFolderId(Number pointFolderId) {
    this.pointFolderId = pointFolderId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("xid")
  public String getXid() {
    return xid;
  }
  public void setXid(String xid) {
    this.xid = xid;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("deviceName")
  public String getDeviceName() {
    return deviceName;
  }
  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append(/*"class DataPointSummaryModel */"{\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  dataSourceXid: ").append(dataSourceXid).append("\n");
    sb.append("  pointFolderId: ").append(pointFolderId).append("\n");
    sb.append("  xid: ").append(xid).append("\n");
    sb.append("  deviceName: ").append(deviceName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
