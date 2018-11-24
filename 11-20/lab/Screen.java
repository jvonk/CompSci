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
    private boolean dead = false;

    public Screen() {
        p1 = new Projectile(50,500);
        s1 = new Ship(50,300);
        p1.setVelocity(80, 30);
        enemies = new Enemy[8];
        enemies[0] = new Enemy(700,30);
        enemies[1] = new Enemy(700,100);
        enemies[2] = new Enemy(700,300);
        for (int i = 0; i < 5; i++) {
            enemies[3+i]=new Enemy((int)(Math.random()*400+400), (int)(Math.random()*600));
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
        for (int i = 0; i < enemies.length; i++)
            enemies[i].drawMe(g);
        p1.drawMe(g);
        if (dead) {
            g.drawString("YOU LOSE", 100, 100);
        }
     
        //Draw ship
        s1.drawMe(g);
    }

    public void animate() {
        while (true) {
            // wait for .01 second
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            p1.move();
            for (int i = 0; i < enemies.length; i++) {
                enemies[i].moveLeft();
                if (p1.checkCollision(enemies[i])) {
                    enemies[i] = new Enemy((int)(Math.random()*400+400), (int)(Math.random()*600));
                }
                if (s1.checkCollision(enemies[i])) {
                    dead=true;
                }
            }

            repaint();
        }
    }

    public void keyPressed (KeyEvent e) {
        if (dead) return;
        int code = e.getKeyCode();
        System.out.println ("key: " + code ) ;
        if (code == 38) s1.moveUp();
        if (code == 40) s1.moveDown();
        if (code==32) {
            p1.setPosition(s1.getX()+20, s1.getY());
            p1.setVelocity(0, 3);
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}