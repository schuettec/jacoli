package com.remondis.jacoli.impl;

import java.util.function.Function;

import com.remondis.jacoli.ComparatorBuilder;
import com.remondis.jacoli.RightCompareBuilder;

public class RightCompareBuilderImpl<T, V> implements RightCompareBuilder<T, V> {

  private ComparisonImpl<T> comparison;
  private Function<T, V> leftHandSideValueExtractor;

  RightCompareBuilderImpl(ComparisonImpl<T> comparison, Function<T, V> leftHandSideValueExtractor) {
    this.comparison = comparison;
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
  }

  @Override
  public ComparatorBuilder<T, V> to(Function<T, V> rightHandSideValueExtractor) {
    return new ComparatorBuilderImpl<T, V>(comparison, leftHandSideValueExtractor, rightHandSideValueExtractor);
  }

}
