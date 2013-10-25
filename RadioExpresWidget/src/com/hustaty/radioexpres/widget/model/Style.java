package com.hustaty.radioexpres.widget.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;

/**
 * User: slavino Date: 10/24/13 Time: 7:10 PM
 */
@Default(DefaultType.FIELD)
public class Style {

  @Element(name = "IconStyle")
  private IconStyle iconStyle;

  @Attribute(name = "id")
  private String id;

  public IconStyle getIconStyle() {
    return iconStyle;
  }

  public void setIconStyle(IconStyle iconStyle) {
    this.iconStyle = iconStyle;
  }

  @Override
  public String toString() {
    return "Style{" +
        "iconStyle=" + iconStyle +
        '}';
  }
}
