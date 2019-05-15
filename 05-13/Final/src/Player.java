import java.awt.*;

public class Player extends Item {
    public boolean speaking;
    public Player(int x, int y) {
        super(x, y);
        speaking = false;
    }
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void drawMe(Graphics2D g) {
        super.drawMe(g);
        if (speaking) this.speak(g);
    }

    public void speak(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(75, 425, 450, 100);
        g.setColor(Color.BLACK);
        g.drawString("Hello", 100, 450);
    }

    public boolean intersects(Player other) {
        return new Rectangle(x, y, width, height).intersects(new Rectangle(other.x, other.y, other.width, other.height));
    }
}