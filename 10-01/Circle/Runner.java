public class Runner {
    public static void main (String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(10.0);
        c1.printCylinderVol(5.0);
        c2.printCylinderVol(5.0);
    }
}