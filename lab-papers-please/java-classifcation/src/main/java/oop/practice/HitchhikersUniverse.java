package oop.practice;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;

public class HitchhikersUniverse {

    public static void main(String[] args) {
        try {
            String jsonData = readFile("input.json"); // Path to your input.json file
            generateHitchhikersDetails(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void generateHitchhikersDetails(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray inputArray = jsonObject.getJSONArray("input");

        JSONArray hitchhikerIndividuals = new JSONArray();

        for (int i = 0; i < inputArray.length(); i++) {
            JSONObject individual = inputArray.getJSONObject(i);
            String planet = individual.optString("planet", "Unknown");

            // Check for Betelgeuse, Vogsphere, EXTRA_ARMS, or EXTRA_HEAD
            boolean isHitchhikerPlanet = "Betelgeuse".equals(planet) || "Vogsphere".equals(planet);
            boolean hasExtraArms = individual.optJSONArray("traits") != null && individual.getJSONArray("traits").toString().contains("EXTRA_ARMS");
            boolean hasExtraHead = individual.optJSONArray("traits") != null && individual.getJSONArray("traits").toString().contains("EXTRA_HEAD");

            if (isHitchhikerPlanet || hasExtraArms || hasExtraHead) {
                JSONObject hitchhikerCharacter = new JSONObject();
                hitchhikerCharacter.put("id", individual.getInt("id"));
                hitchhikerCharacter.put("isHumanoid", individual.optBoolean("isHumanoid", false));
                hitchhikerCharacter.put("age", individual.optInt("age", 0));
                hitchhikerCharacter.put("traits", individual.optJSONArray("traits"));

                hitchhikerIndividuals.put(hitchhikerCharacter);
            }
        }

        // Create the final JSON object
        JSONObject hitchhikerOutput = new JSONObject();
        hitchhikerOutput.put("name", "hitchHiker");
        hitchhikerOutput.put("individuals", hitchhikerIndividuals);

        // Write the output to hitchhiker.json
        try (FileWriter file = new FileWriter("output/hitchhiker.json")) {
            file.write(hitchhikerOutput.toString(4));  // Pretty print with indentation
            System.out.println("Hitchhikers output written to hitchhiker.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
