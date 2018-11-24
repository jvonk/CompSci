import java.awt.Graphics;

import java.awt.Color;

public class Enemy {
    int x, y, width, height;
    private Color red;

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.red = new Color(255,0,0);
    }
    public void drawMe(Graphics g) {
        g.setColor(red);
        g.fillRect(x,y,width,height);
    }
    public void moveUp(){
        y-=1;
    }
    public void moveDown(){
        y+=1;
    }
    public void moveLeft(){
        x-=1;
        if (x<-400) x=800;
    }
    public void moveRight(){
        x+=1;
    }
}