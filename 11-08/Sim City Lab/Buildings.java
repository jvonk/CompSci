/**
 * Buildings
 */
import java.awt.Color;
import java.awt.Graphics;

public class Buildings {
    int x;
    int y;
    int row;
    int col;

    public Buildings(int x, int y, int row, int col) {
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
                g.fillRect(x + c * 70, y + r * 70, 50, 50);
                // window
                g.setColor(white);
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        g.fillRect(x + c * 70 + i*25 + 7, y + r * 70 + j*25 + 7, 10, 10);
                    }
                }
            }
        }
    }

}