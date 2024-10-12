package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {

    public List<JsonNode> parseJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        List<JsonNode> jsonContent = new ArrayList<>();

        // Assuming the JSON structure has a "data" array
        for (JsonNode node : rootNode.path("data")) {
            jsonContent.add(node);
        }
        return jsonContent;
    }
}
