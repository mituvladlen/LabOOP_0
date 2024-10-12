package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StarWarsUniverse {

    public static void main(String[] args) {
        String jsonData = readFile("input.json"); // Adjust the path accordingly
        if (jsonData != null) {
            generateStarWarsDetails(jsonData);
        } else {
            System.out.println("Failed to read JSON data.");
        }
    }

    public static void generateStarWarsDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray inputArray = jsonObject.getJSONArray("input");

        JSONArray starWarsIndividuals = new JSONArray();

        for (int i = 0; i < inputArray.length(); i++) {
            JSONObject individual = inputArray.getJSONObject(i);

            boolean isHumanoid = individual.optBoolean("isHumanoid", false);
            String planet = individual.optString("planet", "Unknown Planet");
            boolean hasHairyTrait = hasTrait(individual, "HAIRY");

            // The character belongs to Star Wars Universe if:
            // - they are non-humanoid and from Kashyyk or Endor
            // - OR they have the HAIRY trait
            if (!isHumanoid && (planet.equals("Kashyyk") || planet.equals("Endor")) || hasHairyTrait) {
                // Create a new JSON object for each character and add it to the Star Wars array
                JSONObject starWarsCharacter = new JSONObject();
                starWarsCharacter.put("id", individual.getInt("id"));
                starWarsCharacter.put("isHumanoid", isHumanoid);
                starWarsCharacter.put("planet", planet);
                starWarsCharacter.put("age", individual.optInt("age", 0));
                starWarsCharacter.put("traits", individual.optJSONArray("traits"));

                starWarsIndividuals.put(starWarsCharacter);
            }
        }

        // Create the final JSON object
        JSONObject starWarsOutput = new JSONObject();
        starWarsOutput.put("name", "starwars");
        starWarsOutput.put("individuals", starWarsIndividuals);

        // Write the output to starwars.json
        try (FileWriter file = new FileWriter("output/starwars.json")) {
            file.write(starWarsOutput.toString(4)); // Pretty print with indentation
            System.out.println("Star Wars output written to starwars.json");
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
