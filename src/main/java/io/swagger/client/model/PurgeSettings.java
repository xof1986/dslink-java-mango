package io.swagger.client.model;

import io.swagger.client.model.TimePeriod;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class PurgeSettings   {
  
  private Boolean override = null;
  private TimePeriod frequency = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("override")
  public Boolean getOverride() {
    return override;
  }
  public void setOverride(Boolean override) {
    this.override = override;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("frequency")
  public TimePeriod getFrequency() {
    return frequency;
  }
  public void setFrequency(TimePeriod frequency) {
    this.frequency = frequency;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurgeSettings {\n");
    
    sb.append("  override: ").append(override).append("\n");
    sb.append("  frequency: ").append(frequency).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
