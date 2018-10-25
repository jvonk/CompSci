import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel {
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Colors
        Color yellow = new Color(255, 255, 0);
        Color green = new Color(0, 255, 0);
        // draw grass
        g.setColor(green);
        for (int grassX = 100; grassX < 700; grassX += 10) {
            g.fillRect(grassX, 400, 5, 20);
        }
        g.fillOval(sunX, 100, 50, 50);
    }

    public void animate() {
        while (true) {
            sunX++;
            // slow it down (wait)
            try {
                Thread.sleep(10); // millisecond
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            // redraw the screen
            repaint();
        }
    }

}
