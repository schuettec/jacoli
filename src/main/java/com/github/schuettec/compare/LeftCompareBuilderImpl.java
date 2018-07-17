package com.github.schuettec.compare;

import java.util.Collection;
import java.util.function.Function;

public class LeftCompareBuilderImpl<T> implements LeftCompareBuilder<T> {

  private ComparisonImpl<T> comparison;

  public LeftCompareBuilderImpl(ComparisonImpl<T> comparison) {
    this.comparison = comparison;
  }

  @Override
  public <V> RightCompareBuilder<T, V> comparing(Function<T, V> leftHandSideValueExtractor) {
    return new RightCompareBuilderImpl<T, V>(comparison, leftHandSideValueExtractor);
  }

  @Override
  public <V, C extends Collection<V>> RightCompareCollectionBuilder<T, V> comparingCollection(
      Function<T, C> leftHandSideValueExtractor) {
    return new RightCompareCollectionBuilderImpl<T, V>(comparison, leftHandSideValueExtractor);
  }

}
