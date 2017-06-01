package io.swagger.client.model;

import io.swagger.client.model.PermissionsModel;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * User Data Model
 **/
@ApiModel(description = "User Data Model")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class UserModel   {
  
  private String password = null;
  private String email = null;
  private Boolean muted = null;

  public enum ReceiveAlarmEmailsEnum {
    NONE("NONE"), INFORMATION("INFORMATION"), URGENT("URGENT"), CRITICAL("CRITICAL"), LIFE_SAFETY("LIFE_SAFETY"),
    DO_NOT_LOG("DO_NOT_LOG"), IGNORE("IGNORE");

    private String value;

    ReceiveAlarmEmailsEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  private ReceiveAlarmEmailsEnum receiveAlarmEmails = null;
  private Boolean disabled = null;
  private String username = null;
  private PermissionsModel permissions = null;
  private String homeUrl = null;
  private String timezone = null;
  private String systemTimezone = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("muted")
  public Boolean getMuted() {
    return muted;
  }
  public void setMuted(Boolean muted) {
    this.muted = muted;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("receiveAlarmEmails")
  public ReceiveAlarmEmailsEnum getReceiveAlarmEmails() {
    return receiveAlarmEmails;
  }
  public void setReceiveAlarmEmails(ReceiveAlarmEmailsEnum receiveAlarmEmails) {
    this.receiveAlarmEmails = receiveAlarmEmails;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("disabled")
  public Boolean getDisabled() {
    return disabled;
  }
  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("permissions")
  public PermissionsModel getPermissions() {
    return permissions;
  }
  public void setPermissions(PermissionsModel permissions) {
    this.permissions = permissions;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("homeUrl")
  public String getHomeUrl() {
    return homeUrl;
  }
  public void setHomeUrl(String homeUrl) {
    this.homeUrl = homeUrl;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("timezone")
  public String getTimezone() {
    return timezone;
  }
  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("systemTimezone")
  public String getSystemTimezone() {
    return systemTimezone;
  }
  public void setSystemTimezone(String systemTimezone) {
    this.systemTimezone = systemTimezone;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append(/*"class UserModel */ "{\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  permissions: {\n").append(permissions);
    sb.append("  disabled: ").append(disabled).append("\n");
    sb.append("  password: ").append(password).append("\n");
    sb.append("  homeUrl: ").append(homeUrl).append("\n");
    sb.append("  receiveAlarmEmails: ").append(receiveAlarmEmails).append("\n");
    sb.append("  muted: ").append(muted).append("\n");
    sb.append("  timezone: ").append(timezone).append("\n");
    sb.append("  systemTimezone: ").append(systemTimezone).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
