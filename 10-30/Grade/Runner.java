import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("three scores each on their own line please: ");
        Grade g = new Grade(kb.nextInt(), kb.nextInt(), kb.nextInt());
        System.out.println(g.checkPass());
    }
}