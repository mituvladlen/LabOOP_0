package oop.Lab2;

public class PumpkinSpiceLatte extends Coffee {
    private int mlOfMilk;
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, "PumpkinSpiceLatte");
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Milk: " + mlOfMilk + " ml");
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making " + name);
        printCoffeeDetails();
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice\n");
    }
}