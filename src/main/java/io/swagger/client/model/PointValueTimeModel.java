package io.swagger.client.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Base Data Model
 **/
@ApiModel(description = "Base Data Model")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class PointValueTimeModel   {
  
  private Object value = null;
  private Long timestamp = null;

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
  private String annotation = null;

  
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
  @JsonProperty("timestamp")
  public Long getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
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
  @JsonProperty("annotation")
  public String getAnnotation() {
    return annotation;
  }
  public void setAnnotation(String annotation) {
    this.annotation = annotation;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PointValueTimeModel {\n");
    
    sb.append("  value: ").append(value).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  dataType: ").append(dataType).append("\n");
    sb.append("  annotation: ").append(annotation).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
