public class Vehicle {
    private String manufacturer;
    public Vehicle (String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String myInfo() {
        return "My manufacturer is "+manufacturer;
    }
}