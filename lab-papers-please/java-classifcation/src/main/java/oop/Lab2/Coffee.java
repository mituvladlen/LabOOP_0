package oop.Lab2;

public abstract class Coffee {
    protected Intensity coffeeIntensity;
    protected String name;

    public Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public abstract Coffee makeCoffee();

    protected void printIntensity() {
        System.out.println("Intensity: " + coffeeIntensity);
    }

    public void printCoffeeDetails() {
        System.out.println(name + " intensity: " + coffeeIntensity);
    }
}
