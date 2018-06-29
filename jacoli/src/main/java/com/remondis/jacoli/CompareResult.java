package com.remondis.jacoli;

public class CompareResult {

  private int result;

  public CompareResult(int result) {
    super();
    this.result = result;
  }

  public int getResult() {
    return result;
  }

  public boolean isEqual() {
    return result == 0;
  }

  public boolean isNotEqual() {
    return result == 0;
  }

}
