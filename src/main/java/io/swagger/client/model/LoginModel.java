package io.swagger.client.model;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User Data Model
 **/
@ApiModel(description = "Login Data Model")
public class LoginModel {
    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username = null;
    private String password = null;

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
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(/*"class LoginModel */ "{\n");
        sb.append("  username: ").append(username).append("\n");
        sb.append("  password: ").append(password).append("\n");
        return sb.toString();
    }
}
