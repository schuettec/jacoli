package com.remondis.jacoli.api;

import java.util.Comparator;
import java.util.function.Function;

public interface OngoingCompareBuilder<T> {

  public <V> RightCompareBuilder<T, V> andComparing(Function<T, V> leftHandSideValueExtractor);

  public Comparator<T> toComparator();

  public CompareResult compareResult(T leftHandSideInstance, T rightHandSideInstance);
}
