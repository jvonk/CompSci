import javax.swing.*;

public class Runner {
    public static void main(String[] args) throws Exception {
        Frame frame = new Frame("Keyboard Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame.pack();
        frame.setVisible(true);
    }
}