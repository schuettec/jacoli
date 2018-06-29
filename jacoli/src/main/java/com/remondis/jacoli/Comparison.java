package com.remondis.jacoli;

import java.util.Comparator;

public interface Comparison<T> {
  public CompareResult compareResult(T leftHandSideInstance, T rightHandSideInstance);

  public Comparator<T> toComparator();
}
