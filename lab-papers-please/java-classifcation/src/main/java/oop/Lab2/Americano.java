package oop.Lab2;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity, "Americano");
        this.mlOfWater = mlOfWater;
    }

    @Override
    public Americano makeCoffee() {
        System.out.println("Making " + name);
        printIntensity();
        System.out.println("Adding " + mlOfWater + " ml of water");
        return this;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Water: " + mlOfWater + " ml");
    }
}
