package oop.Lab2;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity, "Americano");
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Water: " + mlOfWater + " ml");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making " + name);
        printCoffeeDetails();
        System.out.println("Adding " + mlOfWater + " ml of water\n");
    }
}