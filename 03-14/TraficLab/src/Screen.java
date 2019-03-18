import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends JPanel {
    private ArrayList<Automobile> cars = new ArrayList<>();
    public Screen() {
        cars.add(new MediumCar(Color.GRAY, 20, 50));
        cars.add(new BigCar(Color.GRAY, 50, 50));
        cars.add(new Sedan(new Color(150, 180, 255), 90, 70));
        cars.add(new SportsCar(new Color(255, 150, 150), 200, 70));
        cars.add(new MediumCar(Color.GRAY, 10, 150));
        cars.add(new SUV(Color.GRAY, 80, 150));
        cars.add(new Truck(Color.GRAY, 260, 150));
        cars.add(new Sedan(new Color(150, 180, 255), 130, 170));
        cars.add(new Truck(new Color(255, 150, 150), 170, 170));
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                repaint();
            }
        });
    }
    public void drawRoad(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, w, h/15);
        g.fillRect(x, y+h-h/15, w, h/15);
        for (int i = 0; i < w; i+=60) {
            g.fillRect(x+i, y+h*7/15, 20, h/15);
        }
    }
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.clearRect(0, 0, getWidth(), getHeight());
        drawRoad(g, 0, 50, getWidth(), 50);
        drawRoad(g, 0, 150, getWidth(), 50);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Automobile a : cars) {
            a.drawMe(g);
        }
    }
    public void update() {
        while (true) {
            try {
                Thread.sleep(10);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            for (Automobile car : cars) {
                car.update(width, cars);
            }
            repaint();
        }
    }
}
