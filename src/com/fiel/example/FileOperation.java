package com.fiel.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
  private final String fileName = "student.txt";

  public List<Student> readDataFromFile() {
    ArrayList<Student> studentList = new ArrayList<Student>();
    File file = new File(fileName);
    if (file.exists()) {

      try (FileInputStream readData = new FileInputStream(file);
          ObjectInputStream readStream = new ObjectInputStream(readData)) {
        try {
          studentList = (ArrayList) readStream.readObject();
        } catch (EOFException e) {
          System.out.println("EOF exception");
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    return studentList;
  }

  public void writeDataToFile(final Student student) {
    //write to file
    List<Student> students = readDataFromFile();
    try (FileOutputStream writeData = new FileOutputStream(fileName);
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData)) {
      if (students == null) {
        students = new ArrayList<Student>();
      }
      students.add(student);
      writeStream.writeObject(students);
      writeStream.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
