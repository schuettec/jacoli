package com.remondis.jacoli.api;

import java.util.Arrays;

import org.junit.Test;

public class ComparatorTest {

  @Test
  public void should() {
    A a1 = new A("a", 1, null);
    A a2 = new A("b", 9, Arrays.asList("A"));

    Compare.compare(A.class)
        .comparing(A::getA)
        .to(A::getA)
        .using(String::compareTo)
        .compareResult(a1, a2)
        .isEqual();
  }

}
