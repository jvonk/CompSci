import javax.imageio.ImageIO;
import java.io.*;

public class TimTheEnchanter extends Player {
    public TimTheEnchanter(int x, int y) {
        super(x, y, 200, 260);
        try {
            this.image = ImageIO.read(new File("img/tim.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}