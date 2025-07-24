package com.tree;

import java.util.HashSet;
import java.util.Set;

public class Person_out {
    String name;

    Person_out(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        Set<Person_out> s = new HashSet<>();
        s.add(new Person_out("Chandan"));
        s.add(new Person_out("Chandan"));
        System.out.println(s.size());
    }
}
