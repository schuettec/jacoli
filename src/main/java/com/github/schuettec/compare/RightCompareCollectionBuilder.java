package com.github.schuettec.compare;

import java.util.Collection;
import java.util.function.Function;

public interface RightCompareCollectionBuilder<T, V> {

  public <C extends Collection<V>> ComparatorCollectionBuilder<T, V> to(Function<T, C> rightHandSideValueExtractor);

}
