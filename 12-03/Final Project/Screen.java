import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Dimension;

public class Screen extends JPanel implements KeyListener {
    private Projectile p1;
    //private Projectile[] projectiles;
    private Ship s1;
    private Enemy[] enemies, level1, level2;
    private boolean win;
    private int counter, score, level;
    private long time;
    private Debris[] debris;

    public Screen() {
        p1 = new Projectile(50, 500, true);
        //projectiles=new Projectile[] {new Projectile(50, 500, true)};
        debris=new Debris[100];
        for (int i = 0; i < debris.length; i++) {
            debris[i]=new Debris((int)(Math.random()*800), (int)(Math.random()*600), (int)(Math.random()*5-7), 0);
        }

        s1 = new Ship(50, 300);

        score = 0;
        counter = 0;

        win = false;

        time = System.currentTimeMillis();

        level1 = new Enemy[] { new Enemy(700, 200, 1), new Enemy(600, 300, 1), new Enemy(700, 400, 1) };
        level2 = new Enemy[] { new Enemy(600, 200, 2), new Enemy(500, 300, 2), new Enemy(600, 400, 2), new Enemy(700, 100, 2),
                new Enemy(700, 300, 2), new Enemy(700, 500, 2) };
        level = 1;
        enemies = level1.clone();

        addKeyListener(this);
        setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Sets the size of the panel
    }

    public void playSound(String s) {
        try {
            URL url = this.getClass().getClassLoader().getResource("sound/"+s+".wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (level==1) {
            g.setColor(new Color(128, 128, 255));
            g.fillRect(0, 0, 800, 300);
            g.setColor(new Color(170, 150, 128));
            g.fillRect(0, 300, 800, 300);
        } else if (level==2) {
            g.setColor(new Color(255, 128, 255));
            g.fillRect(0, 300, 800, 300);
            g.setColor(new Color(255, 150, 128));
            g.fillRect(0, 0, 800, 300);
        } else {
            g.setColor(new Color(100, 0, 255));
            g.fillRect(0, 0, 800, 300);
            g.setColor(new Color(170, 150, 128));
            g.fillRect(0, 300, 800, 300);
        }

        for (int i = 0; i < debris.length; i++) {
            debris[i].drawMe(g);
        }

        g.setColor(Color.BLACK);
        if (level == 3) {
            g.drawString("YOU WIN", 100, 100);
        } else if (s1.getDead()) {
            g.drawString("YOU LOSE", 100, 100);
        } else {
            boolean win = true;
            for (int i = 0; i < enemies.length; i++) {
                enemies[i].drawMe(g);
                if (!enemies[i].getDead()) win = false;
            }
            if (win) this.win();
            p1.drawMe(g);
            /*for (int i = 0; i < projectiles.length; i++) {
                projectiles[i].drawMe(g);
            }*/
            s1.drawMe(g);
        }
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 100, 120);
        g.drawString("Time Left: " + 0.001 * (int) (1000000 - Math.round(System.currentTimeMillis() - time)), 100, 80);
        if (System.currentTimeMillis() - time > 1000000) {
            s1.setDead(true);
            g.drawString("YOU LOSE", 100, 100);
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
            if (s1.getDead() || win)
                continue;
            p1.move();
            /*
            for (int i = 0; i < projectiles.length; i++) {
                projectiles[i].move();
            }*/
            int oldScore = score;
            score = 0;
            int oldLives = s1.getLives();
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].getDead()) {
                    score++;
                    continue;
                }
                if (enemies[i].moveLeft()) {
                    s1.setDead(true);
                }
                if (2 * ((counter + i) % enemies.length) < enemies.length) {
                    enemies[i].moveUp();
                } else {
                    enemies[i].moveDown();
                }
                /*
                for (int j = 0; j < projectiles.length; j++) {
                    if (enemies[i].checkCollision(projectiles[j])) {
                        projectiles[j].setDead(true);
                    }
                }*/
                if (enemies[i].checkCollision(p1)) {
                    p1.setDead(true);
                }
                s1.checkCollision(enemies[i]);
            }

            if (oldLives!=s1.getLives()) {
                this.lose();
            }
            if (oldScore < score) {
                this.playSound("cannon");
            }
            if (Math.random() < 0.001)
                counter++;
            repaint();
        }
    }
    public void lose() {
        level=0;
        this.win();
    }
    public void win() {
        level++;
        if (level>3) level=3;
        if (level<1) level=1;
        if (level == 1) {
            enemies = new Enemy[] { new Enemy(700, 200, 1), new Enemy(600, 300, 1), new Enemy(700, 400, 1) };
        } else if (level == 2) {
            enemies = level2.clone();
        } else if (level==3) {
            enemies = new Enemy[0];
        }
    }

    public void keyPressed(KeyEvent e) {
        if (s1.getDead()) {
            return;
        }
        switch(e.getKeyCode()) {
            case 38: s1.moveUp();
            break;
            case 40: s1.moveDown();
            break;
            case 32: {
                /*
                for (int i = 0; i < projectiles.length; i++) {
                    projectiles[i].setPosition(s1.getX(), s1.getY() + 15);
                    projectiles[i].setVelocity(i-1, 3);
                }
                */
                p1.setPosition(s1.getX(), s1.getY() + 15);
                p1.setVelocity(0, 3);
            }
            break;
            case 80: this.win();
            break;
            case 82: s1.setLives(3);
            break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
