package com.remondis.jacoli.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

import com.remondis.jacoli.ComparatorCollectionBuilder;
import com.remondis.jacoli.OngoingCompareCollectionBuilder;

public class ComparatorCollectionBuilderImpl<T, V> implements ComparatorCollectionBuilder<T, V> {

  private ComparisonImpl<T> comparison;
  private Function<T, ? extends Collection<V>> leftHandSideValueExtractor;
  private Function<T, ? extends Collection<V>> rightHandSideValueExtractor;

  ComparatorCollectionBuilderImpl(ComparisonImpl<T> comparison,
      Function<T, ? extends Collection<V>> leftHandSideValueExtractor,
      Function<T, ? extends Collection<V>> rightHandSideValueExtractor) {
    this.comparison = comparison;
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
    this.rightHandSideValueExtractor = rightHandSideValueExtractor;
  }

  @Override
  public OngoingCompareCollectionBuilder<T, V> using(Comparator<V> comparator) {
    return new OngoingCompareCollectionBuilderImpl<T, V>(comparison, leftHandSideValueExtractor,
        rightHandSideValueExtractor, comparator);
  }

}
