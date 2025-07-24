package com.tree;


import java.util.ArrayList;
import java.util.Collections;

class Students implements Comparable{

  String name;
  int rollNo;

  Students(String name, int rollNo){
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

  @Override
  public int compareTo(Object o) {
    Students stuObj = (Students) o;
    if (this.name.compareTo(stuObj.name) != 0) {
      return this.name.compareTo(stuObj.name);
    }
    else {
      // we compare int values
      // if the strings are equal
      return this.rollNo - stuObj.rollNo;
    }
  }
}

class Executors{
  public static void main(String[] args) {
    ArrayList al = new ArrayList();
    al.add(new Students("Vijay",23));
    al.add(new Students("Anuj",27));
    al.add(new Students("Chandan",21));
    Collections.sort(al);
    System.out.println(al);
  }
}
