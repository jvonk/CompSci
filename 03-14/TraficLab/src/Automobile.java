import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class Automobile extends Rectangle2D.Double {
    private double maxSpeed, velocity, acceleration;
    private Color color;
    public Automobile(Color color, double x, double y) {
        super(x, y, 50.0, 12.0);
        this.maxSpeed=5;
        this.color = color;
        this.acceleration = 1;
        this.velocity=0;
    }
    public int round(double a) {
        return (int)(Math.round(a));
    }
    public void drawMe(Graphics2D g) {
        drawFrame(g);
        drawWheels(g);
    }

    public void drawFrame(Graphics2D g) {
        g.setColor(color);
        g.fillRect(round(x), round(y), round(width), round(height));
        g.setColor(Color.BLACK);
        g.drawRect(round(x), round(y), round(width), round(height));
    }

    public void update(double max, ArrayList<Automobile> cars) {
        double dist = java.lang.Double.MAX_VALUE;
        double dist2 = -java.lang.Double.MAX_VALUE;
        for (Automobile c : cars) {
            if (Math.abs(c.getY()-getY())>10) continue;
            double a = c.getX()-getX();
            dist = (a>1&&a<dist)?a:dist;
            dist2 = (a<-1&&a>dist2)?a:dist2;
        }
        acceleration = 0.9-velocity/maxSpeed-15000/(dist*dist)+15000/(dist2*dist2);
        velocity=(velocity+acceleration/100);
        if (velocity>maxSpeed) velocity=maxSpeed;
        setX((getX()+width+velocity+max+width*2)%(max+width*2)-width);
    }

    public void drawWindows(Graphics2D g) {
        Polygon first = new Polygon();
        first.addPoint(round(width/5), 0);
        first.addPoint(round(width/4), round(-height));
        first.addPoint(round(width/2), round(-height));
        first.addPoint(round(width/2), 0);
        first.translate(round(x), round(y));
        Polygon second = new Polygon();
        second.addPoint(round(width-width/8), 0);
        second.addPoint(round(width-width/4), round(-height));
        second.addPoint(round(width-width/2), round(-height));
        second.addPoint(round(width-width/2), 0);
        second.translate(round(x), round(y));
        g.setColor(new Color(255, 255, 255, 128));
        g.fillPolygon(first);
        g.fillPolygon(second);
        g.setColor(Color.BLACK);
        g.drawPolygon(first);
        g.drawPolygon(second);
    }

    public void drawCircle(Graphics2D g, double x, double y, double w, double h) {
        g.fillOval(round(x-w/2), round(y-h/2), round(w), round(h));
    }

    public void drawWheels(Graphics2D g) {
        g.setColor(Color.BLACK);
        drawCircle(g, x+width/4, y+height, width/4, width/4);
        drawCircle(g, x+3*width/4, y+height, width/4, width/4);
    }
    public double getVelocity() {
        return velocity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public void setX (double x) {
        setRect(x, y, width, height);
    }

    public void setY (double y) {
        setRect(x, y, width, height);
    }

    public void setWidth (double width) {
        setRect(x, y, width, height);
    }

    public void setHeight (double height) {
        setRect(x, y, width, height);
    }

    public Color getBodyColor() {
        return color;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
