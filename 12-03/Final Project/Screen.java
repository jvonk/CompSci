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
    // private Projectile[] projectiles;
    private Ship s1;
    private Enemy[] enemies, level1, level2;
    private boolean win;
    private int counter, score, level;
    private long time;
    private Debris[] debris;
    private int[][][] levels;
    private double[][] speeds;
    private int numLevels;

    public Screen() {
        numLevels=50;
        p1 = new Projectile(50, 500, true);
        p1.setVelocity(80, 30);

        // projectiles=new Projectile[] {new Projectile(50, 500, true)};
        debris = new Debris[100];
        for (int i = 0; i < debris.length; i++) {
            debris[i] = new Debris((int) (Math.random() * 800), (int) (Math.random() * 600),
                    (int) (Math.random() * 5 - 7), 0);
        }

        s1 = new Ship(50, 300);

        score = 0;
        counter = 0;

        win = false;

        time = System.currentTimeMillis();
        speeds = new double[][] {
            new double[] {0.2},
            new double[] {0.3},
            new double[] {1.7},
            new double[] {0.25},
            new double[] {0.5, 0.5, 0.5, 0.6, 0.6, 0.6, 0.7, 0.7, 0.7, 0.8, 0.8, 0.8, 0.9, 0.9, 0.9},
            new double[] {0.7, 1.1, 0.7},
            new double[] {0.0},
        };
        levels = new int[][][] {

                new int[][] { new int[] { 700, 200 },
                              new int[] { 600, 300 },
                              new int[] { 700, 400 } },

                new int[][] { new int[] { 600, 200 },
                              new int[] { 500, 300 },
                              new int[] { 600, 400 },
                              new int[] { 700, 100 },
                              new int[] { 700, 300 },
                              new int[] { 700, 500 } },

                new int[][] { new int[] { 700, 300 } },

                new int[][] { new int[] { 600, 200 },
                              new int[] { 500, 300 },
                              new int[] { 600, 400 },
                              new int[] { 700, 100 },
                              new int[] { 700, 300 },
                              new int[] { 700, 500 },
                              new int[] { 900, 100 },
                              new int[] { 900, 300 },
                              new int[] { 900, 500 },
                              new int[] { 1100, 100 },
                              new int[] { 1100, 300 },
                              new int[] { 1100, 500 },
                              new int[] { 1300, 100 },
                              new int[] { 1300, 300 },
                              new int[] { 1300, 500 } },

                              new int[][] { new int[] { 600, 100 },
                              new int[] { 600, 300 },
                              new int[] { 600, 500 },
                              new int[] { 1100, 100 },
                              new int[] { 1100, 300 },
                              new int[] { 1100, 500 },
                              new int[] { 1600, 100 },
                              new int[] { 1600, 300 },
                              new int[] { 1600, 500 },
                              new int[] { 2100, 100 },
                              new int[] { 2100, 300 },
                              new int[] { 2100, 500 },
                              new int[] { 2600, 100 },
                              new int[] { 2600, 300 },
                              new int[] { 2600, 500 } },

                new int[][] { new int[] { 800, 100 },
                              new int[] { 800, 300 },
                              new int[] { 800, 500 } },

                new int[0][0]
            };
        level = 1;
        enemies = convert(0);

        addKeyListener(this);
        setFocusable(true);
    }

    public Enemy[] convert(int which) {
        Enemy[] a = new Enemy[levels[which].length];
        for (int i = 0; i < levels[which].length; i++) {
            a[i] = new Enemy(levels[which][i][0], levels[which][i][1], speeds[which].length==1?speeds[which][0]:speeds[which][i]);
        }
        return a;
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Sets the size of the panel
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (level == 1) {
            g.setColor(new Color(135, 206, 235));
            g.fillRect(0, 0, 800, 300);
            g.setColor(new Color(87, 59, 12));
            g.fillRect(0, 300, 800, 300);
            g.setColor(new Color(252, 212, 64));
            g.fillOval(50, 50, 100, 100);
            int x = (int)(0.1*(System.currentTimeMillis()-time))%800;
            g.setColor(new Color(220, 240, 255));
            g.fillOval((2*x)%1200+25, 100, 200, 100);
            g.fillOval((2*x)%1200+125, 100, 200, 100);
            g.fillOval((2*x)%1200+75, 50, 200, 100);
            g.setColor(new Color(255, 255, 255));
            g.fillOval((3*x)%1200-600+225, 150, 200, 100);
            g.fillOval((3*x)%1200-600+325, 150, 200, 100);
            g.fillOval((3*x)%1200-600+275, 100, 200, 100);
            g.fillOval((3*x)%1200-600+325, 125, 200, 100);
            g.fillOval((3*x)%1200-600+425, 125, 200, 100);
            g.fillOval((3*x)%1200-600+375, 75, 200, 100);
        } else if (level == 2) {
            g.setColor(new Color(255, 128, 255));
            g.fillRect(0, 300, 800, 300);
            g.setColor(new Color(255, 150, 128));
            g.fillRect(0, 0, 800, 300);
            if ((int)(System.currentTimeMillis()-time)%1000<100) {
                int tx = (int)(Math.random()*800.0);
                int[] prev = new int[] {tx, -20};
                int[] current = new int[] {tx, -20};
                g.setColor(new Color(220, 230, 255));
                for (int i = 0; i < 100; i++) {
                    prev=current.clone();
                    current[0]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5);
                    current[1]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5)+(Math.random()*5+2);
                    for (int j = 0; j < 10; j++) {
                        g.drawLine(prev[0]+400+j, prev[1], current[0]+400+j, current[1]);
                    }
                    current[0]%=800;
                    current[1]%=600;
                }
            }
        } else if (level == 3) {
            g.setColor(new Color(100, 200, 255));
            g.fillRect(0, 0, 800, 300);
            g.setColor(new Color(0, 150, 128));
            g.fillRect(0, 300, 800, 300);
            g.setColor(new Color(252, 212, 64));
            g.fillOval(10, 10, 100, 100);
            g.setColor(new Color(252, 190, 50));
            g.fillOval(30, 30, 60, 60);
            g.setColor(new Color(80, 40, 25));
            g.fillPolygon(new int[] {50, 400, 750}, new int[] {600, 300, 600}, 3);
            g.setColor(new Color(255, 40, 25));
            g.fillPolygon(new int[] {310, 400, 490, 420, 400, 380}, new int[] {375, 300, 375, 420, 380, 400}, 6);        
        } else if (level == 4) {
            g.setColor(new Color(120, 120, 200));
            g.fillRect(0, 0, 800, 300);
            g.setColor(new Color(120, 60, 255));
            g.fillRect(0, 300, 800, 300);
        } else {
            g.setColor(new Color(106,197,244));
            g.fillRect(0, 0, 800, 300);
            g.setColor(new Color(252,81,11));
            g.fillRect(0, 300, 800, 300);
        }

        for (int i = 0; i < debris.length; i++) {
            debris[i].drawMe(g, level);
        }

        g.setColor(Color.BLACK);
        if (level == numLevels) {
            g.drawString("YOU WIN", 100, 100);
            s1.drawMe(g);
        } else if (s1.getDead()) {
            g.drawString("YOU LOSE", 100, 100);
        } else {
            boolean win = true;
            for (int i = 0; i < enemies.length; i++) {
                enemies[i].drawMe(g);
                if (!enemies[i].getDead())
                    win = false;
            }
            if (win)
                this.win();
            p1.drawMe(g);
            g.drawString("Time Left: " + (int) (1000000 - Math.round(System.currentTimeMillis() - time)), 100, 80);
            if (System.currentTimeMillis() - time > 1000000) {
                s1.setLives(-1);
                g.drawString("YOU LOSE", 100, 100);
            }
            /*
             * for (int i = 0; i < projectiles.length; i++) { projectiles[i].drawMe(g); }
             */
            s1.drawMe(g);
        }
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score+"/"+enemies.length, 100, 120);
        g.drawString("Level: " + level+"/"+(numLevels), 100, 140);
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
             * for (int i = 0; i < projectiles.length; i++) { projectiles[i].move(); }
             */
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
                 * for (int j = 0; j < projectiles.length; j++) {
                 * 
                 * }
                 */
                if (enemies[i].checkCollision(p1)) {
                    p1.setDead(true);
                }
                // enemies[i].checkCollision(p1);
                s1.checkCollision(enemies[i]);
            }

            if (oldLives != s1.getLives()) {
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
        if (s1.getLives() == 0) {
            level = 0;
            score = 0;
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

        if (level < 1)
            level = 1;
        if (level>=numLevels) {
            level=numLevels;
            enemies = convert(levels.length-1);
        } else if (level >= levels.length-1) {
            int len = (int)(Math.random()*(level/5)+1);
            Enemy[] temp = new Enemy[len];
            int count = 0;
            for (int i = 0; i < len; i++) {
                double t = Math.random()*0.8+0.4;
                temp[i]=new Enemy(700.0+Math.random()*700+count, Math.random()*600, t);
                count+=(int)(Math.pow(t, 3)*(600-level*10));
            } 
            enemies=temp;
            level++;
        } else {
            level++;
            enemies = convert(level - 1);
        }
        
    }

    public void keyPressed(KeyEvent e) {
        if (s1.getDead()) {
            return;
        }
        switch (e.getKeyCode()) {
        case 38:
            s1.moveUp();
            break;
        case 40:
            s1.moveDown();
            break;
        case 32: {
            /*
             * for (int i = 0; i < projectiles.length; i++) {
             * projectiles[i].setPosition(s1.getX(), s1.getY() + 15);
             * projectiles[i].setVelocity(i-1, 3); }
             */
            p1.setPosition(s1.getX(), s1.getY() + 15);
            p1.setVelocity(0, 3);
        }
            break;
        case 80:
            this.win();
            break;
        case 82:
            s1.setLives(3);
            break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
