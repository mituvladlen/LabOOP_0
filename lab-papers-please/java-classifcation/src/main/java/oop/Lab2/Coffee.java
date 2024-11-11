package oop.Lab2;

public abstract class Coffee {
    protected Intensity coffeeIntensity;
    protected String name;

    protected Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public void printCoffeeDetails() {
        System.out.println(name + " intensity: " + coffeeIntensity);
    }

    public abstract void makeCoffee();
}