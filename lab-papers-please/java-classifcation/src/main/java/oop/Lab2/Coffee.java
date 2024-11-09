package oop.Lab2;


public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public void printDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }
}