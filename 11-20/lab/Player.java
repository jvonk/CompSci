import java.awt.Graphics;
import java.awt.Color;

public class Player {
    private int x, y, width, height;
    private Color blue;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.blue = new Color(0,0,255);
    }
    public void drawMe(Graphics g) {
        g.setColor(blue);
        g.fillRect(x,y,width,height);
    }
    public void moveUp(){
        y-=5;
    }
}