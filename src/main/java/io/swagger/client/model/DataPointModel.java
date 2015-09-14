package io.swagger.client.model;

import io.swagger.client.model.Entry;
import io.swagger.client.model.LoggingProperties;
import java.util.*;
import io.swagger.client.model.PointLocatorVO;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Base Data Model
 **/
@ApiModel(description = "Base Data Model")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class DataPointModel   {
  
  private PointLocatorVO pointLocator = null;
  private String deviceName = null;
  private String unit = null;

  public enum DataTypeEnum {
    ALPHANUMERIC("ALPHANUMERIC"), BINARY("BINARY"), MULTISTATE("MULTISTATE"), NUMERIC("NUMERIC"), IMAGE("IMAGE");

    private String value;

    DataTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  private DataTypeEnum dataType = null;
  private LoggingProperties loggingProperties = null;
  private Boolean enabled = null;
  private String name = null;
  private List<Entry> validationMessages = new ArrayList<Entry>();
  private String xid = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("pointLocator")
  public PointLocatorVO getPointLocator() {
    return pointLocator;
  }
  public void setPointLocator(PointLocatorVO pointLocator) {
    this.pointLocator = pointLocator;
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
  @JsonProperty("dataType")
  public DataTypeEnum getDataType() {
    return dataType;
  }
  public void setDataType(DataTypeEnum dataType) {
    this.dataType = dataType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("loggingProperties")
  public LoggingProperties getLoggingProperties() {
    return loggingProperties;
  }
  public void setLoggingProperties(LoggingProperties loggingProperties) {
    this.loggingProperties = loggingProperties;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("enabled")
  public Boolean getEnabled() {
    return enabled;
  }
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  
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
  @JsonProperty("validationMessages")
  public List<Entry> getValidationMessages() {
    return validationMessages;
  }
  public void setValidationMessages(List<Entry> validationMessages) {
    this.validationMessages = validationMessages;
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append(/*"class DataPointModel */"{\n");
    
    sb.append("  pointLocator: ").append(pointLocator).append("\n");
    sb.append("  deviceName: ").append(deviceName).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("  dataType: ").append(dataType).append("\n");
    sb.append("  loggingProperties: ").append(loggingProperties).append("\n");
    sb.append("  enabled: ").append(enabled).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  validationMessages: ").append(validationMessages).append("\n");
    sb.append("  xid: ").append(xid).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
