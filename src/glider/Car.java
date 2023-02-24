package glider;

public class Car extends Vehicle{
    public Car(String model, int year) {
        super(model, year);
    }

    @Override
    String getmodel() {
        return "it is a car : "+super.getmodel();
    }
}
