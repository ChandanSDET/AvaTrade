package com.tree;

import java.util.Comparator;

public record Employee_Comparator(String name, int age) {
}


class Elployee_name_comparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Employee_Comparator emp_obj1 = (Employee_Comparator) o1;
        Employee_Comparator emp_obj2 = (Employee_Comparator) o2;
        return emp_obj1.name().compareTo(emp_obj2.name());
    }
}

class Elployee_age_comparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Employee_Comparator emp_obj1 = (Employee_Comparator) o1;
        Employee_Comparator emp_obj2 = (Employee_Comparator) o2;
        return emp_obj1.age()-emp_obj2.age();
    }
}
class Comparator_Executor{
    public static void main(String[] args) {

    }
}