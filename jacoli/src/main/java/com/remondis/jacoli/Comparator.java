package com.remondis.jacoli;

public class Comparator<U, V> {
  private Class<U> type1;
  private Class<V> type2;

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

  public <T, RS> CompareStepBuilder<T> compare(TypedSelector<RS, T> getSelector) {

  }

}
