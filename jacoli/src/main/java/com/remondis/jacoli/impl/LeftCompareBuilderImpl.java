package com.remondis.jacoli.impl;

import java.util.function.Function;

import com.remondis.jacoli.LeftCompareBuilder;
import com.remondis.jacoli.RightCompareBuilder;

public class LeftCompareBuilderImpl<T> implements LeftCompareBuilder<T> {

  private ComparisonImpl<T> comparison;

  public LeftCompareBuilderImpl(ComparisonImpl<T> comparison) {
    this.comparison = comparison;
  }

  @Override
  public <V> RightCompareBuilder<T, V> comparing(Function<T, V> leftHandSideValueExtractor) {
    return new RightCompareBuilderImpl<T, V>(comparison, leftHandSideValueExtractor);
  }

}
