import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
 
public class Circles extends JPanel {
    private int x, y;
 
    public Circles() {
        //(1) What is imported to get Graphics to work?
        //Color, Dimensions, and JPanel are imported
        x = 400;
        y = 200;
 
    }
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        //(2) In the paintComponent method, what do you think it is drawing?
        //It is drawing a red box on the screen
        Color colorGreen = new Color(0, 255, 0);
        Color colorBrown = new Color(100, 50, 50);
        g.setColor(colorGreen);
        g.fillOval(x,y,100,100);
        g.setColor(colorBrown);
        g.fillRect(x+40,y+100,20,100);
    }
 
 
}