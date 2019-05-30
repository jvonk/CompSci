import javax.imageio.ImageIO;
import java.io.*;

public class Rabbit extends Player {
    public Rabbit(int x, int y) {
        super(x, y, 64, 80);
        try {
            this.image = ImageIO.read(new File("img/rabbitlarge.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
