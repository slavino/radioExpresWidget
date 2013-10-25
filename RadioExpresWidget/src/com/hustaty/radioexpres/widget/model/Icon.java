package com.hustaty.radioexpres.widget.model;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;

/**
 * User: slavino Date: 10/24/13 Time: 7:11 PM
 */
@Default(DefaultType.FIELD)
public class Icon {

  @Element(name = "href")
  private String href;

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  @Override
  public String toString() {
    return "Icon{" +
        "href='" + href + '\'' +
        '}';
  }
}
