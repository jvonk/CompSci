public class Food extends Item {
    private String name;
    public Food (String a, double c) {
        super(c);
        name = a;
    }
    public String toString() {
        return super.toString()+ " This food item is a " + name;
    }
}