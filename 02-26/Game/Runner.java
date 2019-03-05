import java.util.*;
public class Runner {
    public static void main (String[] args){
        int p1c;
        int p1r;
        int p2c;
        int p2r;
        Game g1 = new Game();
        while (true){
            if (g1.checkFull()){
                System.out.println("Board Full!");
                break;
            }
            if (g1.checkTicTacToe() != 0){
                System.out.println("Player "+g1.checkTicTacToe()+" wins!");
                break;
            }
            Scanner s1 = new Scanner(System.in);
            g1.printTable();
            System.out.print("Player 1 (row): ");
            p1r = s1.nextInt();
            System.out.print("Player 1 (col): ");
            p1c = s1.nextInt();
            g1.insertXO(p1r,p1c);
            g1.printTable();
            System.out.print("Player 2 (row): ");
            p2r = s1.nextInt();
            System.out.print("Player 2 (col): ");
            p2c = s1.nextInt();
            g1.insertXO(p2r,p2c);
        }
    }
}