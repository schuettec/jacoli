package com.remondis.jacoli;

import java.util.Comparator;

public interface ComparatorCollectionBuilder<T, V> {

  public OngoingCompareCollectionBuilder<T, V> using(Comparator<V> comparator);

}
