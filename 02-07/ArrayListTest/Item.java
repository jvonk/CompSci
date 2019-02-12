import java.util.*;
public class Item implements Comparable {
    private double price;
    private String name;
    public Item(double a, String b) {
        price = a;
        name = b;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return name + " : " + price;
    }
    @Override
    public int compareTo(Object b) {
        return Double.compare(this.price, ((Item)b).getPrice());
    }
}
