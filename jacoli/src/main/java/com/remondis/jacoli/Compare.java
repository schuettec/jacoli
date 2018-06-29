package com.remondis.jacoli;

import com.remondis.jacoli.impl.ComparisonImpl;
import com.remondis.jacoli.impl.LeftCompareBuilderImpl;

public interface Compare {

  public static <T> LeftCompareBuilder<T> compare(Class<T> type) {
    return new LeftCompareBuilderImpl<>(new ComparisonImpl<>());
  }

}
