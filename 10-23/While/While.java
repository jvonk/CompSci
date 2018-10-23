import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            System.out.println(i);
        }
        for (int i = 5; i <= 31; i++) {
            System.out.println(i);
        }
        for (int i = 39; i >= 21; i--) {
            System.out.println(i);
        }
        for (int i = 2; i <= 20; i+=2) {
            System.out.println(i);
        }
        for (int i = 15; i >= -10; i-=5) {
            System.out.println(i);
        }
        Scanner kb = new Scanner(System.in);
        System.out.print("number greater than 20: ");
        int max = kb.nextInt();
        System.out.print("what to count by: ");
        int change = kb.nextInt();
        for (int i = 1; i <= max; i+=change) {
            System.out.println(i);
        }

        System.out.print("a number: ");
        int num = kb.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.print("a number greater than 1: ");
        int num2 = kb.nextInt();
        int sum = 0;
        for (int i = 1; i <= num2; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }    
}