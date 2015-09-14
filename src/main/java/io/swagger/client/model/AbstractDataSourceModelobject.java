package io.swagger.client.model;

import io.swagger.client.model.Entry;
import java.util.*;
import io.swagger.client.model.PurgeSettings;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Base Data Model
 **/
@ApiModel(description = "Base Data Model")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class AbstractDataSourceModelobject   {
  
  private List<Entry> alarmLevels = new ArrayList<Entry>();
  private PurgeSettings purgeSettings = null;
  private Boolean enabled = null;
  private String name = null;
  private List<Entry> validationMessages = new ArrayList<Entry>();
  private String xid = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("alarmLevels")
  public List<Entry> getAlarmLevels() {
    return alarmLevels;
  }
  public void setAlarmLevels(List<Entry> alarmLevels) {
    this.alarmLevels = alarmLevels;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("purgeSettings")
  public PurgeSettings getPurgeSettings() {
    return purgeSettings;
  }
  public void setPurgeSettings(PurgeSettings purgeSettings) {
    this.purgeSettings = purgeSettings;
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
    sb.append("class AbstractDataSourceModelobject {\n");
    
    sb.append("  alarmLevels: ").append(alarmLevels).append("\n");
    sb.append("  purgeSettings: ").append(purgeSettings).append("\n");
    sb.append("  enabled: ").append(enabled).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  validationMessages: ").append(validationMessages).append("\n");
    sb.append("  xid: ").append(xid).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
