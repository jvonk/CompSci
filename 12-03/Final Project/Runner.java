import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Keyboard Demo");
        Screen sc;
        // Create panel and add it to the frame
        if (args.length == 2)
            sc = new Screen(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        else
            sc = new Screen(800, 600);
        System.setProperty("sun.java2d.opengl", "True");
        System.setProperty("sun.java2d.noddraw", "True");
        System.setProperty("sun.java2d.d3d", "False");
        frame.add(sc);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        sc.animate();

    }
}
