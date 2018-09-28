public class TriangleRunner {
    public static void main (String[] args) {
        Triangle tr1 = new Triangle();
        tr1.printArea();
        Triangle tr2 = new Triangle(10, 12);
        tr2.printArea();
        tr2.update(3, 5);
        tr2.printArea();
    }
}