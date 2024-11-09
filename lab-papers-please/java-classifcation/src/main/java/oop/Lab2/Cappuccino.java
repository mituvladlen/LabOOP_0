package oop.Lab2;

public class Cappuccino extends Coffee {
    protected int mlOfMilk;

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity, "Cappuccino");
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public Cappuccino makeCoffee() {
        System.out.println("Making " + name);
        printIntensity();
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        return this;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Milk: " + mlOfMilk + " ml");
    }
}
