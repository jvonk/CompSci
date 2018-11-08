/**
 * Trees
 */
import java.awt.Color;
import java.awt.Graphics;

public class Trees {
    int x;
    int y;
    int row;
    int col;

    public Trees(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
    }
    Color brown = new Color(101, 67, 33);
    Color green = new Color(34, 139, 34);

    public void drawMe(Graphics g) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // trunk
                g.setColor(brown);
                g.fillRect(x + c * 40, y + r * 50, 10, 40);
                // leaves
                g.setColor(green);
                g.fillOval(x + c * 40 - 10, y + r * 50 - 10, 30, 30);
            }
        }
    }

}