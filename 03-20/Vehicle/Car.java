public class Car extends Vehicle {
    public Car (String manufacturer) {
        super(manufacturer);
    }

    @Override
    public String myInfo() {
        return super.myInfo()+" I am a Car.";
    }
}