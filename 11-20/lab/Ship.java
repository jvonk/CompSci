import java.awt.Color;
import java.awt.Graphics;
 
public class Ship{
    private int x;
    private int y;
     
    private int width;
    private int height;
     
    private Color blue;
     
    public Ship(int x, int y){
         
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.blue = new Color(0,0,255);
    }
     
 
    public boolean checkCollision (Enemy enemy) {
        return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=50.0);
    }
    public void drawMe(Graphics g){
        g.setColor(blue);
        g.fillOval(x,y,width,height);
    }
     
    public void moveUp(){
        y = y - 5;
    }
     
    public void moveDown(){
        y = y + 5;
    }
     
    public int getX(){
        return x;
    }
     
    public int getY(){
        return y;
    }
 
 
}