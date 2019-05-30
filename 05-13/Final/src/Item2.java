import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Item2 {
    public float opacity = 1.0f;
    public boolean canPickUp = true;
    public String className = "Item";
    public boolean speaking;
    public int x, y, width, height;
    public String name;
    public BufferedImage image = null, square = null;
    public Item2(int x, int y) {
        this.speaking = false;
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 60;
    }
    public Item2(int x, int y, int width, int height) {
        this.speaking = false;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setName(String s) {
        name = s;
    }

    public void drawMe(Graphics2D g) {
        drawMe(g, x, y);
    }

    public void drawMeSquare(Graphics2D g, int x, int y) {
        if (this.image != null && this.square == null) {
            Image tmp = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            square = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = square.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
        }
        drawMe(g, x, y, 100, 100);
        g.drawImage(image, x, y, null);
    }

    public void drawMe(Graphics2D g, int x, int y) {
        if (opacity < 1.0f) g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        drawMe(g, x-width/2, y-height, width, height);
        if (this.image != null) {
            g.drawImage(image, x - width / 2, y - height, null);
        }
        if (opacity < 1.0f) g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }
    public void drawMe(Graphics2D g, int x, int y, int width, int height) {
        if (Screen.SHOW_BOUNDARY) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
        }
        if (speaking && name != null && !(this instanceof Player)) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(75, 450, 450, 100);
            g.setColor(Color.BLACK);
            g.drawString(className + ": " + name, 100, 475);
        }
    }

    public void fadeIn(Screen s, double time) {
        opacity = 0f;
        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                opacity += time / 60;
                if (opacity >= 1.0f) {
                    this.cancel();
                    opacity = 1.0f;
                }
                s.repaint();
            }
        }, 0, 1000 / 60);

    }

    public boolean intersects(Item other) {
        return new Rectangle(x - width / 2, y - height, width, height).intersects(new Rectangle(other.x - other.width / 2, other.y - other.height, other.width, other.height));
    }

    public boolean intersects(Item2 other) {
        return new Rectangle(x - width / 2, y - height, width, height).intersects(new Rectangle(other.x - other.width / 2, other.y - other.height, other.width, other.height));
    }
}