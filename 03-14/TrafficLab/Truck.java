import java.awt.*;

public class Truck extends BigCar {
    public Truck (Color color, double x, double y) {
        super(color, x, y);
    }

    @Override
    public void drawFrame(Graphics2D g) {
        super.drawFrame(g);
        g.setColor(Color.GRAY);
        g.fillRect(round(x-width/2), round(y), round(width*3/2), round(height));
        g.setColor(Color.BLACK);
        g.drawLine(round(x+width/2), round(y), round(x+width/2), round(y+height));
        g.drawRect(round(x-width/2), round(y), round(width*3/2), round(height));
        drawCircle(g, round(x-width/3), round(y+height), round(width/4), round(width/4));
        g.setColor(Color.WHITE);
        drawCircle(g, round(x-width/3), round(y+height), round(width/6), round(width/6));
        g.setColor(Color.BLACK);
        drawCircle(g, round(x-width/3), round(y+height), round(width/8), round(width/8));
    }

    public void drawWindow(Graphics2D g) {
        Polygon second = new Polygon();
        second.addPoint(round(width-width/8), 0);
        second.addPoint(round(width-width/4), round(-height));
        second.addPoint(round(width-width/2), round(-height));
        second.addPoint(round(width-width/2), 0);
        second.translate(round(x), round(y));
        g.setColor(new Color(255, 255, 255, 128));
        g.fillPolygon(second);
        g.setColor(Color.BLACK);
        g.drawPolygon(second);
    }

    @Override
    public void drawMe(Graphics2D g) {
        drawFrame(g);
        drawWindow(g);
        super.drawWheels(g);
    }
}
