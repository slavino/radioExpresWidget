package com.hustaty.radioexpres.widget.exception;

/**
 * User: hustasl
 * Date: 2/22/13
 * Time: 1:18 PM
 */
public class RadioExpresException extends Exception {

  private static final long serialVersionUID = 1L;

  public RadioExpresException() {
    super();
  }

  public RadioExpresException(String message) {
    super(message);
  }

  public RadioExpresException(Throwable cause) {
    super(cause);
  }

  public RadioExpresException(String message, Throwable cause) {
    super(message, cause);
  }

}
