package oop.Lab2;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.name = "SyrupCappuccino";
        this.syrup = syrup;
    }

    @Override
    public SyrupCappuccino makeCoffee() {
        System.out.println("Making " + name);
        printIntensity();
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        System.out.println("Adding " + syrup + " syrup");
        return this;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup: " + syrup);
    }
}
