package com.remondis.jacoli;

import static com.remondis.jacoli.ComparisonException.multipleInteractions;
import static com.remondis.jacoli.ComparisonException.zeroInteractions;

import java.lang.reflect.Method;
import java.util.List;

public class CompareStepBuilder<U, V, RS> implements ComparatorStepBuilder<U, V, RS> {
  static final String LEFT_TYPE = "left-hand side compare type";
  static final String RIGHT_TYPE = "right-hand side compare type";

  private Comparator<U, V> comparator;

  private Class<U> type1;
  private Class<V> type2;

  private Method firstMethod;
  private Method secondMethod;

  public CompareStepBuilder(Comparator<U, V> comparator, Class<U> type1, Class<V> type2) {
    this.comparator = comparator;
    this.type1 = type1;
    this.type2 = type2;
  }

  void compare(TypedSelector<RS, U> getSelector) {
    Method method = trackMethod(LEFT_TYPE, type1, getSelector);
    this.firstMethod = method;
  }

  ComparatorStepBuilder<U, V, RS> to(TypedSelector<RS, V> getSelector) {
    Method method = trackMethod(RIGHT_TYPE, type2, getSelector);
    this.secondMethod = method;
    return this;
  }

  @Override
  public Comparator<U, V> using(java.util.Comparator<RS> comparator) {
    this.comparator.addComparsion(new Comparsion(firstMethod, secondMethod, comparator));
    return this.comparator;
  }

  private <UV> Method trackMethod(String side, Class<UV> type, TypedSelector<RS, UV> getSelector) {
    Method method = null;
    InvocationSensor<UV> invocationSensor = new InvocationSensor<UV>(type);
    UV sensor = invocationSensor.getSensor();
    // perform the selector lambda on the sensor
    getSelector.selectField(sensor);
    // if any property interaction was tracked...
    if (invocationSensor.hasTrackedMethods()) {
      // ...make sure it was exactly one property interaction
      List<Method> trackedMethod = invocationSensor.getTrackedMethods();
      denyMultipleInteractions(side, trackedMethod);
      method = trackedMethod.get(0);
    } else {
      throw zeroInteractions(side);
    }
    return method;
  }

  static void denyMultipleInteractions(String configurationMethod, List<Method> trackedMethod) {
    if (trackedMethod.size() > 1) {
      throw multipleInteractions(configurationMethod, trackedMethod);
    }
  }

}
