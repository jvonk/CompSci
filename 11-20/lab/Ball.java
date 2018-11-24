import java.awt.Graphics;

import java.awt.Color;

public class Ball {
    private double x, y, initX, initY, xVel, yVel, gravity, time;
    private Color red;
    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.time = 0;
        this.xVel = 0;
        this.yVel = 0;
        this.gravity = -1;
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
        x+=5;
    }
    public void move() {
        //x = (nil) (t) + x0
        x = xVel*time + initX;
        y = (-0.5 * gravity * Math.pow(time,2)) - (yVel * time) + initY;
        time += .1;
    }
    public void setVelocity(double angle, double magnitude) {
        xVel = magnitude*Math.cos(Math.toRadians(angle));
        yVel = magnitude*Math.sin(Math.toRadians(angle));
    }
}