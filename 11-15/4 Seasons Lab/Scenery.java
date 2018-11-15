import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class Scenery extends JPanel {
    private RainDrop r1;
    private RainDrop[] rain;
    private int counter;
    private Tree[] trees;
    private Mountain[] mountains;
    private double[][] birds;

    public Scenery() {
        r1 = new RainDrop();
        rain = new RainDrop[100];
        trees = new Tree[100];
        mountains = new Mountain[10];
        for (int i = 0; i < rain.length; i++) {
            rain[i] = new RainDrop();
        }
        int[] ys = new int[trees.length];
        for (int i = 0; i < ys.length; i++) {
            ys[i]=(int)(Math.random()*250)+300;
        }
        Arrays.sort(ys);
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree((int)(Math.random()*800), ys[i]);
        }
        int[] ys2 = new int[mountains.length];
        for (int i = 0; i < ys2.length; i++) {
            ys2[i]=(int)(Math.random()*300)+300;
        }
        Arrays.sort(ys2);

        for (int i = 0; i < mountains.length; i++) {
            mountains[i] = new Mountain((int)(Math.random()*800)-100, ys2[i]);
        }
        counter = 0;
        birds = new double[100][4];
        for (int i = 0; i < birds.length; i++) {
            birds[i][0]=Math.random()*800;
            birds[i][1]=Math.random()*600;
            birds[i][2]=Math.random()*4-2;
            birds[i][3]=Math.random()*4-2;
        }
    }

    public Dimension getPreferredSize() {
        // Sets the size of the panel
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color dirtBrown = new Color(87, 59, 12);
        Color skyBlue = new Color(135, 206, 235);
        Color sun = new Color(252, 212, 64);

        g.setColor(skyBlue);
        g.fillRect(0, 0, 800, 300);
        g.setColor(dirtBrown);
        g.fillRect(0, 300, 800, 300);
        if (counter>1000) {
            g.setColor(sun);
            g.fillOval(50, 50, 100, 100);
        }
        for (int i = 0; i < mountains.length; i++) {
            mountains[i].drawMe(g, counter);
        }
        for (int i = 0; i < trees.length; i++) {
            trees[i].drawMe(g, counter);
        }
        for (int i = 0; i < rain.length; i++) {
            rain[i].drawMe(g, counter);
        }

        if (counter < 500 || (counter > 1000 && counter < 1500)) {
            Color offwhite = new Color(220, 240, 255);
            Color white = new Color(255, 255, 255);    
            g.setColor(offwhite);
            int x = counter%800;
            if (counter > 1000) {
                x=(counter-1200)%800;
            }
            g.fillOval((2*x)%1200+25, 100, 200, 100);
            g.fillOval((2*x)%1200+125, 100, 200, 100);
            g.fillOval((2*x)%1200+75, 50, 200, 100);
            
            g.setColor(white);
            g.fillOval((3*x)%1200-600+225, 150, 200, 100);
            g.fillOval((3*x)%1200-600+325, 150, 200, 100);
            g.fillOval((3*x)%1200-600+275, 100, 200, 100);
            g.fillOval((3*x)%1200-600+325, 125, 200, 100);
            g.fillOval((3*x)%1200-600+425, 125, 200, 100);
            g.fillOval((3*x)%1200-600+375, 75, 200, 100);
        }
        g.setColor(Color.BLACK);
        for (int i = 0; i < birds.length; i++) {
            int x = (int)(birds[i][0]);
            int y = (int)(birds[i][1]);
            g.fillPolygon(new int[] {x-40, x-20, x, x-20}, new int[] {y-20, y, y-20, y-10}, 4);
        }
        g.setColor(Color.RED);
        g.drawString((counter<1000?(counter<500?("Fall"):("Winter")):(counter<1500?("Spring"):("Summer"))), 380, 50);
    }

    public void animate() {
        while (true) {
            // wait for .01 second
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            for (int i = 0; i < rain.length; i++) {
                rain[i].move();
            }
            for (int i = 0; i < birds.length; i++) {
                birds[i][2]+=(Math.random()*4-2)/20;
                birds[i][2]*=0.999;
                birds[i][3]+=(Math.random()*4-2)/20;
                birds[i][3]*=0.999;
                birds[i][0]+=birds[i][2];
                birds[i][1]+=birds[i][3];
                if (birds[i][0]>840) birds[i][0] = 0;
                if (birds[i][1]>640) birds[i][1] = 0;
            }
            counter++;
            counter %= 2000;
            // repaint the graphics
            repaint();
        }
    }
}