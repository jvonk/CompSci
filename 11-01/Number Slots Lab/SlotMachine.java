import java.awt.Graphics;
import java.awt.Color;

public class SlotMachine {
    int num1;

    public SlotMachine() {
        num1 = 0;
    }

    public void drawMe(Graphics g) {
        // Colors
        Color blue = new Color(0, 0, 255);
        Color white = new Color(255, 255, 255);
        // Draw Slot Machine
        g.setColor(blue);
        g.fillRect(100, 100, 200, 100);
        // Draw numbers
        g.setColor(white);
        g.drawString(num1 + " ", 150, 150);
    }

    public void play() {
        num1 = (int) (Math.random() * 9 + 1);
    }
}
