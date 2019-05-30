import javax.imageio.ImageIO;
import java.io.*;

public class Galahad extends Player {
    public Galahad(int x, int y) {
        super(x, y, 85, 172);
        try {
            this.image = ImageIO.read(new File("img/galahad.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
