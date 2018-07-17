package com.github.schuettec.compare;

import static java.util.Objects.isNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Function;

public class CollectionComparison<T, V> implements Comparator<T> {

  private Function<T, ? extends Collection<V>> leftHandSideValueExtractor;
  private Function<T, ? extends Collection<V>> rightHandSideValueExtractor;
  private Comparator<V> comparator;

  public CollectionComparison(Function<T, ? extends Collection<V>> leftHandSideValueExtractor,
      Function<T, ? extends Collection<V>> rightHandSideValueExtractor, Comparator<V> comparator) {
    this.leftHandSideValueExtractor = leftHandSideValueExtractor;
    this.rightHandSideValueExtractor = rightHandSideValueExtractor;
    this.comparator = comparator;
  }

  @Override
  public int compare(T o1, T o2) {
    Collection<V> c1 = leftHandSideValueExtractor.apply(o1);
    Collection<V> c2 = rightHandSideValueExtractor.apply(o2);

    if (isNull(c1) || isNull(c2)) {
      return (c1 == c2) ? 0 : -1;
    }

    if (c1.size() < c2.size()) {
      return -1;
    } else if (c1.size() > c2.size()) {
      return 1;
    } else {
      // Check element wise
      int lastResult = 0;
      Iterator<V> it1 = c1.iterator();
      Iterator<V> it2 = c2.iterator();
      for (int i = 0; i < c1.size(); i++) {
        V v1 = it1.next();
        V v2 = it2.next();
        int compare = comparator.compare(v1, v2);
        if (compare != 0) {
          lastResult = compare;
        }
      }
      return lastResult;
    }
  }

}
