
/**
 * Screen
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Screen extends JPanel {
    Houses h1;
    Houses h2;
    Buildings b1;
    Buildings b2;
    Trees t1;
    Trees t2;
    int counter = 0;

    public Screen() {
        // sets up the instance variables
        h1 = new Houses(600, 320, 3, 4);
        h2 = new Houses(700, 440, 2, 2);
        b1 = new Buildings(400, 450, 2, 3);
        b2 = new Buildings(270, 330, 2, 2);
        t1 = new Trees(20, 350, 3, 2);
        t2 = new Trees(130, 470, 2, 4);
    }

    public Dimension getPreferredSize() {
        // Sets the size of the panel
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color dirtBrown = new Color(87, 59, 12);
        //50 - 100 - 50 - 0 - 50
        //0 - 50 - 0 - -50 - 0
        double pos = (Math.sin(-counter/1000.0*2.0*Math.PI)+1.0)/2.0;
        Color skyBlue = new Color((int)(135.0-115.0*(pos)), (int)(206.0-182.0*(pos)), (int)(235.0-137.0*(pos)));
        Color skyObjectColor = new Color(252, 212, 64);
        if (counter > 500) {
            skyObjectColor = new Color(245, 243, 206);
        }
        g.setColor(skyBlue);
        g.fillRect(0, 0, 800, 600);
        g.setColor(skyObjectColor);
        int skyObjectHeight = (int)(1.0*Math.sin((counter%500)/1000.0*2.0*Math.PI)*400.0);
        int skyObjectWidth = (int)(1.0*Math.cos((counter%500)/1000.0*2.0*Math.PI)*400.0)+400;
        
        g.fillOval(skyObjectWidth-50, 400 - skyObjectHeight, 100, 100);
        if (counter > 500) {
            g.setColor(skyBlue);
            g.fillOval(skyObjectWidth-10, 400 - skyObjectHeight + 15, 70, 70);
        }
        g.setColor(dirtBrown);
        g.fillRect(0, 300, 800, 300);
        h1.drawMe(g);
        b1.drawMe(g);
        t1.drawMe(g);
        h2.drawMe(g);
        b2.drawMe(g);
        t2.drawMe(g);
    }

    public void animate() {
        while (true) {
            counter++;
            counter %= 1000;
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