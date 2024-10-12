package oop.practice;
import java.util.List; //for handling lists

// Individual.java
public class Individual {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private List<String> traits;

    // Constructor
    public Individual(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public void setHumanoid(boolean humanoid) {
        isHumanoid = humanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    // Print individual details
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Planet: " + planet);
        System.out.println("Is Humanoid: " + isHumanoid);
        System.out.println("Age: " + age);
        System.out.println("Traits: " + traits);
    }

    // Classify based on planet or traits
    public void classifyIndividual() {
        if (planet != null) {
            if (planet.equals("Kashyyyk") || planet.equals("Endor")) {
                System.out.println("ID " + id + " belongs to the Star Wars Universe.");
            } else if (planet.equals("Asgard") || planet.equals("Earth")) {
                System.out.println("ID " + id + " belongs to the Marvel Universe.");
            } else if (planet.equals("Betelgeuse") || planet.equals("Vogsphere")) {
                System.out.println("ID " + id + " belongs to The Hitchhicker's Guide Universe.");
            } else {
                System.out.println("ID " + id + " belongs to an Unknown Universe.");
            }
        } else if (traits.contains("EXTRA_HEAD") || traits.contains("EXTRA_ARMS")) {
            System.out.println("ID " + id + " likely belongs to The Hitchhicker's Guide Universe.");
        } else {
            System.out.println("ID " + id + " cannot be classified.");
        }
    }
    // Main method to test the functionality of the class
    public static void main(String[] args) {
        // Example of creating an individual based on data
        List<String> traits1 = List.of("HAIRY", "TALL");
        Individual individual1 = new Individual(0, false, "Kashyyyk", 253, traits1);
        individual1.printDetails();
        individual1.classifyIndividual();

        System.out.println();

        List<String> traits2 = List.of("EXTRA_ARMS", "EXTRA_HEAD");
        Individual individual2 = new Individual(1, true, "Betelgeuse", 59, traits2);
        individual2.printDetails();
        individual2.classifyIndividual();

        System.out.println();

        List<String> traits3 = List.of("SHORT", "HAIRY");
        Individual individual3 = new Individual(12, false, "Endor", 34, traits3);
        individual3.printDetails();
        individual3.classifyIndividual();
    }

}
