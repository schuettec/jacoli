package com.remondis.jacoli.impl;

import static java.util.Objects.nonNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import com.remondis.jacoli.CollectionComparison;
import com.remondis.jacoli.Comparison;
import com.remondis.jacoli.OngoingCompareCollectionBuilder;
import com.remondis.jacoli.RightCompareBuilder;
import com.remondis.jacoli.RightCompareCollectionBuilder;

public class OngoingCompareCollectionBuilderImpl<T, V> implements OngoingCompareCollectionBuilder<T, V> {

  private ComparisonImpl<T> comparison;
  private Function<T, ? extends Collection<V>> leftHandSideValueExtractor;
  private Function<T, ? extends Collection<V>> rightHandSideValueExtractor;
  private Comparator<V> comparator;
  private Comparator<T> toAdd;

  OngoingCompareCollectionBuilderImpl(ComparisonImpl<T> comparison,
      Function<T, ? extends Collection<V>> leftHandSideValueExtractor,
      Function<T, ? extends Collection<V>> rightHandSideValueExtractor, Comparator<V> comparator) {
    this.comparison = comparison;
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
    this.rightHandSideValueExtractor = rightHandSideValueExtractor;
    this.comparator = comparator;
  }

  @Override
  public <V1> RightCompareBuilder<T, V1> andComparing(Function<T, V1> leftHandSideValueExtractor) {
    this.toAdd = new CollectionComparison<T, V>(this.leftHandSideValueExtractor, rightHandSideValueExtractor,
        comparator);
    addComparison();
    return new RightCompareBuilderImpl<>(comparison, leftHandSideValueExtractor);
  }

  @Override
  public <V1, C extends Collection<V1>> RightCompareCollectionBuilder<T, V1> andComparingCollection(
      Function<T, C> leftHandSideValueExtractor) {
    this.toAdd = new CollectionComparison<T, V>(this.leftHandSideValueExtractor, rightHandSideValueExtractor,
        comparator);
    addComparison();
    return new RightCompareCollectionBuilderImpl<T, V1>(comparison, leftHandSideValueExtractor);
  }

  private void addComparison() {
    comparison.addComparison(toAdd);
  }

  @Override
  public Comparison<T> build() {
    if (nonNull(toAdd)) {
      addComparison();
    }
    return comparison;
  }

}
