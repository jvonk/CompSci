public class Triangle {
    private int height;
    private int base;
    public Triangle () {
        this.height = 0;
        this.base = 0;
    }
    public Triangle (int height, int base) {
        this.height = height;
        this.base = base;
    }
    public void update (int height, int base) {
        this.height = height;
        this.base = base;
    }
    public void printArea() {
        System.out.println("Area: "+height*base*0.5);
    }
}