package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    JsonFileReader jsonReader = new JsonFileReader();
    String filePath = "path/to/your/input.json";

    try {
      jsonReader.printFileContent(filePath);
      System.out.println();
      jsonReader.parseAndPrintJson(filePath);
    } catch (IOException e) {
      System.err.println("Error reading the file: " + e.getMessage());
    }




  }
}