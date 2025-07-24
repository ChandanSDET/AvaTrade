package com.bhas.complex.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GeneratePayload {

  public static void main(String[] args) throws JsonProcessingException {
    for(int i = 0 ; i < 3; i++) {
      String countryCode = null, corporation = null, department = null, email = null, fullName = null, empId = null;
      Faker faker = new Faker();
      try {
        fullName = faker.name().firstName() +" "+ faker.name().lastName();
        countryCode = CountryCode.getRandom().toString();
        String corporationWithDepartment = CorporationWithDepartment.getCorporationWithDepartment(countryCode);
        corporation = corporationWithDepartment.split(":")[0];
        department = corporationWithDepartment.split(":")[1];
        email = corporationWithDepartment.split(":")[2];
        empId = RandomStringUtils.randomNumeric(6);
      } catch (Exception e) {
        e.printStackTrace();
      }
      List<Hierarchy> hierarchy = Arrays.asList(
              Hierarchy.builder().Name(faker.name().firstName()).ParentName(faker.name().fullName()).build(),
              Hierarchy.builder().Name(faker.name().firstName()).ParentName(faker.name().fullName()).build(),
              Hierarchy.builder().Name(faker.name().firstName()).ParentName(faker.name().fullName()).build(),
              Hierarchy.builder().Name(faker.name().firstName()).ParentName(null).build());

      List<Identifiers> identifiers = Arrays.asList(
              Identifiers.builder().Label("STANDARD").Value(fullName.replace(" ", ".").toLowerCase(Locale.ROOT)+"@"+Email.getRandom().toString().toLowerCase(Locale.ROOT)+".com").build(),
              Identifiers.builder().Label("STANDARD").Value(fullName.replace(" ", ".").toLowerCase(Locale.ROOT)+email).build(),
              Identifiers.builder().Label("BLOOMBERGMAIL").Value(fullName.replace(" ", ".").toLowerCase(Locale.ROOT) + "@bloomberg.net").build(),
              Identifiers.builder().Label("PHONENUMBER").Value(RandomStringUtils.randomNumeric(10)).build(),
              Identifiers.builder().Label("BB_UUID").Value(RandomStringUtils.randomNumeric(9)).build(),
              Identifiers.builder().Label("TRADINGSYSTEM").Value(fullName.split(" ")[0].toUpperCase()+RandomStringUtils.randomNumeric(2)).build());

      List<Employees> employees = Arrays.asList(Employees.builder()
              .EmployeeName(fullName)
              .BirthDate(DateUtil.getBirthDateInRange().toString())
              .HireDate(DateUtil.getHireDateInRange().toString())
              .EffectiveDate(DateUtil.getEffectiveDateInRange().toString())
              .EmployeeID(RandomStringUtils.randomAlphanumeric(4).toUpperCase()+RandomStringUtils.randomNumeric(1))
              .CountryCode(countryCode)
              .CorporationName(corporation)
              .FunctionalDepartmentNames(Arrays.asList(department))
              .Guid(new StringBuilder("EMPLOYEE").append(empId).toString())
              .Hierarchy(hierarchy)
              .TimeZone("UTC+0")
              .WorkHours("08:00/18.00")
              .InScopeOrOutOfScope("InScope")
              .Identifiers(identifiers)
              .build());

      EmployeePayload payload =  EmployeePayload.builder()
                      .Guid(new StringBuilder("TESTEMPLOYEES").append(empId).toString())
                      .Employees(employees)
                      .build();

      ObjectMapper mapper = new ObjectMapper();

      mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
      String jsonString = mapper.writeValueAsString(payload);
      System.out.println(jsonString);
    }
  }

}
