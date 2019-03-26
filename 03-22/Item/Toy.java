public class Toy extends Item {
    private String name;
    private String company;
    public Toy (String a, String b, double c) {
        super(c);
        name = a;
        company=b;
    }
    public String toString() {
        return super.toString()+ " This toy is a " + name + " and is made by "+company;
    }
}