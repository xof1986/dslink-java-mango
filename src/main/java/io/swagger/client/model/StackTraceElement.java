package io.swagger.client.model;




import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class StackTraceElement   {
  
  private String fileName = null;
  private Integer lineNumber = null;
  private String className = null;
  private String methodName = null;
  private Boolean nativeMethod = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("fileName")
  public String getFileName() {
    return fileName;
  }
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("lineNumber")
  public Integer getLineNumber() {
    return lineNumber;
  }
  public void setLineNumber(Integer lineNumber) {
    this.lineNumber = lineNumber;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("className")
  public String getClassName() {
    return className;
  }
  public void setClassName(String className) {
    this.className = className;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("methodName")
  public String getMethodName() {
    return methodName;
  }
  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("nativeMethod")
  public Boolean getNativeMethod() {
    return nativeMethod;
  }
  public void setNativeMethod(Boolean nativeMethod) {
    this.nativeMethod = nativeMethod;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class StackTraceElement {\n");
    
    sb.append("  fileName: ").append(fileName).append("\n");
    sb.append("  lineNumber: ").append(lineNumber).append("\n");
    sb.append("  className: ").append(className).append("\n");
    sb.append("  methodName: ").append(methodName).append("\n");
    sb.append("  nativeMethod: ").append(nativeMethod).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
