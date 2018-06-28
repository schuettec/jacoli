package com.remondis.jacoli;

public interface ComparatorStepBuilder<U, V, T> {

  public com.remondis.jacoli.Comparator<U, V> using(java.util.Comparator<T> comparator);

}
