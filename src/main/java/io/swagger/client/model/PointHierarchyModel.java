package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;


/**
 * Base Data Model
 **/
@ApiModel(description = "Base Data Model")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class PointHierarchyModel   {
  
  private String name = null;
  private Number id = null;
  private List<DataPointSummaryModel> points = new ArrayList<DataPointSummaryModel>();
  private List<PointHierarchyModel> subfolders = new ArrayList<PointHierarchyModel>();

  
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
  @JsonProperty("id")
  public Number getId() {
    return id;
  }

  public void setId(Number id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("points")
  public List<DataPointSummaryModel> getPoints() {
    return points;
  }
  public void setPoints(List<DataPointSummaryModel> points) {
    this.points = points;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("subfolders")
  public List<PointHierarchyModel> getSubfolders() {
    return subfolders;
  }
  public void setSubfolders(List<PointHierarchyModel> subfolders) {
    this.subfolders = subfolders;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append(/*"class PointHierarchyModel */"{\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  points: ").append(points).append("\n");
    sb.append("  subfolders: ").append(subfolders).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
