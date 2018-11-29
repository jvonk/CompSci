import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Color;

public class Enemy {
    private int x, y, width, height;
    private Color color;
    private boolean dead = false;
    private Projectile p;

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.p=new Projectile(x-20, y, false);
        p.setVelocity(0, -2);
        this.color = new Color(255,0,0);
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
    public void checkCollision (Projectile enemy) {
        //return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=20.0);
        if (x+width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth() && y+height >= enemy.getY() && y <= enemy.getY() + enemy.getHeight()) {
            dead = true;
            this.playSound();
        }
        p.checkCollision(enemy);
    }
    public boolean getDead() {return dead;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public double getPX() {return p.getX();}
    public double getPY() {return p.getY();}
    public int getPWidth() {return p.getWidth();}
    public int getPHeight() {return p.getHeight();}
    public void drawMe(Graphics g) {
        if (!dead) {
            g.setColor(color);
            g.fillOval(x,y,width,height);
            g.setColor(Color.WHITE);
            g.fillOval(x+width/6,y+height/6,width*2/3,height*2/3);
            g.setColor(color);
            g.fillOval(x+width/3,y+height/3,width/3,height/3);
            if (p.getX()<-30 && Math.random()<0.007) {
                this.p=new Projectile(x-20, y, false);
                p.setVelocity(0, -2);
            }
        }
        p.drawMe(g);
        p.move();
    }
    public void moveUp(){
        if (Math.random()<0.3)
        y-=1;
        if (y<-20) y=620;
    }
    public void moveDown(){
        if (Math.random()<0.3)
        y+=1;
        if (y>620) y=-20;
    }
    public void moveLeft(){
        x-=1;
        if (x<-20) {
			x=800; y=(int)(Math.random()*600);
		}
    }
    public void moveRight(){
        x+=1;
    }
}
