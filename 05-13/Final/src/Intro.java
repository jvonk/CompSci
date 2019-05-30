import javax.swing.*;
import java.awt.*;

public class Intro extends JPanel {
    public Intro(Frame main) {
        setLayout(null);
        JButton play = new JButton("Play");
        play.setActionCommand("Play");
        play.setBounds(100, 100, 100, 100);
        play.addActionListener(main);
        this.add(play);
        JButton information = new JButton("Information");
        information.setActionCommand("Information");
        information.setBounds(400, 400, 100, 100);
        information.setLocation(400, 400);
        information.addActionListener(main);
        this.add(information);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}