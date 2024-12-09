package oop.Lab2;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
        this.name = "SyrupCappuccino";
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails(); // Calls Cappuccino's method, which includes milk
        System.out.println("Syrup: " + syrup);
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making " + name);
        printCoffeeDetails();
        System.out.println("Adding " + syrup + " syrup\n");
    }
}
