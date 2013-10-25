package com.hustaty.radioexpres.widget.model;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;

/**
 * User: slavino Date: 10/24/13 Time: 7:07 PM
 */
@Default(DefaultType.FIELD)
public class Placemark {

  @Element(name = "id")
  private Long id;

  @Element(name = "name")
  private String name;

  @Element(name = "dateUpdate")
  private Long dateUpdate;

  @Element(name = "type")
  private String type;

  @Element(name = "type_id")
  private String type_id;

  @Element(name = "kind")
  private String kind;

  @Element(name = "description")
  private String description;

  @Element(name = "region")
  private String region;

  @Element(name = "location")
  private String location;

  @Element(name = "styleUrl")
  private String styleUrl;

  @Element(name = "Point")
  private Point point;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getDateUpdate() {
    return dateUpdate;
  }

  public void setDateUpdate(Long dateUpdate) {
    this.dateUpdate = dateUpdate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType_id() {
    return type_id;
  }

  public void setType_id(String type_id) {
    this.type_id = type_id;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStyleUrl() {
    return styleUrl;
  }

  public void setStyleUrl(String styleUrl) {
    this.styleUrl = styleUrl;
  }

  public Point getPoint() {
    return point;
  }

  public void setPoint(Point point) {
    this.point = point;
  }

  @Override
  public String toString() {
    return "Placemark{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", dateUpdate=" + dateUpdate +
        ", type='" + type + '\'' +
        ", type_id='" + type_id + '\'' +
        ", kind='" + kind + '\'' +
        ", description='" + description + '\'' +
        ", region='" + region + '\'' +
        ", location='" + location + '\'' +
        ", styleUrl='" + styleUrl + '\'' +
        ", point=" + point +
        '}';
  }
}
