package com.github.schuettec.compare;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

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
    comparison.addComparison(
        new CollectionComparison<T, V>(this.leftHandSideValueExtractor, rightHandSideValueExtractor, comparator));
    return new OngoingCompareCollectionBuilderImpl<T, V>(comparison);
  }

  @SuppressWarnings("unchecked")
  @Override
  public OngoingCompareCollectionBuilder<T, V> using(ThisComparator<T> thisComparator) {
    comparison.addComparison(new CollectionComparison<T, T>(
        (Function<T, ? extends Collection<T>>) this.leftHandSideValueExtractor,
        (Function<T, ? extends Collection<T>>) rightHandSideValueExtractor, thisComparator.thisComparator(comparison)));
    return new OngoingCompareCollectionBuilderImpl<T, V>(comparison);
  }

}
