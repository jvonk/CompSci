import java.awt.*;

public class Sedan extends MediumCar {
    public Sedan(Color color, double x, double y) {
        super(color, x, y);
    }

    @Override
    public void drawFrame(Graphics2D g) {
        super.drawFrame(g);
        g.drawLine(round(x+width/4+width/10), round(y+height), round(x+width/5), round(y));
        g.drawLine(round(x+width-width/4), round(y+height), round(x+width-width/8), round(y));
        g.drawLine(round(x+width/2), round(y+height), round(x+width/2), round(y));
    }

    @Override
    public void drawMe(Graphics2D g) {
        drawFrame(g);
        super.drawWindows(g);
        super.drawWheels(g);
    }
}