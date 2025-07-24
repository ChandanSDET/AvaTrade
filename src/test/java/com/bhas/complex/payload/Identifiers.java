package com.bhas.complex.payload;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Identifiers {
  private String Label;
  private String Value;
}
