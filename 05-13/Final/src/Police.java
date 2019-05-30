import javax.imageio.ImageIO;
import java.io.*;

public class Police extends Player {
    public Police(int x, int y) {
        super(x, y, 100, 196);
        try {
            this.image = ImageIO.read(new File("img/police.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}