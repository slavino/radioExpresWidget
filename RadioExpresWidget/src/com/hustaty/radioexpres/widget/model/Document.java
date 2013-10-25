package com.hustaty.radioexpres.widget.model;

import java.util.List;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * User: slavino Date: 10/24/13 Time: 7:01 PM
 */
@Default(DefaultType.FIELD)
public class Document {

  @Element(name = "name")
  private String name;

  @Element(name = "description")
  private String description;

  @ElementList(entry = "Style", inline = true)
  private List<Style> styleList;

  @ElementList(entry = "Placemark", inline = true)
  private List<Placemark> placemarkList;

  public Document() {
    super();
  }

  public Document(String name, String description, List<Style> styleList, List<Placemark> placemarkList) {
    super();
    this.name = name;
    this.description = description;
    this.styleList = styleList;
    this.placemarkList = placemarkList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Style> getStyleList() {
    return styleList;
  }

  public void setStyleList(List<Style> styleList) {
    this.styleList = styleList;
  }

  public List<Placemark> getPlacemarkList() {
    return placemarkList;
  }

  public void setPlacemarkList(List<Placemark> placemarkList) {
    this.placemarkList = placemarkList;
  }

  @Override
  public String toString() {
    return "Document{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", styleList=" + styleList +
        ", placemarkList=" + placemarkList +
        '}';
  }
}
