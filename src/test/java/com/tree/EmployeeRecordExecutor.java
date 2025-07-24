package com.tree;

import java.util.*;

public class EmployeeRecordExecutor {
    public static void main(String[] args) {
        List<Employee_Comparable> lstEmp =  new ArrayList<>();
        Employee_Comparable e1 = new Employee_Comparable("Chandu", 34);
        Employee_Comparable e2 = new Employee_Comparable("Ram", 24);
        Employee_Comparable e3 = new Employee_Comparable("Nandu", 30);
        Employee_Comparable e4 = new Employee_Comparable("Shyam", 33);
        Employee_Comparable e5 = new Employee_Comparable("Tapan", 28);
        Employee_Comparable e6 = new Employee_Comparable("Chandu", 18);

        lstEmp.addAll(Arrays.asList(e1,e2,e3,e4,e5, e6));
        Collections.sort(lstEmp);
        System.out.println(lstEmp);

        List<Employee_Comparator> lstEcEmp =  new ArrayList<>();
        Employee_Comparator ec1 = new Employee_Comparator("Chandu", 34);
        Employee_Comparator ec2 = new Employee_Comparator("Ram", 24);
        Employee_Comparator ec3 = new Employee_Comparator("Nandu", 30);
        Employee_Comparator ec4 = new Employee_Comparator("Shyam", 33);
        Employee_Comparator ec5 = new Employee_Comparator("Tapan", 28);
        Employee_Comparator ec6 = new Employee_Comparator("Chandu", 18);

        lstEcEmp.addAll(Arrays.asList(ec1,ec2,ec3,ec4,ec5, ec6));
        Collections.sort(lstEcEmp, new Elployee_name_comparator());
        System.out.println(lstEcEmp);

        lstEcEmp.sort(Comparator.comparing(Employee_Comparator::age));
        lstEcEmp.forEach(e -> System.out.print(e.age() + " "));
        System.out.println();
        lstEcEmp.sort(Comparator.comparing(Employee_Comparator::age).reversed());
        lstEcEmp.forEach(e -> System.out.print(e));
    }
}
