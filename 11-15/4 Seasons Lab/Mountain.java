import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Mountain {
    Polygon p;
    Polygon w;

    Color rock;

    public Mountain(int x, int y) {
        int[] xs = new int[7];
        int[] ys = new int[7];
        xs[0]=x;
        ys[0]=y;
        xs[1]=xs[0]+(int)(Math.random()*30+20);
        ys[1]=ys[0]-(int)((xs[1]-xs[0])*(0.9+Math.random()*0.2));
        xs[2]=xs[1]+(int)(Math.random()*20+10);
        ys[2]=ys[1]+(int)((xs[2]-xs[1])*(0.9+Math.random()*0.2)/3.0);
        xs[3]=xs[2]+(int)(Math.random()*30+20);
        ys[3]=ys[2]-(int)((xs[3]-xs[2])*(0.9+Math.random()*0.2));
        xs[4]=xs[3]+(int)(Math.random()*30+20);
        ys[4]=ys[3]+(int)((xs[4]-xs[3])*(0.9+Math.random()*0.2));
        xs[5]=xs[4]+(int)(Math.random()*20+10);
        ys[5]=ys[4]-(int)((xs[5]-xs[4])*(0.9+Math.random()*0.2)/3.0);
        xs[6]=xs[5]+(int)(Math.random()*30+20);
        ys[6]=y;
        p = new Polygon(xs, ys, 7);
        w = new Polygon(new int[] {(xs[2]+xs[3])/2, xs[3], (xs[3]+xs[4])/2}, new int[] {(ys[2]+ys[3])/2, ys[3], (ys[3]+ys[4])/2}, 3);
        rock = new Color(150*(y-200)/300, 141*(y-200)/300, 153*(y-200)/300);
    }

    Color white = new Color(255, 255, 255);

    public void drawMe(Graphics g, int counter) {
        // rock
        g.setColor(rock);
        g.fillPolygon(p);
        if (counter < 1000 && counter > 500) {
            g.setColor(white);
            g.fillPolygon(w);
        }
    }

}