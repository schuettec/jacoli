package com.remondis.jacoli;

import static com.remondis.jacoli.Compare.compare;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ComparatorTest {

  @Test
  public void shouldBeEqual() {
    A a1 = new A("a", 1, Arrays.asList(new A("b", 2, null)));
    A a2 = new A("a", 1, Arrays.asList(new A("b", 2, null)));
    assertTrue(compare(A.class).comparing(A::getA)
        .to(A::getA)
        .using(String::compareTo)
        .andComparing(A::getInteger)
        .to(A::getInteger)
        .using(Integer::compareTo)
        .build()
        .compareResult(a1, a2)
        .isEqual());
  }

  @Test
  public void shouldNotBeEqual() {
    A a1 = new A("a", 1, null);
    A a2 = new A("b", 1, emptyList());
    assertFalse(compare(A.class).comparing(A::getA)
        .to(A::getA)
        .using(String::compareTo)
        .andComparing(A::getInteger)
        .to(A::getInteger)
        .using(Integer::compareTo)
        .build()
        .compareResult(a1, a2)
        .isEqual());
  }

}
