package com.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
  String name;
  int rollNo;

  Student(String name, int rollNo){
    this.name = name;
    this.rollNo = rollNo;
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", rollNo=" + rollNo +
            '}';
  }
}

class StudentNameComparator implements Comparator {
  @Override
  public int compare(Object obj1, Object obj2) {
    Student stuObj1 = (Student) obj1;
    Student stuObj2 = (Student) obj2;
    return stuObj1.name.compareTo(stuObj2.name);
  }
}

  class StudentRollNoComparator implements Comparator {
    @Override
    public int compare(Object obj1, Object obj2) {
      Student stuObj1 = (Student) obj1;
      Student stuObj2 = (Student) obj2;
      return stuObj1.rollNo - stuObj2.rollNo;
    }
  }

class Executor{
  public static void main(String[] args) {
    ArrayList al = new ArrayList();
    al.add(new Student("Vijay",23));
    al.add(new Student("Ajay",27));
    al.add(new Student("Jai",21));
    Collections.sort(al, new StudentNameComparator());
    System.out.println(al);
  }
}


