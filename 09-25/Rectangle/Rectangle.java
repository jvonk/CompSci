public class Rectangle {
    private int length;
    private int width;
    public Rectangle() {
        length=0;
        width=0;
    }
    public Rectangle(int w, int l) {
        width=w;
        length=l;
    }
    public void printArea() {
        System.out.println("Area: "+width*length);
    }
}