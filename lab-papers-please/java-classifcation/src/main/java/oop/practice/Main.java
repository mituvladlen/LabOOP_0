package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    JsonFileReader jsonReader = new JsonFileReader();
    View view = new View(); // Create an instance of View
    String filePath = "src/main/resources/input.json"; // Adjust this path accordingly

    try {
      // Read and parse the JSON content
      List<JsonNode> jsonContent = jsonReader.parseJson(filePath);
      view.displayJsonContent(jsonContent); // Display the content using View
    } catch (IOException e) {
      view.displayMessage("Error reading the file: " + e.getMessage());
    }
  }
}
