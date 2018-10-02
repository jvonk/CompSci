public class Circle {
    private double pi;
    private double radius;
    public Circle() {
        this.pi = 3.14;
        this.radius = 0;       
    }
    public Circle(double radius) {
        this.pi = 3.14;
        this.radius = radius;       
    }
    public void printCylinderVol(double height) {
        System.out.println(radius*radius*height*pi);
    }
}