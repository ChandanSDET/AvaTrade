package com.bhas.complex.payload;

public enum Email {
  OURBANK,
  MYBANK;
  public static Email getRandom() {
    return values()[(int) (Math.random() * values().length)];
  }
}
