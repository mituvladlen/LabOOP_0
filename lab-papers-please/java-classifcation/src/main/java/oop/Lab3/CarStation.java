package oop.Lab3;


public class CarStation {
    private final Dineable diningService;
    private final Refuelable refuelingService;
    private final Queue<Car> queue;
    private static int electricConsumption = 0;
    private static int gasConsumption = 0;
    private static int totalPeople = 0;
    private static int totalRobots = 0;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void serveCars(){
        Car car = new Car();
        while (!this.queue.isEmpty()){
            car = this.queue.peek();
            System.out.println("\n ###############");
            System.out.println("Serving car " + car.getId());
            if(car.getIsDining()){
                diningService.serveDinner(car.getId());
            }
            refuelingService.refuel(car.getId());
            if(car.getType().equals("GAS")){
                gasConsumption += car.getConsumption();
            }else if(car.getType().equals("ELECTRIC")){
                electricConsumption += car.getConsumption();
            }
            if(car.getPassengers().equals("PEOPLE")){
                totalPeople++;
            }else if(car.getPassengers().equals("ROBOTS")){
                totalRobots++;
            }
            System.out.println("Finished serving car " + car.getId() + ".");
            this.queue.dequeue();
        }
        System.out.println("No cars in queue to be served");
    }

    public void addCar(Car car){
        this.queue.enqueue(car);
    }

    public Dineable getDiningService() {
        return diningService;
    }

    public Refuelable getRefuelingService() {
        return refuelingService;
    }

    public Queue<Car> getQueue() {
        return queue;
    }

    public static int getElectricConsumption() {
        return electricConsumption;
    }

    public static int getGasConsumption() {
        return gasConsumption;
    }

    public static int getTotalPeople() {
        return totalPeople;
    }

    public static int getTotalRobots() {
        return totalRobots;
    }
}