package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LordOfTheRingsUniverse {

    public static void main(String[] args) {
        String jsonData = readFile("src/main/resources/input.json"); // Adjust the path accordingly
        printLotRDetails(jsonData);
    }

    public static void printLotRDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray data = jsonObject.getJSONArray("data");

        System.out.println("Lord of the Rings Universe IDs and Details:");

        for (int i = 0; i < data.length(); i++) {
            JSONObject individual = data.getJSONObject(i);

            // Check if the individual is from the Lord of the Rings Universe
            String planet = individual.optString("planet", "Unknown Planet");
            boolean hasPointyEarsTrait = hasTrait(individual, "POINTY_EARS"); // Check for POINTY_EARS trait

            // Check if age exists and is greater than 5000
            int age = individual.optInt("age", -1); // Use -1 if age is not specified

            // The character belongs to the Lord of the Rings Universe if the planet is Earth or has POINTY_EARS trait
            if (planet.equals("Earth") || hasPointyEarsTrait ||
                    (individual.optBoolean("isHumanoid", false) && hasTrait(individual, "BULKY")) ||
                    (age > 5000)) {
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
