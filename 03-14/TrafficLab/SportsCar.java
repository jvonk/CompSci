import java.awt.*;

public class SportsCar extends MediumCar {
    public SportsCar(Color color, double x, double y) {
        super(color, x, y);
        setMaxSpeed(15);
    }

    @Override
    public void drawFrame(Graphics2D g) {
        super.drawFrame(g);
        g.drawLine(round(x+width/4+width/10), round(y+height), round(x+width/5), round(y));
        g.drawLine(round(x+width/2), round(y+height), round(x+width/2), round(y));
    }

    @Override
    public void drawWindows(Graphics2D g) {
        Polygon first = new Polygon();
        first.addPoint(round(width/5), 0);
        first.addPoint(round(width/3), round(-height));
        first.addPoint(round(width/2), round(-height));
        first.addPoint(round(width/2), 0);
        first.translate(round(x), round(y));
        Polygon second = new Polygon();
        second.addPoint(round(width-width/8), 0);
        second.addPoint(round(width-width/3), round(-height));
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

    @Override
    public void drawMe(Graphics2D g) {
        drawFrame(g);
        drawWindows(g);
        super.drawWheels(g);
    }
}