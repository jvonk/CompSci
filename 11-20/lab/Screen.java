import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.Dimension;

public class Screen extends JPanel implements KeyListener {
    private Projectile p1;
    private Ship s1;
    private Enemy[] enemies; 
    private boolean win;

    public Screen() {
        p1 = new Projectile(50,500, true);
        s1 = new Ship(50,300);
        p1.setVelocity(80, 30);
        enemies = new Enemy[10];
        for (int i = 0; i < 10; i++) {
            enemies[i]=new Enemy((int)(Math.random()*800+400), (int)(Math.random()*600));
        }
        addKeyListener (this) ;
        setFocusable(true) ;
    }

    public Dimension getPreferredSize () {
        //Sets the size of the panel
        return new Dimension(800,600);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent (g);
        if (win) {
            g.drawString("YOU WIN", 100, 100);
        }
        else {
            if (s1.getDead()) {
                g.drawString("YOU LOSE", 100, 100);
            } else {
                for (int i = 0; i < enemies.length; i++)
                enemies[i].drawMe(g);
                p1.drawMe(g);
                win = true;
                for (int i = 0; i < enemies.length; i++) {
                    if (!enemies[i].getDead()) win = false;
                }
                //Draw ship
                s1.drawMe(g);
            }
        }
    }

    public void animate() {
        while (true) {
            // wait for .01 second
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (s1.getDead() || win) continue;
            p1.move();
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].getDead()) continue;
                enemies[i].moveLeft();
                enemies[i].checkCollision(p1);
                s1.checkCollision(enemies[i]);
            }
            repaint();
        }
    }

    public void keyPressed (KeyEvent e) {
        if (s1.getDead()) return;
        int code = e.getKeyCode();
        if (code == 38) s1.moveUp();
        if (code == 40) s1.moveDown();
        if (code==32) {
            p1.setPosition(s1.getX(), s1.getY()+15);
            p1.setVelocity(0, 3);
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}