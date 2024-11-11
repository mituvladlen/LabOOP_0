package oop.Lab2;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        this.name = "PumpkinSpiceLatte";
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails(); // Calls Cappuccino's method, which includes milk
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making " + name);
        printCoffeeDetails();

        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice\n");
    }
}
