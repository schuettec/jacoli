package com.remondis.jacoli;

import java.lang.reflect.Method;
import java.util.Comparator;

public class Comparsion<T> {

  private Method firstMethod;
  private Method secondMethod;
  private Comparator<T> comparator;

  public Comparsion(Method firstMethod, Method secondMethod, Comparator<T> comparator) {
    this.firstMethod = firstMethod;
    this.secondMethod = secondMethod;
    this.comparator = comparator;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((firstMethod == null) ? 0 : firstMethod.hashCode());
    result = prime * result + ((secondMethod == null) ? 0 : secondMethod.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Comparsion other = (Comparsion) obj;
    if (firstMethod == null) {
      if (other.firstMethod != null)
        return false;
    } else if (!firstMethod.equals(other.firstMethod))
      return false;
    if (secondMethod == null) {
      if (other.secondMethod != null)
        return false;
    } else if (!secondMethod.equals(other.secondMethod))
      return false;
    return true;
  }

}
