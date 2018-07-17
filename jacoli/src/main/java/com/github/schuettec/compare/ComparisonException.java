package com.github.schuettec.compare;

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

  public static <T> ComparisonException compareThrewException(T o1, T o2, Exception e) {
    return new ComparisonException(String.format(
        "Comparison threw an exception for the following object:\n\t- %s\n\t- %s", o1.toString(), o2.toString()), e);

  }

}
