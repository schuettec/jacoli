package com.remondis.jacoli;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/**
 * Thrown if the mapping configuration has errors or if an actual mapping fails.
 */
public class ComparisonException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  ComparisonException() {
    super();
  }

  ComparisonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  ComparisonException(String message, Throwable cause) {
    super(message, cause);
  }

  ComparisonException(String message) {
    super(message);
  }

  ComparisonException(Throwable cause) {
    super(cause);
  }

  static ComparisonException zeroInteractions(String configurationMethod) {
    return new ComparisonException(String
        .format("The field selector for method '%s' tracked zero interactions with properties.", configurationMethod));
  }

  static ComparisonException multipleInteractions(String configurationMethod, List<String> trackedPropertyNames) {
    return new ComparisonException(String.format(
        "The field selector for method '%s' tracked multiple interactions with the following properties: %s."
            + " Only one interaction perfield selector is allowed!",
        configurationMethod, String.join(",", trackedPropertyNames)));
  }

  static ComparisonException notAGetter(Method method) {
    return new ComparisonException(
        String.format("The method '%s' in type %s is not a valid Java Bean property get-method.", method.getName(),
            method.getDeclaringClass()
                .getName()));
  }

  static ComparisonException noReturnTypeOnGetter(Method method) {
    return new ComparisonException(
        String.format("The method '%s' in type '%s' is not a valid getter because it has no return type.",
            method.getName(), method.getDeclaringClass()
                .getName()));
  }

  static ComparisonException invocationFailed(PropertyDescriptor property, Exception e) {
    return new ComparisonException(String.format("Invoking access method for property %s failed.", property), e);
  }

  static ComparisonException noDefaultConstructor(Class<?> type) {
    return new ComparisonException(String.format(
        "The type %s does not have a public no-args constructor and cannot be used for mapping.", type.getName()));
  }

  static ComparisonException noDefaultConstructor(Class<?> type, Exception e) {
    return new ComparisonException(String.format(
        "The type %s does not have a public no-args constructor and cannot be used for mapping.", type.getName()), e);
  }

  static ComparisonException newInstanceFailed(Class<?> type, Exception e) {
    return new ComparisonException(String.format("Creating a new instance of type %s failed.", type.getName()), e);
  }

  static ComparisonException unsupportedCollection(Collection<?> collection) {
    return new ComparisonException(String.format(
        "The collection '%s' is currently not supported. Only java.util.Set and java.util.List"
            + " are supported collections.",
        collection.getClass()
            .getName()));
  }

}
