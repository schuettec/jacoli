package com.remondis.jacoli;

import java.util.List;

public class A {

  private String a;

  private Integer integer;

  private List<A> as;

  public A(String a, Integer integer, List<A> as) {
    super();
    this.a = a;
    this.integer = integer;
    this.as = as;
  }

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }

  public Integer getInteger() {
    return integer;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }

  public List<A> getAs() {
    return as;
  }

  public void setAs(List<A> as) {
    this.as = as;
  }

  @Override
  public String toString() {
    return "A [a=" + a + ", integer=" + integer + ", as=" + as + "]";
  }

}
