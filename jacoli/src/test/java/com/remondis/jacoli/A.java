package com.remondis.jacoli;

import java.util.List;

public class A {

  private String a;

  private Integer integer;

  private List<String> strings;

  public A(String a, Integer integer, List<String> strings) {
    super();
    this.a = a;
    this.integer = integer;
    this.strings = strings;
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

  public List<String> getStrings() {
    return strings;
  }

  public void setStrings(List<String> strings) {
    this.strings = strings;
  }

  @Override
  public String toString() {
    return "A [a=" + a + ", integer=" + integer + ", strings=" + strings + "]";
  }

}
