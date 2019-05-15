import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements  ActionListener {
    CardLayout card;
    Container c;
    Screen s;
    Intro i;
    Help h;
    Inventory in;
    public Frame(String name) {
        super(name);
        c = getContentPane();
        card = new CardLayout(0, 0);
        c.setLayout(card);
        in = new Inventory(this);
        s = new Screen(this, in);
        i = new Intro(this);
        h = new Help(this);
        c.add(i, "Intro");
        c.add(s, "Screen");
        c.add(h, "Help");
        c.add(in, "Inventory");
    }
    public void actionPerformed(ActionEvent e)  {
        String text = e.getActionCommand();
        if (text.equals("Play")) {
            card.show(c, "Screen");
        } else if (text.equals("Information")) {
            card.show(c, "Help");
        } else if (text.equals("Intro")) {
            card.show(c, "Intro");
        } else if (text.equals("i")) {
            card.show(c, "Inventory");
        }
    }

}
