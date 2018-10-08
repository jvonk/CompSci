import java.util.Scanner;
import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Scenery"); 
        Scanner kb = new Scanner(System.in);
        System.out.print("0 for Day or 1 for Night Background: ");
        int background = kb.nextInt();
        System.out.print("0 for Cloudy or 1 for Clear Sky: ");
        int sky = kb.nextInt();
        Scenery sc = new Scenery(background, sky);
        fr.add(sc);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        sc.animate();
    }
}