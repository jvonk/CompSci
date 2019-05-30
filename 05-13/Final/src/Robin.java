import javax.imageio.ImageIO;
import java.io.*;

public class Robin extends Player {
    public Robin(int x, int y) {
        super(x, y, 84, 172);
        try {
            this.image = ImageIO.read(new File("img/Robin.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
