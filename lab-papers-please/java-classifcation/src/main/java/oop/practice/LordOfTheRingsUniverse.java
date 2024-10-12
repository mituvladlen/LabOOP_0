package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LordOfTheRingsUniverse {

    public static void main(String[] args) {
        String jsonData = readFile("input.json"); // Adjust the path accordingly
        generateLotRDetails(jsonData);
    }

    public static void generateLotRDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray inputArray = jsonObject.getJSONArray("input");

        JSONArray lotrIndividuals = new JSONArray();

        for (int i = 0; i < inputArray.length(); i++) {
            JSONObject individual = inputArray.getJSONObject(i);

            String planet = individual.optString("planet", "Unknown");
            int age = individual.optInt("age", -1);  // Use -1 if age is not provided
            boolean hasPointyEarsTrait = hasTrait(individual, "POINTY_EARS");

            // Conditions for a Lord of the Rings character:
            // - From planet Earth
            // - Has POINTY_EARS trait
            // - IsHumanoid and has BULKY trait
            // - Age greater than 5000
            if (planet.equals("Earth") || hasPointyEarsTrait ||
                    (individual.optBoolean("isHumanoid", false) && hasTrait(individual, "BULKY")) ||
                    age > 5000) {
                // Add individual to the output
                JSONObject lotrCharacter = new JSONObject();
                lotrCharacter.put("id", individual.getInt("id"));
                lotrCharacter.put("isHumanoid", individual.optBoolean("isHumanoid", false));
                lotrCharacter.put("age", individual.optInt("age", 0));
                lotrCharacter.put("traits", individual.optJSONArray("traits"));

                lotrIndividuals.put(lotrCharacter);
            }
        }

        // Create the final JSON object
        JSONObject lotrOutput = new JSONObject();
        lotrOutput.put("name", "rings");
        lotrOutput.put("individuals", lotrIndividuals);

        // Write the output to rings.json
        try (FileWriter file = new FileWriter("output/rings.json")) {
            file.write(lotrOutput.toString(4));  // Pretty print with indentation
            System.out.println("Lord of the Rings output written to rings.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
