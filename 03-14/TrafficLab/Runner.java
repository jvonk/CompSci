import javax.swing.*;

public class Runner {
    public Runner() {
        JFrame frame = new JFrame("Traffic Lab");
        Screen screen = new Screen();
        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        screen.update();
    }
    public static void main(String[] args) {
        new Runner();
    }
}
