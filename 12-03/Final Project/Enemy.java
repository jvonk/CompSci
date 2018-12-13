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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Enemy extends JComponent {
    private double initX, x, initY, y, width, height, vel;
    private Color color;
    private boolean dead = false;
    private Projectile p;
    private int lives;
    private Image img1 = Toolkit.getDefaultToolkit().getImage("img/enemy.png");

    public Enemy(double x, double y, double inVel) {
        this.initX = x;
        this.x = this.initX;

        this.initY = y;
        this.y = this.initY;

        this.width = 40;
        this.height = 40;
        if (inVel > 1) {
            this.width = 100;
            this.height = 100;
            this.lives = 3;
        } else {
            this.lives = 0;
        }

        this.vel = inVel;
        this.p = new Projectile((int) (x - 20), (int) (y), false);
        p.setVelocity(0, -vel * 20);

        this.color = new Color(255, 0, 0);
    }

    public void playSound(String s) {
        try {
            URL url = this.getClass().getClassLoader().getResource("sound/" + s + ".wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public boolean checkCollision(Projectile enemy) {
        // return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=20.0);
        boolean change = false;
        if (!enemy.getDead() && x + width >= enemy.getaX() && x <= enemy.getaX() + enemy.getaWidth()
                && y + height >= enemy.getaY() && y <= enemy.getaY() + enemy.getaHeight()) {
            this.setDead(true);
            change = true;
            this.playSound("hit");
        }
        p.checkCollision(enemy);
        return change;
    }

    public boolean getDead() {
        return dead;
    }

    public void setDead(boolean in) {
        if (in) {
            lives--;
            if (lives < 1)
                dead = true;
        } else {
            dead = false;
        }
    }

    public double getaX() {
        return x;
    }

    public double getaY() {
        return y;
    }

    public double getaWidth() {
        return width;
    }

    public double getaHeight() {
        return height;
    }

    public boolean getPDead() {
        return p.getDead();
    }

    public void setPDead(boolean in) {
        p.setDead(in);
    }

    public double getPX() {
        return p.getaX();
    }

    public double getPY() {
        return p.getaY();
    }

    public double getPWidth() {
        return p.getaWidth();
    }

    public double getPHeight() {
        return p.getaHeight();
    }

    public void drawMe(Graphics2D g, boolean showBox) {
        if (!dead) {

            g.drawImage(img1, (int) x, (int) y, (int) width, (int) height, this);
            /*
             * g.setColor(color); g.fillOval((int)(x), (int)(y), (int)(width),
             * (int)(height)); g.setColor(Color.WHITE); g.fillOval((int)(x + width / 6),
             * (int)(y + height / 6), (int)(width * 2 / 3), (int)(height * 2 / 3));
             * g.setColor(color); g.fillOval((int)(x + width / 3), (int)(y + height / 3),
             * (int)(width / 3), (int)(height / 3));
             */
            if (p.getaX() < -30 && Math.random() < 0.007) {
                this.p = new Projectile((int) (x - 20), (int) (y), false);
                p.setVelocity(0, -vel * 20);
            }

            if (showBox) {
                g.drawRect((int) x, (int) y, (int) width, (int) height);
            }
        }
        p.drawMe(g, showBox);
        p.move();
    }

    public void moveUp() {
        if (Math.random() < 0.3)
            y -= this.vel == 2 ? 3 : 1;
        if (y < 0)
            y = 620;
    }

    public void moveDown() {
        if (Math.random() < 0.3)
            y += this.vel == 2 ? 2.5 : 1;
        if (y > 600 - height)
            y = -20;
    }

    public boolean moveLeft() {
        x -= vel;
        if (x < -20) {
            x = 800;
            y = (double) (Math.random() * 600);
            return true;
        }
        return false;
    }

    public void moveRight() {
        x += 1;
    }
}
