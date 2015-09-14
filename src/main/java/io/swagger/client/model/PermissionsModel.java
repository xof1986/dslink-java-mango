package io.swagger.client.model;

import io.swagger.client.model.DataPointPermissionModel;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class PermissionsModel   {
  
  private List<DataPointPermissionModel> dataPointPermissions = new ArrayList<DataPointPermissionModel>();
  private List<String> dataSourceXids = new ArrayList<String>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dataPointPermissions")
  public List<DataPointPermissionModel> getDataPointPermissions() {
    return dataPointPermissions;
  }
  public void setDataPointPermissions(List<DataPointPermissionModel> dataPointPermissions) {
    this.dataPointPermissions = dataPointPermissions;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("dataSourceXids")
  public List<String> getDataSourceXids() {
    return dataSourceXids;
  }
  public void setDataSourceXids(List<String> dataSourceXids) {
    this.dataSourceXids = dataSourceXids;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    //sb.append("class PermissionsModel {\n");
    
    sb.append("  dataPointPermissions: ").append(dataPointPermissions).append("\n");
    sb.append("  dataSourceXids: ").append(dataSourceXids).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
