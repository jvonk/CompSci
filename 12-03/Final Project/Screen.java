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
    private int[][][] levels;

    public Screen() {
        p1 = new Projectile(50, 500, true);
        p1.setVelocity(80, 30);

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
        levels = new int[][][] {new int[][] { new int[] {700, 200}, new int[] {600, 300}, new int[] {700, 400}}, new int[][] {new int[] {600, 200}, new int[] {500, 300}, new int[] {600, 400}, new int[] {700, 100}, new int[] {700, 300}, new int[] {700, 500}}, new int[][] {new int[] {700, 300}}, new int[0][0]};
        level = 1;
        enemies = convert(levels[0]);

        addKeyListener(this);
        setFocusable(true);
    }
    public Enemy[] convert (int[][] in) {
        Enemy[] a = new Enemy[in.length];
        for (int i = 0; i < in.length; i++) {
            a[i]=new Enemy(in[i][0], in[i][1], (in.length==1)?2:0.05*in.length);
        }
        return a;
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
        } else if (level==3) {
            g.setColor(new Color(100, 200, 255));
            g.fillRect(0, 0, 800, 300);
            g.setColor(new Color(0, 150, 128));
            g.fillRect(0, 300, 800, 300);
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
        if (level == levels.length) {
            g.drawString("YOU WIN", 100, 100);
            s1.drawMe(g);
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
            s1.setLives(-1);
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
                    
                }*/
                if (enemies[i].checkCollision(p1)) {
                    p1.setDead(true);
                }
                //enemies[i].checkCollision(p1);
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
        if (s1.getLives()==0) {
            level=0;
            score=0;
            s1.setLives(3);
        } else {
            level--;
        }
        this.win();
    }
    public void win() {
        s1.setY(300);
        p1 = new Projectile(50, 500, true);
        p1.setVelocity(80, 30);
        level++;
        if (level>levels.length) level=3;
        if (level<1) level=1;
        enemies = convert(levels[level-1]);
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
