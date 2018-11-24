import java.awt.Color;
import java.awt.Graphics;
 
public class Ship{
    private int x;
    private int y;
    private boolean dead = false;
     
    private int width;
    private int height;
     
    private Color color;
     
    public Ship(int x, int y){
         
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.color = new Color(0,0,255);
    }
     
 
    public void checkCollision (Enemy enemy) {
        if (x+width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth()  && y+height >= enemy.getY() && y <= enemy.getY() + enemy.getHeight()) dead = true;
        else if (x+width >= enemy.getPX() && x <= enemy.getPX() + enemy.getPWidth()  && y+height >= enemy.getPY() && y <= enemy.getPY() + enemy.getPHeight()) dead = true;
        
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public boolean getDead() {return dead;}
    
    public void drawMe(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
     
    public void moveUp(){
        if (y>=5) y -= 5;
    }
     
    public void moveDown(){
        if (y<=595) y += 5;
    }
 
 
}