package com.github.schuettec.compare;

import java.util.function.Function;

public interface RightCompareBuilder<T, V> {

  public ComparatorBuilder<T, V> to(Function<T, V> rightHandSideValueExtractor);

}
