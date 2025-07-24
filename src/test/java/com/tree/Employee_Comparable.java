package com.tree;

public record Employee_Comparable(String name, int age) implements Comparable{

    @Override
    public int compareTo(Object o) {
        Employee_Comparable empObj = (Employee_Comparable) o;
        if(this.name().compareTo(empObj.name()) !=0){
            return this.name().compareTo(empObj.name());
        } else {
            return this.age() - empObj.age();
        }
    }
}
