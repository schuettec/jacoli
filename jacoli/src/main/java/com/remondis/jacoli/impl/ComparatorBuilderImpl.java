package com.remondis.jacoli.impl;

import java.util.Comparator;
import java.util.function.Function;

import com.remondis.jacoli.ComparatorBuilder;
import com.remondis.jacoli.OngoingCompareBuilder;

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
    return new OngoingCompareBuilderImpl<T, V>(comparison, leftHandSideValueExtractor, rightHandSideValueExtractor,
        comparator);
  }

}
