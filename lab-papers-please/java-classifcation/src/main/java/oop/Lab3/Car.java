package oop.Lab3;


public class Car {
    private int id;
    private String type;
    private String passengers;
    private boolean isDining;
    private int consumption;

    public Car(int id, String type, String passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public Car(){}

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPassengers() {
        return passengers;
    }

    public boolean getIsDining() {
        return isDining;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setDining(boolean isDining) {
        this.isDining = isDining;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
}