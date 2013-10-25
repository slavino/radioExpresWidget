package com.hustaty.radioexpres.widget.model;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;

/**
 * User: slavino Date: 10/24/13 Time: 7:10 PM
 */
@Default(DefaultType.FIELD)
public class IconStyle {

  @Element(name = "Icon")
  private Icon icon;

  public Icon getIcon() {
    return icon;
  }

  public void setIcon(Icon icon) {
    this.icon = icon;
  }

  @Override
  public String toString() {
    return "IconStyle{" +
        "icon=" + icon +
        '}';
  }
}
