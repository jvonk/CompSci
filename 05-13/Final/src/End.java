import javax.swing.*;
import java.awt.*;

public class End extends JPanel {
    public End(Frame main) {
        setLayout(null);
        JButton back = new JButton("Continue Exploring");
        back.setActionCommand("Intro");
        back.setBounds(100, 400, 400, 30);
        back.addActionListener(main);
        this.add(back);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Game Over", 100, 100);
        g.drawString("You don't win!", 100, 115);
        g.drawString("But congrats on completing the game.", 100, 130);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}