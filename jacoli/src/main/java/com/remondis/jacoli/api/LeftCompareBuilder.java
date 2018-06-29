package com.remondis.jacoli.api;

import java.util.function.Function;

public interface LeftCompareBuilder<T> {

  public <V> RightCompareBuilder<T, V> comparing(Function<T, V> leftHandSideValueExtractor);

}
