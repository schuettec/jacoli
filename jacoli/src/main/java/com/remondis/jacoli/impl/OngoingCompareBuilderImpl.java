package com.remondis.jacoli.impl;

import java.util.Comparator;
import java.util.function.Function;

import com.remondis.jacoli.Comparison;
import com.remondis.jacoli.FieldComparison;
import com.remondis.jacoli.OngoingCompareBuilder;
import com.remondis.jacoli.RightCompareBuilder;

public class OngoingCompareBuilderImpl<T, V> implements OngoingCompareBuilder<T, V> {

  private ComparisonImpl<T> comparison;
  private Function<T, V> leftHandSideValueExtractor;
  private Function<T, V> rightHandSideValueExtractor;
  private Comparator<V> comparator;
  private Comparator<T> toAdd;

  OngoingCompareBuilderImpl(ComparisonImpl<T> comparison, Function<T, V> leftHandSideValueExtractor,
      Function<T, V> rightHandSideValueExtractor, Comparator<V> comparator) {
    this.comparison = comparison;
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
    this.rightHandSideValueExtractor = rightHandSideValueExtractor;
    this.comparator = comparator;
  }

  @Override
  public <V1> RightCompareBuilder<T, V1> andComparing(Function<T, V1> leftHandSideValueExtractor) {
    this.toAdd = new FieldComparison<>(this.leftHandSideValueExtractor, rightHandSideValueExtractor, comparator);
    addComparison();
    return new RightCompareBuilderImpl<>(comparison, leftHandSideValueExtractor);
  }

  private void addComparison() {
    comparison.addComparison(toAdd);
  }

  @Override
  public Comparison<T> build() {
    addComparison();
    return comparison;
  }

}