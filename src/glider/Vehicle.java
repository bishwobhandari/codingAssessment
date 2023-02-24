package glider;

public class Vehicle {
 String model;
 int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    String getmodel(){
        return this.model;
    }

    int getYear(){
        return this.year;
    }
}
