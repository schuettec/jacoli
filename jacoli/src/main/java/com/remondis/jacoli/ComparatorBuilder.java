package com.remondis.jacoli;

import java.util.Comparator;

public interface ComparatorBuilder<T, V> {

  public OngoingCompareBuilder<T, V> using(Comparator<V> comparator);

}
