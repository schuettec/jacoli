package com.remondis.jacoli;

import static com.remondis.jacoli.Lang.denyNull;

import java.util.HashSet;
import java.util.Set;

public class Comparator<U, V> {
  private Class<U> type1;
  private Class<V> type2;

  private Set<Comparsion> comparsions = new HashSet<>();

  public static class ComparatorBuilder<U> {
    private Class<U> type1;

    public ComparatorBuilder(Class<U> type1) {
      this.type1 = type1;
    }

    public <V> Comparator<U, V> to(Class<V> type2) {
      return new Comparator<U, V>(type1, type2);
    }
  }

  public static <U> ComparatorBuilder<U> compare(Class<U> type1) {
    return new ComparatorBuilder<U>(type1);
  }

  public Comparator(Class<U> type1, Class<V> type2) {
    this.type1 = type1;
    this.type2 = type2;
  }

  public <RS> CompareStepBuilder<U, V, RS> compare(TypedSelector<RS, U> getSelector) {
    denyNull("getSelector", getSelector);
    CompareStepBuilder<U, V, RS> stepBuilder = new CompareStepBuilder<U, V, RS>(this, type1, type2);
    stepBuilder.compare(getSelector);
    return stepBuilder;
  }

  void addComparsion(Comparsion<?> comparsion) {
    this.comparsions.add(comparsion);
  }

  @Override
  public String toString() {
    return "Comparator []";
  }

}
