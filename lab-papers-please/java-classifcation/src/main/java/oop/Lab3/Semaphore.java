package oop.Lab3;

public class Semaphore {
    private final CarStation peopleGas;
    private final CarStation robotsGas;
    private final CarStation peopleElectric;
    private final CarStation robotsElectric;

    public Semaphore(CarStation peopleGas, CarStation peopleElectric, CarStation robotsGas, CarStation robotsElectric) {
        this.peopleGas = peopleGas;
        this.peopleElectric = peopleElectric;
        this.robotsGas = robotsGas;
        this.robotsElectric = robotsElectric;
    }

    public void sortCars(Car car){
        if(car.getPassengers().equals("PEOPLE") && car.getType().equals("GAS")){
            this.peopleGas.addCar(car);
            System.out.println("Car nr. " + car.getId()+ " was assigned to People and Gas Car Station");
        }else if(car.getPassengers().equals("PEOPLE") && car.getType().equals("ELECTRIC")){
            this.peopleElectric.addCar(car);
            System.out.println("Car nr. " + car.getId()+ " was assigned to People and Electric Car Station");
        }else if(car.getPassengers().equals("ROBOTS") && car.getType().equals("ELECTRIC")){
            this.robotsElectric.addCar(car);
            System.out.println("Car nr. " + car.getId()+ " was assigned to Robots and Electric Car Station");
        }else if(car.getPassengers().equals("ROBOTS") && car.getType().equals("GAS")){
            this.robotsGas.addCar(car);
            System.out.println("Car nr. " + car.getId()+ " was assigned to Robots and Gas Car Station");
        }
    }

    public CarStation getRobotsGas() {
        return robotsGas;
    }

    public CarStation getPeopleGas() {
        return peopleGas;
    }

    public CarStation getPeopleElectric() {
        return peopleElectric;
    }

    public CarStation getRobotsElectric() {
        return robotsElectric;
    }
}