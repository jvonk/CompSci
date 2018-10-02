public class Circle2 {
    private double pi;
    private double radius;
    public Circle2() {
        this.pi = 3.14;
        this.radius = 1;       
    }
    public Circle2(double radius) {
        this.pi = 3.14;
        this.radius = radius;       
    }
    public void printArea() {
        System.out.println(radius*radius*pi);
    }

    public void printArea(double radius) {
        System.out.println(radius*radius*pi);
    }
}