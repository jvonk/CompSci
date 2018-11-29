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
    private Ship s1;
    private Enemy[] enemies; 
    private boolean win;
    private int counter;
    private int score;
    private long time;

    public Screen() {
        p1 = new Projectile(50,500, true);
        s1 = new Ship(50,300);
        p1.setVelocity(80, 30);
        enemies = new Enemy[10];
        score = 0;
        counter = 0;
        win=false;
        time=System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            enemies[i]=new Enemy((int)(Math.random()*840)+400, (int)(Math.random()*600));
        }
        addKeyListener (this) ;
        setFocusable(true) ;
    }

    public Dimension getPreferredSize () {
        //Sets the size of the panel
        return new Dimension(800,600);
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

    public void paintComponent (Graphics g) {
        super.paintComponent (g);
        g.setColor(new Color(128,128,255));
        g.fillRect(0, 0, 800, 300);
        g.setColor(new Color(170,150,128));
        g.fillRect(0, 300, 800, 300);
        g.setColor(Color.BLACK);
        if (win) {
            g.drawString("YOU WIN", 100, 100);
        } else if (s1.getDead()) {
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
        g.setColor(Color.BLACK);
        g.drawString("Score: "+score, 100, 120);
        g.drawString("Time Left: "+0.001*(int)(100000-Math.round(System.currentTimeMillis()-time)), 100, 80);
        if (System.currentTimeMillis()-time>100000) {
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
            if (s1.getDead() || win) continue;
            p1.move();
            int oldScore = score;
            score=0;
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].getDead()) {
                    score++;
                    continue;
                }
                enemies[i].moveLeft();
                if (2*((counter+i)%enemies.length)<enemies.length)
                    enemies[i].moveUp();
                else
                    enemies[i].moveDown();
                enemies[i].checkCollision(p1);
                s1.checkCollision(enemies[i]);
            }
            if (oldScore<score) this.playSound();
            if (Math.random()<0.001)
                counter++;
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
