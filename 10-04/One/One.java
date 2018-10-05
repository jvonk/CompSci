public class One {
    private int length;
    private int width;
    public One () {
        this.length = 0;
        this.width = 0;   
    }
    public One (int length, int width) {
        this.length = length;
        this.width = width;   
    }
    public void printArea() {
        System.out.println(length*width);
    }
    public void printArea(int l, int w) {
        length = l;
        width = w;
        printArea();
    }
}