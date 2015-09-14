package io.swagger.client.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class TimePeriod   {
  

public enum TypeEnum {
  MILLISECONDS("MILLISECONDS"), SECONDS("SECONDS"), MINUTES("MINUTES"), HOURS("HOURS"), DAYS("DAYS"), WEEKS("WEEKS"), MONTHS("MONTHS"), YEARS("YEARS");

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
  private Integer periods = null;

  
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

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("periods")
  public Integer getPeriods() {
    return periods;
  }
  public void setPeriods(Integer periods) {
    this.periods = periods;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimePeriod {\n");
    
    sb.append("  type: ").append(type).append("\n");
    sb.append("  periods: ").append(periods).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
