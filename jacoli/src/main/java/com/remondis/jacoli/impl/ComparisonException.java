package com.remondis.jacoli.impl;

public class ComparisonException extends RuntimeException {

  public ComparisonException() {
    super();
  }

  public ComparisonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ComparisonException(String message, Throwable cause) {
    super(message, cause);
  }

  public ComparisonException(String message) {
    super(message);
  }

  public ComparisonException(Throwable cause) {
    super(cause);
  }

  public static ComparisonException noComparisons() {
    return new ComparisonException("No comparisons where specified.");
  }

}
