import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Scenery extends JPanel {
    private int background;
    private int sky;
    private int x = 0;
    public Scenery(int b, int s) {
        background=b;
        sky=s;
    }
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color lightblue = new Color(108, 206, 209);
        Color yellow = new Color(252, 212, 64);
        Color yelloworange = new Color(252, 190, 50);
        Color darkblue = new Color(24, 42, 132);
        Color offwhite = new Color(220, 240, 255);
        Color white = new Color(255, 255, 255);
        Color brown = new Color(90, 53, 10);
        Color green = new Color(58, 164, 34);
        Color lightgreen = new Color(128, 254, 84);
        Color gray = new Color(200, 200, 200);
        Color darkgray = new Color(70, 70, 70);
        Color volcanored = new Color(80, 40, 25);
        Color lavared = new Color(255, 40, 25);
        if (background==0) {
            g.setColor(lightblue);
            g.fillRect(0, 0, 800, 600);
        } else if (background==1) {
            g.setColor(darkblue);
            g.fillRect(0, 0, 800, 600);
        }
        g.setColor(yellow);
        g.fillOval(10, 10, 100, 100);
        g.setColor(yelloworange);
        g.fillOval(30, 30, 60, 60);
        if (sky==0) {
            g.setColor(offwhite);
            g.fillOval(x+25, 100, 200, 100);
            g.fillOval(x+125, 100, 200, 100);
            g.fillOval(x+75, 50, 200, 100);
            
            g.setColor(white);
            g.fillOval((2*x)%1500+225, 150, 200, 100);
            g.fillOval((2*x)%1500+325, 150, 200, 100);
            g.fillOval((2*x)%1500+275, 100, 200, 100);
            g.fillOval((2*x)%1500+325, 125, 200, 100);
            g.fillOval((2*x)%1500+425, 125, 200, 100);
            g.fillOval((2*x)%1500+375, 75, 200, 100);
        }
        g.setColor(volcanored);
        g.fillPolygon(new int[] {50, 400, 750}, new int[] {600, 300, 600}, 3);
        g.setColor(lavared);
        g.fillPolygon(new int[] {310, 400, 490, 420, 400, 380}, new int[] {375, 300, 375, 420, 380, 400}, 6);
        for (int i = 0; i < 800; i+=200) {
            g.setColor(brown);
            g.fillRect(i+100, 450, 20, 150);
            g.setColor(green);
            g.fillOval(i+60, 400, 100, 100);
            if (i<600) {
                g.setColor(gray);
                g.fillRect(i+150, 500, 100, 100);
                g.setColor(darkgray);
                g.fillPolygon(new int[] {i+140, i+200, i+260}, new int[] {500, 450, 500}, 3);
                g.fillRect(i+180, 550, 40, 50);    
            }
            g.setColor(green);
            g.fillOval(i+260, 550, 50, 30);
            g.setColor(lightgreen);
            g.fillOval(i+250, 570, 40, 40);
            g.fillOval(i+270, 570, 40, 40);
        }
    }
    public void animate() {
        while(true) {
            //wait for .1 second
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
    
            //increment x
            x+=2;
            x%=1500;
    
            //repaint the graphics drawn
            repaint();
        }
    
    }
    
}