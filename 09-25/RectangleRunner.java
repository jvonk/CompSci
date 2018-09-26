import java.util.Scanner;

public class RectangleRunner {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Scanner kb = new Scanner(System.in);
        r1.printArea();
        
        System.out.print("Width: ");
        int width = kb.nextInt();
        System.out.print("Length: ");
        int length = kb.nextInt(); 
        Rectangle r2 = new Rectangle(width, length);
        r2.printArea();
    }
}