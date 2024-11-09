package oop.Lab2;

public class Americano extends Coffee {
    private int mlOfWater;
    private final String coffeeName = "Americano";

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Adding " + mlOfWater + "ml of water");
    }
}