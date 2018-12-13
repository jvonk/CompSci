import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Heart {
    private double initX, x, initY, y, width, height, vel;
    private Color color;
    private boolean dead = false;

    public Heart(double x, double y, double inVel) {
        this.initX = x;
        this.x = Math.random()*20000+initX;

        this.initY = y;
        this.y = this.initY;

        this.width = 40;
        this.height = 40;

        this.vel=inVel; 
        this.color = new Color(255, 0, 0);
    }


    public boolean getDead() {
        return dead;
    }
    public double getaX() {
        return x;
    }

    public double getaY() {
        return y;
    }

    public double getaWidth() {
        return width;
    }

    public double getaHeight() {
        return height;
    }

    public void drawHeart(Graphics g, int x, int y, int width, int height) {
        int[] triangleX = {
                x - 2*width/18,
                x + width + 2*width/18,
                (x - 2*width/18 + x + width + 2*width/18)/2};
        int[] triangleY = { 
                y + height - 2*height/3, 
                y + height - 2*height/3, 
                y + height };
        g.fillOval(
                x - width/12,
                y, 
                width/2 + width/6, 
                height/2); 
        g.fillOval(
                x + width/2 - width/12,
                y,
                width/2 + width/6,
                height/2);
        g.fillPolygon(triangleX, triangleY, triangleX.length);
    }
    
    public void drawMe(Graphics g) {
        if (!dead) {

            Graphics2D g2 = (Graphics2D) g;
            int[] triangleX = {
                (int)(x - 2*width/18),
                (int)(x + width + 2*width/18),
                (int)((x - 2*width/18 + x + width + 2*width/18)/2)};
        int[] triangleY = { 
            (int)(y + height - 2*height/3), 
            (int)(y + height - 2*height/3), 
            (int)(y + height)};
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillOval(
                (int)(x - width/12),
                (int)(y), 
                (int)(width/2 + width/6), 
                (int)(height/2)); 
        g2.fillOval(
                (int)(x + width/2 - width/12),
                (int)(y),
                (int)(width/2 + width/6),
                (int)(height/2));
        g2.fillPolygon(triangleX, triangleY, triangleX.length);

        }
    }

    public void moveUp() {
        if (Math.random() < 0.3)
            y -= this.vel==2?3:1;
        if (y < 0)
            y = 620;
    }

    public void moveDown() {
        if (Math.random() < 0.3)
            y += this.vel==2?2.5:1;
        if (y > 600-height)
            y = -20;
    }

    public boolean moveLeft() {
        x -= vel;
        if (x < -20) {
            x = 20000;
            y = (double) (Math.random() * 600);
            return true;
        }
        return false;
    }

    public void moveRight() {
        x += 1;
    }
}
