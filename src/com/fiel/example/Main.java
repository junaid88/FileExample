package com.fiel.example;

import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    boolean isExit = false;
    FileOperation operation = new FileOperation();
    do {
      System.out.println(
          "Please choose your category:\nPress 1\t For add student information.\nPress 2\t For see the student record"
              + ".\nPress 3\t For Quit!");

      Scanner scanner = new Scanner(System.in);
      int code = scanner.nextInt();
      switch (code) {

        case 1:
          Scanner scan = new Scanner(System.in);
          System.out.println("\t\tPlease enter your information\t\t\n");
          System.out.println("Name: ");
          String name = scan.nextLine();
          System.out.println("Age: ");
          int age = scan.nextInt();
          System.out.println("ID: ");
          int id = scan.nextInt();
          System.out.println("\n\t\tThank you!!\n ");
          operation.writeDataToFile(new Student(id, age, name));
          break;

        case 2:
          final List<Student> studentsList = operation.readDataFromFile();
          for (Student student : studentsList) {
            System.out.println(student.toString());
          }
          break;
        case 3:

          isExit = true;
          break;

        default:
      }
    } while (!isExit);
  }
}
