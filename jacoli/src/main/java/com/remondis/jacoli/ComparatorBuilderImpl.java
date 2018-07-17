package com.remondis.jacoli;

import java.util.Comparator;
import java.util.function.Function;

public class ComparatorBuilderImpl<T, V> implements ComparatorBuilder<T, V> {

  private ComparisonImpl<T> comparison;
  private Function<T, V> leftHandSideValueExtractor;
  private Function<T, V> rightHandSideValueExtractor;

  ComparatorBuilderImpl(ComparisonImpl<T> comparison, Function<T, V> leftHandSideValueExtractor,
      Function<T, V> rightHandSideValueExtractor) {
    this.comparison = comparison;
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
    this.rightHandSideValueExtractor = rightHandSideValueExtractor;
  }

  @Override
  public OngoingCompareBuilder<T, V> using(Comparator<V> comparator) {
    comparison
        .addComparison(new FieldComparison<>(this.leftHandSideValueExtractor, rightHandSideValueExtractor, comparator));
    return new OngoingCompareBuilderImpl<T, V>(comparison, leftHandSideValueExtractor, rightHandSideValueExtractor,
        comparator);
  }

}
