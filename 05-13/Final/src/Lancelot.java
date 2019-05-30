import javax.imageio.ImageIO;
import java.io.*;

public class Lancelot extends Player {
    public Lancelot(int x, int y) {
        super(x, y, 83, 172);
        try {
            this.image = ImageIO.read(new File("img/lancelot.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
