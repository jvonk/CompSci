import javax.swing.*;
import java.awt.*;

public class Help extends JPanel {
    public Help(Frame main) {
        setLayout(null);
        JButton back = new JButton("Back");
        back.setActionCommand("Intro");
        back.setBounds(250, 400, 100, 100);
        back.addActionListener(main::actionPerformed);
        this.add(back);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("arrow keys to move", 100, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}