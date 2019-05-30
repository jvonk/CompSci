import javax.imageio.ImageIO;
import java.io.*;

public class Coconuts extends Item {
    public Coconuts(int x, int y) {
        super(x, y, 84, 90);
        try {
            this.image = ImageIO.read(new File("img/coconuts.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        className = "Coconuts";
    }
}