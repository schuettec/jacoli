package com.github.schuettec.compare;

import java.util.Collection;
import java.util.function.Function;

public interface LeftCompareBuilder<T> {

  public <V> RightCompareBuilder<T, V> comparing(Function<T, V> leftHandSideValueExtractor);

  public <V, C extends Collection<V>> RightCompareCollectionBuilder<T, V> comparingCollection(
      Function<T, C> leftHandSideValueExtractor);

}