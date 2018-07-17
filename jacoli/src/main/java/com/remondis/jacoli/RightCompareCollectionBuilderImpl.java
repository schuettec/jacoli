package com.remondis.jacoli;

import java.util.Collection;
import java.util.function.Function;

public class RightCompareCollectionBuilderImpl<T, V> implements RightCompareCollectionBuilder<T, V> {

  private ComparisonImpl<T> comparison;
  private Function<T, ? extends Collection<V>> leftHandSideValueExtractor;

  RightCompareCollectionBuilderImpl(ComparisonImpl<T> comparison,
      Function<T, ? extends Collection<V>> leftHandSideValueExtractor) {
    this.comparison = comparison;
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
  }

  @Override
  public <C extends Collection<V>> ComparatorCollectionBuilder<T, V> to(Function<T, C> rightHandSideValueExtractor) {
    return new ComparatorCollectionBuilderImpl<>(comparison, leftHandSideValueExtractor, rightHandSideValueExtractor);
  }

}
