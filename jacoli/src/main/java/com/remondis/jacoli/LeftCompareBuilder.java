package com.remondis.jacoli;

import java.util.function.Function;

public interface LeftCompareBuilder<T> {

  public <V> RightCompareBuilder<T, V> comparing(Function<T, V> leftHandSideValueExtractor);

}
