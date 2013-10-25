package com.hustaty.radioexpres.widget.model;

import org.simpleframework.xml.*;

/**
 * User: slavino Date: 10/24/13 Time: 7:00 PM
 */
@Root(name = "kml")
@Default(DefaultType.FIELD)
public class Kml {

  @Element(name = "Document")
  private Document document;

//  @Attribute(name = "xmlns", required = false)
//  private String xmlns;

  public Kml() {
    super();
  }

  public Kml(Document document, String xmlns) {
    this.document = document;
//    this.xmlns = xmlns;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

//  public String getXmlns() {
//    return xmlns;
//  }

//  public void setXmlns(String xmlns) {
//    this.xmlns = xmlns;
//  }

  @Override
  public String toString() {
    return "Kml{" +
        "document=" + document +
//        ", xmlns='" + xmlns + '\'' +
        '}';
  }
}
