import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Card implements Comparable<Card> {
    private int value;
    private BufferedImage full;
    public Card(int in) {
        this.value = in;
        try {
            String[] names = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
            String[] rank = new String[] {"H", "D", "C", "S"};
            full = ImageIO.read(new File("image/" + names[(int)(value % 13)] + rank[(int)(value / 13)] + ".png"));
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    public String toString() {
        return String.valueOf(value);
    }
    @Override
    public int compareTo(Card o) {
        return value > o.value ? 1 : value < o.value ? -1 : 0;
    }
    public int getValue() {
        return value;
    }
    public void drawMe(Graphics2D g, int x, int y) {
        g.drawImage(full, x, y, null);
    }
    public void drawMe(Graphics2D g, int x, int y, boolean which) {
        try {
            g.drawImage(ImageIO.read(new File("image/back.png")), x, y, null);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
