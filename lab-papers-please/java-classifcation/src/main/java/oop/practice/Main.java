package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    mapper.enable(SerializationFeature.INDENT_OUTPUT); // Enable pretty-printing

    // Load input JSON file
    File inputFile = new File("src/main/resources/input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    // Initialize universes
//        ArrayList
    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    // Iterate through each individual in the data
    for (JsonNode entry : data) {
      // Convert JsonNode to Individual object
      Individual individual = mapper.treeToValue(entry, Individual.class);

      // Classify based on the classification logic
      int classifiedUniverse = getUniverseClassification(individual);

      // Add the individual to the appropriate universe based on the classification
      switch (classifiedUniverse) {
        case 1:
          starWars.getIndividuals().add(entry);
          break;
        case 2:
          marvel.getIndividuals().add(entry);
          break;
        case 3:
          hitchhikers.getIndividuals().add(entry);
          break;
        case 4:
          rings.getIndividuals().add(entry);
          break;
        default:
          System.out.println("Unspecified or unknown classification for individual: " + individual);
      }
    }

    // Save the classified universes into JSON files
    mapper.writeValue(new File("src/main/java/oop/practice/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/java/oop/practice/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/java/oop/practice/rings.json"), rings);
    mapper.writeValue(new File("src/main/java/oop/practice/marvel.json"), marvel);
  }

  public static int getUniverseClassification(Individual individual) {
    Boolean isHumanoid = individual.getHumanoidStatus();
    String planet = individual.getPlanet();
    Integer age = individual.getAge(); // Age can be null
    List<String> traits = individual.getTraits();

    // Star Wars Classification (Wookie and Ewok)
    if (Boolean.FALSE.equals(isHumanoid)) {
      if ("Kashyyyk".equalsIgnoreCase(planet) && age != null && age >= 0 && age <= 400 && traits != null && traits.contains("HAIRY")) {
        return 1; // Wookie
      } else if ("Endor".equalsIgnoreCase(planet) && age != null && age >= 0 && age <= 60 && traits != null && traits.contains("HAIRY") && traits.contains("SHORT")) {
        return 1; // Ewok
      }
    }

    // Lord of the Rings Universe (Elf and Dwarf)
    if ("Earth".equalsIgnoreCase(planet) && Boolean.TRUE.equals(isHumanoid)) {
      if (traits != null && traits.contains("BLONDE") && (age == null || age >= 0)) {
        return 4; // Elf
      } else if (traits != null && traits.contains("SHORT") && traits.contains("BULKY") && (age == null || age <= 200)) {
        return 4; // Dwarf
      }
    }

    // Marvel Universe Classification (Asgardian)
    if (Boolean.TRUE.equals(isHumanoid) && "Asgard".equalsIgnoreCase(planet) && age != null && age >= 0 && age <= 5000 && traits != null && traits.contains("BLONDE") && traits.contains("TALL")) {
      return 2; // Asgardian
    }

    // Hitchhiker's Guide Universe (Betelgeusian and Vogon)
    if ("Betelgeuse".equalsIgnoreCase(planet) && Boolean.TRUE.equals(isHumanoid) && age != null && age >= 0 && age <= 100 && traits != null && traits.contains("EXTRA_ARMS") && traits.contains("EXTRA_HEAD")) {
      return 3; // Betelgeusian
    } else if ("Vogsphere".equalsIgnoreCase(planet) && Boolean.FALSE.equals(isHumanoid) && age != null && age >= 0 && age <= 200 && traits != null && traits.contains("GREEN") && traits.contains("BULKY")) {
      return 3; // Vogon
    }

    // Handle characters with unknown or unspecified planets
    if (planet == null || "UNKNOWN".equalsIgnoreCase(planet)) {
      if (Boolean.FALSE.equals(isHumanoid) && traits != null && traits.contains("BULKY")) {
        return 3; // Likely Vogon
      } else if (Boolean.TRUE.equals(isHumanoid) && traits != null && traits.contains("BULKY")) {
        return 4; // Possibly a Dwarf or Vogon
      }
    }

    // Special Case for planet Endor
    if ("Endor".equalsIgnoreCase(planet)) {
      return 1; // Default to Ewok
    }

    // Generic Trait Classification
    if (traits != null) {
      if (traits.contains("GREEN") && Boolean.FALSE.equals(isHumanoid)) {
        return 3; // Vogon
      } else if (traits.contains("HAIRY") && age != null && age > 0) {
        return 1; // General hairy being (Wookie/Ewok)
      } else if (traits.contains("BLONDE") && age != null && age <= 5000 && (isHumanoid == null || Boolean.TRUE.equals(isHumanoid))) {
        return 2; // Likely Asgardian
      } else if (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD")) {
        return 3; // Betelgeusian/Vogon
      }
    }

    // Default classification based on humanoid status and age
    if (isHumanoid != null) {
      if (Boolean.TRUE.equals(isHumanoid) && (age == null || age <= 200)) {
        return 3; // Default to Vogon if no specific planet or traits
      }
    }

    // Lord of the Rings special cases
    if ("Earth".equalsIgnoreCase(planet)) {
      if (traits != null && traits.contains("BULKY") && traits.contains("SHORT")) {
        return 4; // Dwarf
      }
    } else if (Boolean.TRUE.equals(isHumanoid) && age != null && age > 5000) {
      return 4; // Long-living species (Elf-like)
    }

    // Fallback for unspecified characters
    return -1; // Unspecified character
  }

  private static boolean isStarWars(JsonNode entry) {
    return entry.hasNonNull("planet") && entry.get("planet").asText().equals("Kashyyyk")
            && entry.hasNonNull("age") && entry.get("age").asInt() <= 400
            && entry.hasNonNull("traits") && hasTraits(entry, "HAIRY", "TALL");
  }

  private static boolean isMarvel(JsonNode entry) {
    return entry.hasNonNull("planet") && entry.get("planet").asText().equals("Asgard")
            && entry.hasNonNull("age") && entry.get("age").asInt() <= 5000
            && entry.hasNonNull("traits") && hasTraits(entry, "BLONDE", "TALL");
  }

  private static boolean isHitchHiker(JsonNode entry) {
    return entry.hasNonNull("planet") && (entry.get("planet").asText().equals("Betelgeuse") || entry.get("planet").asText().equals("Vogsphere"))
            && entry.hasNonNull("age") && entry.get("age").asInt() <= 200
            && entry.hasNonNull("traits") && (hasTraits(entry, "EXTRA_ARMS", "EXTRA_HEAD") || hasTraits(entry, "GREEN", "BULKY"));
  }

  private static boolean isRings(JsonNode entry) {
    return entry.hasNonNull("planet") && entry.get("planet").asText().equals("Earth")
            && entry.hasNonNull("traits") && (hasTraits(entry, "BLONDE", "POINTY_EARS") || hasTraits(entry, "SHORT", "BULKY"));
  }

  private static boolean hasTraits(JsonNode entry, String... traits) {
    if (!entry.hasNonNull("traits")) {
      return false;
    }
    List<String> traitsList = getTraits(entry);
    for (String trait : traits) {
      if (!traitsList.contains(trait)) {
        return false;
      }
    }
    return true;
  }

  private static List<String> getTraits(JsonNode entry) {
    List<String> traits = new ArrayList<>();
    if (entry.hasNonNull("traits")) {
      for (JsonNode trait : entry.get("traits")) {
        traits.add(trait.asText());
      }
    }
    return traits;
  }

  static class Universe {
    private String name;
    private List<JsonNode> individuals;

    public Universe(String name, List<JsonNode> individuals) {
      this.name = name;
      this.individuals = individuals;
    }

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty("individuals")
    public List<JsonNode> getIndividuals() {
      return individuals;
    }
  }
}
class Individual {
  private String id;
  private String planet;
  private Integer age;
  private List<String> traits;
  private Boolean humanoidStatus;

  // Getters and Setters
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("planet")
  public String getPlanet() {
    return planet;
  }

  public void setPlanet(String planet) {
    this.planet = planet;
  }

  @JsonProperty("age")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @JsonProperty("traits")
  public List<String> getTraits() {
    return traits;
  }

  public void setTraits(List<String> traits) {
    this.traits = traits;
  }

  @JsonProperty("isHumanoid")
  public Boolean getHumanoidStatus() { // Change the return type to Boolean
    return humanoidStatus;
  }

  public void setHumanoidStatus(Boolean humanoidStatus) {
    this.humanoidStatus = humanoidStatus;
  }

  @Override
  public String toString() {
    return "Individual{" +
            "id='" + id + '\'' +
            ", planet='" + planet + '\'' +
            ", age=" + age +
            ", traits=" + traits +
            ", humanoidStatus=" + humanoidStatus +
            '}';
  }
}


