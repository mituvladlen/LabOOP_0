package oop.Lab2;

public class SyrupCappuccino extends Coffee {
    private int mlOfMilk;
    private SyrupType syrup;

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, "SyrupCappuccino");
        this.mlOfMilk = mlOfMilk;
        this.syrup = syrup;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Milk: " + mlOfMilk + " ml");
        System.out.println("Syrup: " + syrup);
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making " + name);
        printCoffeeDetails();
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        System.out.println("Adding " + syrup + " syrup\n");
    }
}