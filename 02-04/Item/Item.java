public class Item {
    private String name;
    private double value;
    public Item(String a, double b) {
        name=a;
        value=b;
    }
    public double getValue() {
        return value;
    }
    public String toString() {
        return name+" : "+value;
    }
}
