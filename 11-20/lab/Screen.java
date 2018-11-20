import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;

public class Screen extends JPanel implements KeyListener {
    private Player p1;
    public Screen() {
        p1 = new Player(50,300);
        addKeyListener (this) ;
        setFocusable(true) ;
    }

    public Dimension getPreferredSize () {
        //Sets the size of the panel
        return new Dimension(800,600);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent (g);
        p1.drawMe(g);
    }
    public void keyPressed (KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println ("key: " + code ) ;
        if (code == 38) p1.moveUp();
        else if (code == 40) p1.moveUp();
        repaint();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}