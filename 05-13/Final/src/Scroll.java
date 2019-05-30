import javax.imageio.ImageIO;
import java.io.*;

public class Scroll extends Item {
    public Scroll(int x, int y) {
        super(x, y, 75, 90);
        try {
            this.image = ImageIO.read(new File("img/scroll.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        className = "Scroll";
    }
}
