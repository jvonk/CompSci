import java.awt.*;

public class Item {
    int x, y, width, height;
    public Item(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 60;
    }
    public Item(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height=height;
    }
    public void drawMe(Graphics2D g) {
        drawMe(g, x, y);
    }
    public void drawMe(Graphics2D g, int x, int y) {
        drawMe(g, x-width/2, y-height, width, height);
    }
    public void drawMe(Graphics2D g, int x, int y, int width, int height) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

    public boolean intersects(Item other) {
        return new Rectangle(x, y, width, height).intersects(new Rectangle(other.x, other.y, other.width, other.height));
    }
}