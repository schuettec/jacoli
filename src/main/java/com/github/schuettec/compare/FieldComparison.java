package com.github.schuettec.compare;

import java.util.Comparator;
import java.util.function.Function;

public class FieldComparison<T, V> implements Comparator<T> {

  private Function<T, V> leftHandSideValueExtractor;
  private Function<T, V> rightHandSideValueExtractor;
  private Comparator<V> comparator;

  public FieldComparison(Function<T, V> leftHandSideValueExtractor, Function<T, V> rightHandSideValueExtractor,
      Comparator<V> comparator) {
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
    this.rightHandSideValueExtractor = rightHandSideValueExtractor;
    this.comparator = comparator;
  }

  @Override
  public int compare(T o1, T o2) {
    V v1 = leftHandSideValueExtractor.apply(o1);
    V v2 = rightHandSideValueExtractor.apply(o2);
    return comparator.compare(v1, v2);
  }

}
