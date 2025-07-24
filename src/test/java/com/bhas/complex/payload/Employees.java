package com.bhas.complex.payload;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class Employees {

  private String Guid;
  private String EmployeeName;
  private String InScopeOrOutOfScope;
  private String HireDate;
  private String CorporationName;
  private String BirthDate;
  private String EffectiveDate;
  private String EmployeeID;
  private String TimeZone;
  private String CountryCode;
  private String WorkHours;
  private List<String> FunctionalDepartmentNames;
  private List<Hierarchy> Hierarchy;
  private List<Identifiers> Identifiers ;
}
