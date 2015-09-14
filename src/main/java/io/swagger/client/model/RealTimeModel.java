package io.swagger.client.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Base Data Model
 **/
@ApiModel(description = "Base Data Model")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class RealTimeModel   {
  
  private String name = null;
  private Object value = null;
  private String type = null;
  private String path = null;
  private String xid = null;
  private String deviceName = null;
  private String status = null;
  private String unit = null;
  private Long time = null;
  private String renderedValue = null;

  
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
  @JsonProperty("value")
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("path")
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
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

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("unit")
  public String getUnit() {
    return unit;
  }
  public void setUnit(String unit) {
    this.unit = unit;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("time")
  public Long getTime() {
    return time;
  }
  public void setTime(Long time) {
    this.time = time;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("renderedValue")
  public String getRenderedValue() {
    return renderedValue;
  }
  public void setRenderedValue(String renderedValue) {
    this.renderedValue = renderedValue;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append(/*"class RealTimeModel */"{\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  path: ").append(path).append("\n");
    sb.append("  xid: ").append(xid).append("\n");
    sb.append("  deviceName: ").append(deviceName).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("  time: ").append(time).append("\n");
    sb.append("  renderedValue: ").append(renderedValue).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
