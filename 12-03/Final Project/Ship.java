import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Dimension;


public class Ship {
    private int initX, x, initY, y, width, height, initLives, lives;
    private Color color;

    public Ship(int x, int y) {
        this.initX = x;
        this.x = this.initX;

        this.initY = y;
        this.y = this.initY;

        this.width = 50;
        this.height = 50;

        this.initLives = 3;
        this.lives = this.initLives;

        this.color = new Color(0, 0, 255);
    }

    public void checkCollision(Enemy enemy) {
        if (!enemy.getDead() && x + width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth() && y + height >= enemy.getY()
                && y <= enemy.getY() + enemy.getHeight()) {
            this.setDead(true);
            enemy.setDead(true);
        }
        if (!enemy.getPDead() && x + width >= enemy.getPX() && x <= enemy.getPX() + enemy.getPWidth() && y + height >= enemy.getPY()
                && y <= enemy.getPY() + enemy.getPHeight()) {
            this.setDead(true);
            enemy.setPDead(true);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean getDead() {
        return lives <= 0;
    }

    public void playSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("sound/hit.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void setDead(boolean bool) {
        if (bool) {
            lives--;
            this.playSound();
        } else {
            lives = 3;
        }
    }

    public void drawMe(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        for (int i = 0; i < lives; i++)
            g.fillRect(50 * (i + 1), 20, 30, 30);

        g.setColor(color);
        g.fillRect(x, y, width, height);

        g.setColor(new Color(0, 0, 0));
        g.fillRect(x + width / 2, y + height / 3, width * 2 / 3, height / 3);
    }

    public void moveUp() {
        if (y >= 5)
            y -= 5;
    }

    public void moveDown() {
        if (y <= 595)
            y += 5;
    }
}