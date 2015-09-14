package io.swagger.client.model;

import io.swagger.client.model.DataPointSaveHandler;
import io.swagger.client.model.TranslatableMessage;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class PointLocatorVO   {
  
  private Boolean settable = null;
  private TranslatableMessage configurationDescription = null;
  private Boolean relinquishable = null;
  private TranslatableMessage dataTypeMessage = null;
  private DataPointSaveHandler dataPointSaveHandler = null;
  private Integer dataTypeId = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("settable")
  public Boolean getSettable() {
    return settable;
  }
  public void setSettable(Boolean settable) {
    this.settable = settable;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("configurationDescription")
  public TranslatableMessage getConfigurationDescription() {
    return configurationDescription;
  }
  public void setConfigurationDescription(TranslatableMessage configurationDescription) {
    this.configurationDescription = configurationDescription;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("relinquishable")
  public Boolean getRelinquishable() {
    return relinquishable;
  }
  public void setRelinquishable(Boolean relinquishable) {
    this.relinquishable = relinquishable;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dataTypeMessage")
  public TranslatableMessage getDataTypeMessage() {
    return dataTypeMessage;
  }
  public void setDataTypeMessage(TranslatableMessage dataTypeMessage) {
    this.dataTypeMessage = dataTypeMessage;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dataPointSaveHandler")
  public DataPointSaveHandler getDataPointSaveHandler() {
    return dataPointSaveHandler;
  }
  public void setDataPointSaveHandler(DataPointSaveHandler dataPointSaveHandler) {
    this.dataPointSaveHandler = dataPointSaveHandler;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dataTypeId")
  public Integer getDataTypeId() {
    return dataTypeId;
  }
  public void setDataTypeId(Integer dataTypeId) {
    this.dataTypeId = dataTypeId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append(/*"class PointLocatorVO */"{\n");
    
    sb.append("  settable: ").append(settable).append("\n");
    sb.append("  configurationDescription: ").append(configurationDescription).append("\n");
    sb.append("  relinquishable: ").append(relinquishable).append("\n");
    sb.append("  dataTypeMessage: ").append(dataTypeMessage).append("\n");
    sb.append("  dataPointSaveHandler: ").append(dataPointSaveHandler).append("\n");
    sb.append("  dataTypeId: ").append(dataTypeId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
