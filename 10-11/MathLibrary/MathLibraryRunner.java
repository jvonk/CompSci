import java.util.Scanner;
public class MathLibraryRunner {
    public static void main (String[] args) {
        MathLibrary m1 = new MathLibrary();
        Scanner kb = new Scanner(System.in);
        m1.solveQuadratic(kb.nextInt(), kb.nextInt(), kb.nextInt());
    }
}