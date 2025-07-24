package com.tree;

public record Employee(String name, int age) implements Comparable{

    @Override
    public int compareTo(Object o) {
        Employee empObj = (Employee) o;
        if(this.name().compareTo(empObj.name()) !=0){
            return this.name().compareTo(empObj.name());
        } else {
            return this.age() - empObj.age();
        }
    }
}
