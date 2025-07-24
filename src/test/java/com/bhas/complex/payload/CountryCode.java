package com.bhas.complex.payload;

public enum CountryCode {
  ARG,  // --> 13:00 / 22:00
  BRA,  // --> 13:00 / 22:00
  CAN,  // --> 13:00 / 22:00
  FRA,
  DEU,
  GBR,
  USA,  // --> 13:00 / 22:00
  AUS;  // --> 04:00 / 13:00
  public static CountryCode getRandom() {
    return values()[(int) (Math.random() * values().length)];
  }

}