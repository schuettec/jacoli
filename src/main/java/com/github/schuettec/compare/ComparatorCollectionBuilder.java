package com.github.schuettec.compare;

import java.util.Comparator;

public interface ComparatorCollectionBuilder<T, V> {

  public OngoingCompareCollectionBuilder<T, V> using(Comparator<V> comparator);

  public OngoingCompareCollectionBuilder<T, V> using(ThisComparator<T> comparator);

}
