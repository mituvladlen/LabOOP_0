package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class EvenIdCharacters {

    public static void main(String[] args) {
        String jsonData = readFile("src/main/resources/input.json"); // Adjust the path accordingly
        if (jsonData != null) {
            printEvenIdCharacters(jsonData);
        } else {
            System.out.println("Failed to read JSON data.");
        }
    }

    public static void printEvenIdCharacters(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray data = jsonObject.getJSONArray("data");

        System.out.println("Characters with Even IDs:");

        for (int i = 0; i < data.length(); i++) {
            JSONObject individual = data.getJSONObject(i);
            int id = individual.getInt("id");

            // Check if the ID is even
            if (id % 2 == 0) {
                printCharacterDetails(individual);
            }
        }
    }

    private static void printCharacterDetails(JSONObject individual) {
        System.out.println("ID: " + individual.getInt("id"));
        System.out.println("Is Humanoid: " + individual.optBoolean("isHumanoid", false));
        System.out.println("Planet: " + individual.optString("planet", "Unknown Planet"));
        System.out.println("Age: " + individual.optString("age", "Unknown Age"));

        // Print traits
        JSONArray traits = individual.optJSONArray("traits");
        if (traits != null) {
            System.out.println("Traits: " + traits.toString());
        } else {
            System.out.println("Traits: No traits available");
        }

        System.out.println();
    }

    private static String readFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
