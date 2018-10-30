import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Menu m = new Menu();
        System.out.print("number please: ");
        int n = kb.nextInt();
        System.out.println("that is: "+m.selectMenu1(n));
        System.out.println("or that is: "+m.selectMenu2(n));
    }
}