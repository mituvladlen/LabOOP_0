package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StarWarsUniverse {

    public static void main(String[] args) {
        String jsonData = readFile("src/main/resources/input.json"); // Adjust the path accordingly
        printStarWarsDetails(jsonData);
    }

    public static void printStarWarsDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray data = jsonObject.getJSONArray("data");

        System.out.println("Star Wars Universe IDs and Details:");

        for (int i = 0; i < data.length(); i++) {
            JSONObject individual = data.getJSONObject(i);

            // Check if the individual is from the Star Wars Universe
            boolean isHumanoid = individual.optBoolean("isHumanoid", false);
            String planet = individual.optString("planet", "Unknown Planet");
            boolean hasHairyTrait = hasTrait(individual, "HAIRY"); // Check for HAIRY trait

            // The character belongs to Star Wars Universe if isHumanoid is false and the planet is either Kashyyk or Endor
            if (!isHumanoid && (planet.equals("Kashyyk") || planet.equals("Endor")) || hasHairyTrait) {
                printCharacterDetails(individual);
            }
        }
    }

    private static void printCharacterDetails(JSONObject individual) {
        System.out.println("ID: " + individual.getInt("id"));
        System.out.println("Is Humanoid: " + individual.optBoolean("isHumanoid", false));
        System.out.println("Planet: " + individual.optString("planet", "Unknown Planet"));
        System.out.println("Age: " + individual.optString("age", "Unknown Age"));

        // Check if traits exist before printing
        JSONArray traits = individual.optJSONArray("traits");
        if (traits != null) {
            System.out.println("Traits: " + traits.toString());
        } else {
            System.out.println("Traits: No traits available");
        }

        System.out.println();
    }

    private static boolean hasTrait(JSONObject individual, String trait) {
        JSONArray traits = individual.optJSONArray("traits");
        if (traits != null) {
            for (int j = 0; j < traits.length(); j++) {
                if (traits.getString(j).equalsIgnoreCase(trait)) {
                    return true; // Trait found
                }
            }
        }
        return false; // Trait not found
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
