package com.github.schuettec.compare;

import java.util.Comparator;

/**
 *
 * This class is used to define a 'this-pointer' pointing to the comparator that is build currently. It can be used
 * in comparison builders to reference comparator that is currently under configuration.
 *
 * @param <T> The type that is compared by the comparator.
 */
public final class ThisComparator<T> {
  public Comparator<T> thisComparator(Comparator<T> comparator) {
    return comparator;
  }

  /**
   * @return Returns a reference provider for the comparator currently under configuration.
   */
  public static <T> ThisComparator<T> thisComparator() {
    return new ThisComparator<>();
  }
}
