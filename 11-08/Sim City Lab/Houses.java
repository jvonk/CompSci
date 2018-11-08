/**
 * Houses
 */
import java.awt.Color;
import java.awt.Graphics;

public class Houses {
    int x;
    int y;
    int row;
    int col;

    public Houses(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
    }

    Color brown = new Color(222, 184, 135);
    Color white = new Color(255, 255, 255);

    public void drawMe(Graphics g) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // building
                g.setColor(brown);
                g.fillRect(x + c * 35, y + r * 25, 30, 20);
                // window
                g.setColor(white);
                g.fillRect(x + c * 35 + 2, y + r * 25 + 4, 10, 10);
            }
        }
    }

}