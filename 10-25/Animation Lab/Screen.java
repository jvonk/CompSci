import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel {
    private int sunX = 0;
    
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Colors
        Color yellow = new Color(255, 255, 0);
        Color orange = new Color(255, 200, 0);
        Color green = new Color(0, 255, 0);
        Color lightning = new Color(220, 230, 255);
        Color blue = new Color(150, 180, 255);

        g.setColor(blue);
        g.fillRect(0, 0, 800, 600);
        int te = (int)(Math.random()*800.0-400.0);
        int[] prev = new int[] {0, te};
        int[] current = new int[] {0, te};
        g.setColor(lightning);
        for (int i = 0; i < 100; i++) {
            prev=current.clone();
            current[0]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5);
            current[1]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5)+(Math.random()*5+2);
            for (int j = 0; j < 10; j++) {
                g.drawLine(prev[0]+400+j, prev[1], current[0]+400+j, current[1]);
            }
            current[0]%=800;
            current[1]%=600;
        }

        // draw grass
        g.setColor(green);
        for (int grassX = 0; grassX < 800; grassX += 10) {
            int temp = (int)(Math.random()*50.0);
            g.fillRect(grassX, 600-temp-10, 5, temp+10);
        }
        g.setColor(yellow);
        g.fillOval(sunX*5/4, 100, 50, 50);
        g.setColor(orange);
        g.fillOval(sunX*5/4+10, 110, 30, 30);
        g.setColor(Color.RED);
        g.fillOval(800-sunX, 600-sunX, 100, 100);
        g.fillPolygon(new int[] {820-sunX, 850-sunX, 880-sunX}, new int[] {670-sunX, 750-sunX, 670-sunX}, 3);
        g.setColor(Color.BLACK);
        g.fillRect(835-sunX, 735-sunX, 30, 30);
        g.setColor(Color.DARK_GRAY);
        if (sunX*3/2<350) {
        g.fillRect((int)(400.0+Math.sin(-sunX/20.0)*100.0), (int)(333.0+Math.cos(-sunX/20.0)*100.0), 20, 20);
        g.setColor(Color.BLACK);
        g.fillRect((int)(400.0+Math.sin(-sunX/20.0)*100.0)+5, (int)(333.0+Math.cos(-sunX/20.0)*100.0)+5, 10, 10);
        }
        g.setColor(Color.DARK_GRAY);

        g.fillOval(800-sunX*3/2, 500, 50, 50);
        g.fillOval(800-sunX*3/2+70, 500, 50, 50);
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(new int[] {800-sunX*3/2-30, 800-sunX*3/2, 800-sunX*3/2+110, 800-sunX*3/2+120}, new int[] {525, 475, 475, 525}, 4);
        g.setColor(Color.GRAY);
        g.fillRect(800-sunX*3/2+30, 460, 50, 15);
        g.fillRect(800-sunX*3/2+50, 430, 20, 30);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(800-sunX*3/2-10, 438, 60, 10);
        g.fillRect(800-sunX*3/2-10, 433, 10, 20);
    }

    public void animate() {
        while (true) {
            sunX++;
            sunX%=800;
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
