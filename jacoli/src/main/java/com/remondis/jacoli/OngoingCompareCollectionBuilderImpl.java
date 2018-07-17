package com.remondis.jacoli;

import java.util.Collection;
import java.util.function.Function;

public class OngoingCompareCollectionBuilderImpl<T, V> implements OngoingCompareCollectionBuilder<T, V> {

  private ComparisonImpl<T> comparison;

  OngoingCompareCollectionBuilderImpl(ComparisonImpl<T> comparison) {
    this.comparison = comparison;
  }

  @Override
  public <V1> RightCompareBuilder<T, V1> andComparing(Function<T, V1> leftHandSideValueExtractor) {
    return new RightCompareBuilderImpl<>(comparison, leftHandSideValueExtractor);
  }

  @Override
  public <V1, C extends Collection<V1>> RightCompareCollectionBuilder<T, V1> andComparingCollection(
      Function<T, C> leftHandSideValueExtractor) {
    return new RightCompareCollectionBuilderImpl<T, V1>(comparison, leftHandSideValueExtractor);
  }

  @Override
  public Comparison<T> build() {
    return comparison;
  }

}
