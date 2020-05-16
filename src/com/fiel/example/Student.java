package com.fiel.example;

import java.io.Serializable;

public class Student implements Serializable {

  private int id;
  private int rollNumber;
  private String name;

  public Student(int id, int rollNumber, String name) {
    this.id = id;
    this.rollNumber = rollNumber;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", rollNumber=" + rollNumber + ", name='" + name + '\'' + '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRollNumber() {
    return rollNumber;
  }

  public void setRollNumber(int rollNumber) {
    this.rollNumber = rollNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
