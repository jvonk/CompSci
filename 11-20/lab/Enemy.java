import java.awt.Graphics;

import java.awt.Color;

public class Enemy {
    private int x, y, width, height;
    private Color color;
    private boolean dead = false;
    private Projectile p;

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.p=new Projectile(x-20, y, false);
        p.setVelocity(0, -2);
        this.color = new Color(255,0,0);
    }
    public void checkCollision (Projectile enemy) {
        //return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=20.0);
        if (x+width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth() && y+height >= enemy.getY() && y <= enemy.getY() + enemy.getHeight()) dead = true;
        p.checkCollision(enemy);
    }
    public boolean getDead() {return dead;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public double getPX() {return p.getX();}
    public double getPY() {return p.getY();}
    public int getPWidth() {return p.getWidth();}
    public int getPHeight() {return p.getHeight();}
    public void drawMe(Graphics g) {
        if (!dead) {
            g.setColor(color);
            g.fillRect(x,y,width,height);
            if (p.getX()<-30) {
                this.p=new Projectile(x-20, y, false);
                p.setVelocity(0, -2);
            }
        }
        p.drawMe(g);
        p.move();
    }
    public void moveUp(){
        y-=1;
    }
    public void moveDown(){
        y+=1;
    }
    public void moveLeft(){
        x-=1;
        if (x<-20) x=800;
    }
    public void moveRight(){
        x+=1;
    }
}