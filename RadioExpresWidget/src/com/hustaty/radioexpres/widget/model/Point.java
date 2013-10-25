package com.hustaty.radioexpres.widget.model;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;

/**
 * User: slavino Date: 10/24/13 Time: 7:09 PM
 */
@Default(DefaultType.FIELD)
public class Point {

  @Element(name = "coordinates")
  private String coordinates;

  public String getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public String toString() {
    return "Point{" +
        "coordinates='" + coordinates + '\'' +
        '}';
  }
}
