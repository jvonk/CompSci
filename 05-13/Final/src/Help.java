import javax.swing.*;
import java.awt.*;

public class Help extends JPanel {
    public Help(Frame main) {
        setLayout(null);
        JButton back = new JButton("Back");
        back.setActionCommand("Intro");
        back.setBounds(250, 400, 100, 100);
        back.addActionListener(main);
        this.add(back);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Use arrow keys or WASD to move", 100, 100);
        g.drawString("Press Space to pick up item", 100, 115);
        g.drawString("Press Space to interact with items you are near", 100, 130);
        g.drawString("Press I to show inventory", 100, 145);
        g.drawString("Click items in inventory to drop", 100, 160);
        g.drawString("Hover over items in inventory to read their text", 100, 175);
        g.drawString("Press P to cheat and finish mission", 100, 190);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}