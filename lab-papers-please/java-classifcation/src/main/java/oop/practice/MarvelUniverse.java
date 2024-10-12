package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MarvelUniverse {

    public static void main(String[] args) {
        String jsonData = readFile("src/main/resources/input.json"); // Adjust the path accordingly
        if (jsonData != null) {
            printMarvelDetails(jsonData);
        } else {
            System.out.println("Failed to read JSON data.");
        }
    }

    public static void printMarvelDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray data = jsonObject.getJSONArray("data");

        System.out.println("Marvel Universe IDs and Details:");
        for (int i = 0; i < data.length(); i++) {
            JSONObject individual = data.getJSONObject(i);

            // Check if the character is humanoid and either from Asgard or has required traits (not Earth)
            if (individual.optBoolean("isHumanoid", false) &&
                    (isCharacterFromAsgard(individual) || (hasBothRequiredTraits(individual) && !isCharacterFromEarth(individual)))) {

                System.out.println("ID: " + individual.getInt("id"));
                System.out.println("Is Humanoid: " + individual.getBoolean("isHumanoid"));
                System.out.println("Planet: " + individual.optString("planet", "Unknown Planet"));

                // Check if age exists
                if (individual.has("age")) {
                    System.out.println("Age: " + individual.getInt("age"));
                } else {
                    System.out.println("Age: Not specified");
                }

                // Print traits
                JSONArray traits = individual.optJSONArray("traits");
                if (traits != null) {
                    System.out.println("Traits: " + traits.toString());
                } else {
                    System.out.println("Traits: No traits available");
                }
                System.out.println();
            }
        }
    }

    private static boolean isCharacterFromAsgard(JSONObject individual) {
        return "Asgard".equalsIgnoreCase(individual.optString("planet"));
    }

    private static boolean isCharacterFromEarth(JSONObject individual) {
        return "Earth".equalsIgnoreCase(individual.optString("planet"));
    }

    private static boolean hasBothRequiredTraits(JSONObject individual) {
        boolean hasBlonde = false;
        boolean hasTall = false;
        JSONArray traits = individual.optJSONArray("traits");

        if (traits != null) {
            for (int j = 0; j < traits.length(); j++) {
                String trait = traits.getString(j);
                if ("BLONDE".equalsIgnoreCase(trait)) {
                    hasBlonde = true;
                } else if ("TALL".equalsIgnoreCase(trait)) {
                    hasTall = true;
                }
            }
        }
        return hasBlonde && hasTall; // Return true only if both traits are found
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
