package com.github.schuettec.compare;

import static com.github.schuettec.compare.ComparisonException.compareThrewException;
import static com.github.schuettec.compare.ComparisonException.noComparisons;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ComparisonImpl<T> implements Comparison<T>, Comparator<T> {

  private List<Comparator<T>> fieldComparisons;

  public ComparisonImpl() {
    super();
    this.fieldComparisons = new LinkedList<>();
  }

  @Override
  public CompareResult compareResult(T leftHandSideInstance, T rightHandSideInstance) {
    return new CompareResult(compare(leftHandSideInstance, rightHandSideInstance));
  }

  @Override
  public int compare(T o1, T o2) {
    Optional<Integer> result = fieldComparisons.stream()
        .map(fc -> {
          try {
            int compare = fc.compare(o1, o2);
            return compare;
          } catch (Exception e) {
            throw compareThrewException(o1, o2, e);
          }
        })
        .reduce((acc, now) -> {
          if (now != 0) {
            return now;
          } else {
            return acc;
          }
        });
    if (result.isPresent()) {
      return result.get();
    } else {
      throw noComparisons();
    }
  }

  <V> void addComparison(Comparator<T> comparison) {
    this.fieldComparisons.add(comparison);
  }

  @Override
  public Comparator<T> toComparator() {
    return this;
  }

}
