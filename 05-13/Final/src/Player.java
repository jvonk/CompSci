import java.awt.*;
import java.util.Queue;
import java.util.*;

public class Player extends Item2 {
    public Queue<String> toSay;
    public Map<Player, Map<String, ArrayList<String>>> conditionalSays;
    public Player(int x, int y) {
        super(x, y);
        toSay = new LinkedList<>();
        conditionalSays = new HashMap<>();
    }
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        toSay = new PriorityQueue<>();
        conditionalSays = new HashMap<>();
    }

    @Override
    public void drawMe(Graphics2D g) {
        super.drawMe(g);
    }

    public void speak(Graphics2D g) {
        if (toSay.isEmpty()) return;
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(75, 450, 450, 100);
        g.setColor(Color.BLACK);
        String text = name + ": " + toSay.peek();
        int startX = 100;
        int startY = 475;
        int lineWidth = 400;
        FontMetrics m = g.getFontMetrics();
        if (m.stringWidth(text) < lineWidth) {
            g.drawString(text, startX, startY);
        } else {
            String[] words = text.split(" ");
            String currentLine = words[0];
            for (int i = 1; i < words.length; i++) {
                if (m.stringWidth(currentLine + words[i]) < lineWidth) {
                    currentLine += " " + words[i];
                } else {
                    g.drawString(currentLine, startX, startY);
                    startY += m.getHeight();
                    currentLine = words[i];
                }
            }
            if (currentLine.trim().length() > 0) {
                g.drawString(currentLine, startX, startY);
            }
        }
    }

    public void addSay(String s) {
        toSay.add(s);
    }

    public String nextSay() {
        if (toSay.isEmpty()) return null;
        return toSay.remove();
    }

    public void addConditionalSay(Player p, String a, String b) {
        conditionalSays.putIfAbsent(p, new HashMap<>());
        conditionalSays.get(p).putIfAbsent(a, new ArrayList<>());
        conditionalSays.get(p).get(a).add(b);
    }
}