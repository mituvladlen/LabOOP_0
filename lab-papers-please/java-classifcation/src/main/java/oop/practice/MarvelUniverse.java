package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MarvelUniverse {

    public static void main(String[] args) {
        String jsonData = readFile("input.json"); // Adjust the path accordingly
        if (jsonData != null) {
            generateMarvelDetails(jsonData);
        } else {
            System.out.println("Failed to read JSON data.");
        }
    }

    public static void generateMarvelDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray inputArray = jsonObject.getJSONArray("input");

        JSONArray marvelIndividuals = new JSONArray();

        for (int i = 0; i < inputArray.length(); i++) {
            JSONObject individual = inputArray.getJSONObject(i);

            if (individual.optBoolean("isHumanoid", false) &&
                    (isCharacterFromAsgard(individual) || (hasBothRequiredTraits(individual) && !isCharacterFromEarth(individual)))) {

                // Create a new JSON object for each character and add it to the Marvel array
                JSONObject marvelCharacter = new JSONObject();
                marvelCharacter.put("id", individual.getInt("id"));
                marvelCharacter.put("isHumanoid", individual.optBoolean("isHumanoid", false));
                marvelCharacter.put("planet", individual.optString("planet", "Unknown Planet"));
                marvelCharacter.put("age", individual.optInt("age", 0));
                marvelCharacter.put("traits", individual.optJSONArray("traits"));

                marvelIndividuals.put(marvelCharacter);
            }
        }

        // Create the final JSON object
        JSONObject marvelOutput = new JSONObject();
        marvelOutput.put("name", "marvel");
        marvelOutput.put("individuals", marvelIndividuals);

        // Write the output to marvel.json
        try (FileWriter file = new FileWriter("output/marvel.json")) {
            file.write(marvelOutput.toString(4)); // Pretty print with indentation
            System.out.println("Marvel output written to marvel.json");
        } catch (IOException e) {
            e.printStackTrace();
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
