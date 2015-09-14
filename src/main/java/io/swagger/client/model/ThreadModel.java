package io.swagger.client.model;

import io.swagger.client.model.StackTraceElement;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class ThreadModel   {
  
  private String name = null;
  private List<StackTraceElement> location = new ArrayList<StackTraceElement>();
  private Integer priority = null;
  private Long id = null;

public enum StateEnum {
  NEW("NEW"), RUNNABLE("RUNNABLE"), BLOCKED("BLOCKED"), WAITING("WAITING"), TIMED_WAITING("TIMED_WAITING"), TERMINATED("TERMINATED");

  private String value;

  StateEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  private StateEnum state = null;
  private Long cpuTime = null;
  private Long userTime = null;

  
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
  @JsonProperty("location")
  public List<StackTraceElement> getLocation() {
    return location;
  }
  public void setLocation(List<StackTraceElement> location) {
    this.location = location;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("priority")
  public Integer getPriority() {
    return priority;
  }
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("state")
  public StateEnum getState() {
    return state;
  }
  public void setState(StateEnum state) {
    this.state = state;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("cpuTime")
  public Long getCpuTime() {
    return cpuTime;
  }
  public void setCpuTime(Long cpuTime) {
    this.cpuTime = cpuTime;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("userTime")
  public Long getUserTime() {
    return userTime;
  }
  public void setUserTime(Long userTime) {
    this.userTime = userTime;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThreadModel {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  location: ").append(location).append("\n");
    sb.append("  priority: ").append(priority).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  state: ").append(state).append("\n");
    sb.append("  cpuTime: ").append(cpuTime).append("\n");
    sb.append("  userTime: ").append(userTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
