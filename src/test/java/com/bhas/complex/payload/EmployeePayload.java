package com.bhas.complex.payload;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class EmployeePayload {
  private String Guid;
  private List<Employees> Employees;
}
