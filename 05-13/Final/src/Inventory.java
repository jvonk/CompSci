import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Inventory extends JPanel {
    public ArrayList<Item> items;
    public Screen screen;
    public Inventory(Frame main) {
        setLayout(null);
        items = new ArrayList<>();
        JButton back = new JButton("Back");
        back.setActionCommand("Play");
        back.setBounds(150, 550, 300, 30);
        back.addActionListener(main);
        this.add(back);
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                for (int i = 0; i < items.size(); i++) {
                    items.get(i).speaking = new Rectangle(100 + (i % 3) * 150, 100 + (i / 3) * 150, 100, 100).contains(e.getPoint());
                }
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).speaking) {
                        Item item = items.remove(i);
                        screen.dropItem(item);
                        repaint();
                        return;
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        for (int i = 0; i < items.size(); i++) {
            items.get(i).drawMeSquare(g, 100 + (i % 3) * 150, 100 + (i / 3) * 150);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}