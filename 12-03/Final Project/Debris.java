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

public class Debris {
    private int x, y, xVel, yVel, length;
    private Color color;
    public Debris(int x, int y, int xV, int yV) {
        this.x = x;
        this.y=y;
        this.xVel = xV;
        this.yVel = yV;
        this.length = (int)(Math.random()*100);
        int temp = (int)(Math.random()*255);
        this.color = new Color(temp, temp, temp);
    }
    public void drawMe(Graphics2D g, int level) {
        g.setColor(color);
        g.fillRect(x, y, length, 3);
        if (level>2) {
            g.fillOval((x+300)%800, 600-y, length/3, length/3);
        }
        if (level>3) {
            g.setColor(new Color(130, 150, 255));
            g.fillRect(y*4/3, (800-x)%600, length/8, length/4);
        }
        x=(x+xVel+800)%800;
        y=(y+yVel+600)%600;
    }
}