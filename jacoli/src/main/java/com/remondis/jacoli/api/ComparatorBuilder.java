package com.remondis.jacoli.api;

import java.util.Comparator;

public interface ComparatorBuilder<T, V> {

  public OngoingCompareBuilder<T> using(Comparator<V> comparator);

}
