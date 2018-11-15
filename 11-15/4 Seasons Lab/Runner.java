import java.awt.*;
import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Four Seasons");
        Scenery sc = new Scenery();
        frame.add(sc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        sc.animate();
    }
}