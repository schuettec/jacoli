package com.remondis.jacoli.api;

public class CompareResult {

  private int result;

  CompareResult(int result) {
    super();
    this.result = result;
  }

  public int getResult() {
    return result;
  }

  public boolean isEqual() {
    return result == 0;
  }

  public boolean isLower() {
    return result < 0;
  }

  public boolean isGreater() {
    return result > 0;
  }

}
