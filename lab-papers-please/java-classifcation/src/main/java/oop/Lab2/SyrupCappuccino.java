package oop.Lab2;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private final String coffee = "Syrup Cappuccino";

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Adding syrup: " + syrup);
    }
}
