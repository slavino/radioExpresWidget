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

  public Kml() {
    super();
  }

  public Kml(Document document, String xmlns) {
    this.document = document;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  @Override
  public String toString() {
    return "Kml{" +
        "document=" + document +
        '}';
  }
}
