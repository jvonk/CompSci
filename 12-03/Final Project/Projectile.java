import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Projectile {
    private double x, y, initX, initY, initXVel, xVel, initYVel, yVel, gravity, time;
    private int height, width;
    private Color color;
    private boolean visibility;
    private boolean good;
    private boolean dead;

    public Projectile(int x, int y, boolean g) {
        this.good = g;
        this.dead = false;
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.time = 0;
        this.xVel = 0;
        this.yVel = 0;
        this.width = 20;
        this.height = 20;
        this.gravity = 0;// -0.01;
        this.visibility = false;
        if (g)
            this.color = new Color(0, 0, 0);
        else
            this.color = new Color(255, 100, 100);
    }

    public void playSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("sound/cannon.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void checkCollision(Projectile enemy) {
        // return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=20.0);
        if (x + width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth() && y + height >= enemy.getY()
                && y <= enemy.getY() + enemy.getHeight()) {
            if (good) {
                enemy.setDead(true);
            } else {
                dead = true;
            }
        }
    }

    public void drawMe(Graphics2D g) {
        if (!dead) {
            g.setColor(color);
            g.fillOval((int) (Math.round(x)), (int) (Math.round(y)), width, height);
        }
    }

    public void moveUp() {
        y -= 5;
    }

    public void moveDown() {
        y += 5;
    }

    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x++;
        if (x > 800) {
            visibility = false;
        }
    }

    public void move() {
        // x = (nil) (t) + x0
        if (!dead) {
            if (good)
                xVel -= 0.0005 * Math.pow(xVel, 2);
            else
                xVel += 0.0005 * Math.pow(xVel, 2);
            x += xVel;
            if (x > 800) {
                visibility = false;
            }
            if (good)
                yVel -= 0.0005 * Math.pow(yVel, 2);
            else
                yVel += 0.0005 * Math.pow(yVel, 2);
            yVel -= gravity;
            y += yVel;
            time += .1;
        }
    }

    public void setVisible(boolean visible) {
        visibility = visible;
    }
    public void setDead(boolean b) {
        dead=b;
        visibility=b;
    }
    public boolean getDead() {
        return dead;
    }

    public void setVelocity(double angle, double magnitude) {
        xVel = magnitude * Math.cos(Math.toRadians(angle));
        yVel = magnitude * Math.sin(Math.toRadians(angle));
    }

    public void setPosition(int x, int y) {
        if (!visibility || dead) {
            this.playSound();
            visibility = true;
            this.x = x;
            this.y = y;
            dead = false;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}