package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HitchhikersUniverse {

    public static void main(String[] args) {
        String jsonData = readFile("src/main/resources/input.json"); // Adjust the path accordingly
        if (jsonData != null) {
            printHitchhikersDetails(jsonData);
        } else {
            System.out.println("Failed to read JSON data.");
        }
    }

    public static void printHitchhikersDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray data = jsonObject.getJSONArray("data");

        System.out.println("Hitchhiker's Universe IDs and Details:");

        for (int i = 0; i < data.length(); i++) {
            JSONObject individual = data.getJSONObject(i);

            // Print details if it has the required traits, belongs to specified planets, or is non-humanoid with specific traits
            if (hasRequiredTraits(individual) ||
                    isCharacterFromHitchhikersUniverse(individual) ||
                    isNonHumanoidWithSpecificTraits(individual)) {
                printCharacterDetails(individual);
            }
        }
    }

    private static boolean isCharacterFromHitchhikersUniverse(JSONObject individual) {
        String planet = individual.optString("planet", "Unknown Planet");
        return "Betelgeuse".equalsIgnoreCase(planet) || "Vogsphere".equalsIgnoreCase(planet);
    }

    private static boolean hasRequiredTraits(JSONObject individual) {
        JSONArray traits = individual.optJSONArray("traits");
        if (traits != null) {
            for (int j = 0; j < traits.length(); j++) {
                String trait = traits.getString(j);
                // Check for the required traits
                if ("EXTRA_ARMS".equalsIgnoreCase(trait) || "EXTRA_HEAD".equalsIgnoreCase(trait)) {
                    return true; // Return true if either trait is found
                }
            }
        }
        return false; // No required traits found
    }

    private static boolean isNonHumanoidWithSpecificTraits(JSONObject individual) {
        boolean isHumanoid = individual.optBoolean("isHumanoid", true); // Defaults to true if not specified
        JSONArray traits = individual.optJSONArray("traits");

        // Check if the character is not humanoid and has either "BULKY" or "GREEN" trait
        if (!isHumanoid && traits != null) {
            for (int j = 0; j < traits.length(); j++) {
                String trait = traits.getString(j);
                if ("BULKY".equalsIgnoreCase(trait) || "GREEN".equalsIgnoreCase(trait)) {
                    return true; // Trait found
                }
            }
        }
        return false; // No specific traits found for non-humanoids
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
