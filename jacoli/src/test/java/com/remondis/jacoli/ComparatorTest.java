package com.remondis.jacoli;

import static com.remondis.jacoli.Compare.compare;
import static com.remondis.jacoli.ThisComparator.thisComparator;
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
        .andComparingCollection(A::getAs)
        .to(A::getAs)
        .using(thisComparator())
        .build()
        .compareResult(a1, a2)
        .isEqual());
  }

  @Test
  public void shouldNotBeEqual_Different_List_Items() {
    A a1 = new A("a", 1, Arrays.asList(new A("b", 2, null)));
    A a2 = new A("a", 1, Arrays.asList(new A("c", 2, null)));
    assertFalse(compare(A.class).comparing(A::getA)
        .to(A::getA)
        .using(String::compareTo)
        .andComparing(A::getInteger)
        .to(A::getInteger)
        .using(Integer::compareTo)
        .andComparingCollection(A::getAs)
        .to(A::getAs)
        .using(thisComparator())
        .build()
        .compareResult(a1, a2)
        .isEqual());
  }

  @Test
  public void shouldNotBeEqual_Null_And_Empty_Collection() {
    A a1 = new A("a", 1, null);
    A a2 = new A("a", 1, emptyList());
    assertFalse(compare(A.class).comparing(A::getA)
        .to(A::getA)
        .using(String::compareTo)
        .andComparing(A::getInteger)
        .to(A::getInteger)
        .using(Integer::compareTo)
        .andComparingCollection(A::getAs)
        .to(A::getAs)
        .using(thisComparator())
        .build()
        .compareResult(a1, a2)
        .isEqual());
  }

  @Test
  public void shouldNotBeEqual_Simple_Field_Difference() {
    A a1 = new A("a", 1, null);
    A a2 = new A("b", 1, null);
    assertFalse(compare(A.class).comparing(A::getA)
        .to(A::getA)
        .using(String::compareTo)
        .andComparing(A::getInteger)
        .to(A::getInteger)
        .using(Integer::compareTo)
        .andComparingCollection(A::getAs)
        .to(A::getAs)
        .using(thisComparator())
        .build()
        .compareResult(a1, a2)
        .isEqual());
  }

}
