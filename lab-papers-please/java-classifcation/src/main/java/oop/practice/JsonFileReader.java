package oop.practice;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonFileReader {

    // Method to read a file into memory and return its contents as a String
    public String readFileToString(String filePath) throws IOException {
        // Read all bytes from the file and convert them into a String
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Method to print the content of the file
    public void printFileContent(String filePath) throws IOException {
        String content = readFileToString(filePath);
        System.out.println("File Content:");
        System.out.println(content); // Print raw file content
    }

    // Method to parse the JSON file and print each object separately
    public void parseAndPrintJson(String filePath) throws IOException {
        // Read the file content as a string
        String content = readFileToString(filePath);

        // Use JSONTokener to parse the JSON data
        JSONTokener tokener = new JSONTokener(content);
        JSONObject jsonObject = new JSONObject(tokener);

        // Get the array from the "data" field in the JSON file
        JSONArray individuals = jsonObject.getJSONArray("data");

        // Loop through each object in the JSON array
        for (int i = 0; i < individuals.length(); i++) {
            // Get each individual object
            JSONObject individual = individuals.getJSONObject(i);

            // Print each individual as a separate JSON object
            System.out.println("Individual " + i + ": " + individual.toString(2)); // Pretty print with indentation
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an instance of the JsonFileReader class
        JsonFileReader jsonReader = new JsonFileReader();

        // Specify the file path (adjust to the actual location of input.json)
        String filePath = "src/main/resources/input.json";

        try {
            // Step 1: Print the content of the file to the console
            jsonReader.printFileContent(filePath);

            System.out.println();

            // Step 2: Parse the file as a JSON object and print each JSON object separately
            jsonReader.parseAndPrintJson(filePath);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
