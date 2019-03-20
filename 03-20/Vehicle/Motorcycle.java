public class Motorcycle extends Vehicle {
    public Motorcycle (String manufacturer) {
        super(manufacturer);
    }

    @Override
    public String myInfo() {
        return super.myInfo()+" I am a Motorcycle.";
    }
}