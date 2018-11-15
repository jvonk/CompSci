import java.awt.*;

public class Tree {
    int x;
    int y;
    Color brown = new Color(101, 67, 33);

    Color treeColorBrown = new Color (218, 120, 27);
    Color treeColorGreen = new Color(34, 139, 34);


    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
        double ran = Math.random();
        if (ran<0.25) {
            treeColorBrown = new Color (144, 170, 6);
        } else if (ran<0.5) {
            treeColorBrown = new Color (162, 163, 3);
        } else if (ran<0.75) {
            treeColorBrown = new Color (218, 120, 27);
        } else {
            treeColorBrown = new Color (212, 103, 25);
        }
    
    }

    public void drawMe(Graphics g, int counter) {
        // trunk
        g.setColor(brown);
        g.fillRect(x, y, 10, 40);
        // leaves
        if (counter<1000) {
            if (counter<500) {
                g.setColor(treeColorBrown);
                g.fillOval(x - 10, y - 10, 30, 30);       
            }
        } else {
            g.setColor(treeColorGreen);
            g.fillOval(x - 10, y - 10, 30, 30);
        }
    }

}