package oop.Lab2;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.name = "PumpkinSpiceLatte";
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public PumpkinSpiceLatte makeCoffee() {
        System.out.println("Making " + name);
        printIntensity();
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice");
        return this;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }
}
