import java.awt.*;

public class BigCar extends Automobile {
    public BigCar (Color color, double x, double y) {
        super(color, x, y);
        setWidth(90);
        setHeight(15);
    }

    @Override
    public void drawFrame(Graphics2D g) {
        g.setColor(Color.YELLOW);
        drawCircle(g, x+width, y+height/3, height/4, height/4);
        g.setColor(Color.RED);
        drawCircle(g, x, y+height/3, height/4, height/4);
        g.setColor(Color.BLACK);
    }

    @Override
    public void drawWheels(Graphics2D g) {
        super.drawWheels(g);
        g.setColor(Color.WHITE);
        drawCircle(g, x+width/4, y+height, width/6, width/6);
        drawCircle(g, x+3*width/4, y+height, width/6, width/6);
        g.setColor(Color.BLACK);
        drawCircle(g, x+width/4, y+height, width/8, width/8);
        drawCircle(g, x+3*width/4, y+height, width/8, width/8);
    }

    @Override
    public void drawMe(Graphics2D g) {
        super.drawFrame(g);
        super.drawWindows(g);
        drawFrame(g);
        drawWheels(g);
    }
}