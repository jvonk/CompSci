import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Game2 g = new Game2();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter guess: ");
        int guess = kb.nextInt();
        while(g.getNumber()!=guess) {
            System.out.println((guess < g.getNumber())?"too small":"too big");
            System.out.print("Enter guess: ");
            guess=kb.nextInt();
        }
        System.out.println("You Win!");
    }
}