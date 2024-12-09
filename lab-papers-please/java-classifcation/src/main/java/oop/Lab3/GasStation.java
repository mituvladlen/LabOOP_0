package oop.Lab3;

public class GasStation implements Refuelable{
    private static int gasCarsCount = 0;
    public void refuel(int carId){
        System.out.println("Refueling gas car " + carId + ".");
        gasCarsCount++;
    }
    public static int getGasCarsCount(){
        return gasCarsCount;
    }
}