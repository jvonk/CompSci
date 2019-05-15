import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Inventory extends JPanel {
    public ArrayList<Item> items;
    public Inventory(Frame main) {
        setLayout(null);
        items = new ArrayList<>();
        JButton back = new JButton("Back");
        back.setActionCommand("Play");
        back.setBounds(250, 400, 100, 100);
        back.addActionListener(main::actionPerformed);
        this.add(back);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        for (int i = 0; i < items.size(); i++) {
            items.get(i).drawMe(g, 100+(i%3)*150, 100+(i/3)*150, 100, 100);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}