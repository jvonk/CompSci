import java.awt.Graphics;

import java.awt.Color;

public class Projectile {
    private double x, y, initX, initY, xVel, yVel, gravity, time;
    private Color red;
    private boolean visibility;
    public Projectile(int x, int y){
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.time = 0;
        this.xVel = 0;
        this.yVel = 0;
        this.gravity = 0;
        this.visibility = false;
        this.red = new Color(255,0,0);
    }
    public void drawMe(Graphics g) {
        g.setColor(red);
        g.fillOval((int)(Math.round(x)),(int)(Math.round(y)),20,20);
    }
    public boolean checkCollision (Enemy enemy) {
        return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=20.0);
    }
    public void moveUp(){
        y-=5;
    }
    public void moveDown(){
        y+=5;
    }
    public void moveLeft(){
        x-=5;
    }
    public void moveRight(){
        x++;
        if (x>800) {
            visibility=false;
        }
    }
    public void move() {
        //x = (nil) (t) + x0
        x += xVel;
        if (x>800) {
            visibility=false;
        }
        yVel -= gravity;
        y +=  yVel;
        time += .1;
    }
    public void setVisible(boolean visible) {
        visibility=visible;
    }
    public void setVelocity(double angle, double magnitude) {
        xVel = magnitude*Math.cos(Math.toRadians(angle));
        yVel = magnitude*Math.sin(Math.toRadians(angle));
    }
    public void setPosition(int x, int y) {
        System.out.println(visibility);
        if (!visibility) {
            visibility=true;
            this.x = x;
            this.y = y;
        }
    }
}