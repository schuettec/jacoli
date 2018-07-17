package com.github.schuettec.compare;

public interface Compare {

  public static <T> LeftCompareBuilder<T> compare(Class<T> type) {
    return new LeftCompareBuilderImpl<>(new ComparisonImpl<>());
  }

}
