import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Selection s = new Selection();
        while(true) {
            System.out.print("zip code please: ");
            System.out.println("that is: "+s.zipCode1(kb.nextInt()));
            System.out.print("another zip code please: ");
            System.out.println("that is: "+s.zipCode2(kb.nextInt()));
            System.out.print("yet another zip code please: ");
            System.out.println("that is: "+s.zipCode3(kb.nextInt()));
        }
    }
}