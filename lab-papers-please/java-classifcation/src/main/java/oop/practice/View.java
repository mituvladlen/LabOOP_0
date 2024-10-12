package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class View {

    // Method to display JSON content
    public void displayJsonContent(List<JsonNode> jsonContent) {
        for (JsonNode node : jsonContent) {
            // Check and print ID
            if (node.has("id")) {
                System.out.println("ID: " + node.get("id").asInt());
            } else {
                System.out.println("ID: Not specified");
            }

            // Check and print Is Humanoid
            if (node.has("isHumanoid")) {
                System.out.println("Is Humanoid: " + node.get("isHumanoid").asBoolean());
            } else {
                System.out.println("Is Humanoid: Not specified");
            }

            // Check and print Planet
            if (node.has("planet")) {
                System.out.println("Planet: " + node.get("planet").asText());
            } else {
                System.out.println("Planet: Not specified");
            }

            // Check and print Age
            if (node.has("age")) {
                System.out.println("Age: " + node.get("age").asText());
            } else {
                System.out.println("Age: Not specified");
            }

            // Print traits if they exist
            if (node.has("traits")) {
                System.out.println("Traits: " + node.get("traits").toString());
            } else {
                System.out.println("Traits: No traits available");
            }

            System.out.println(); // Print a blank line for better readability
        }
    }

    // Method to display error messages or other messages
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
