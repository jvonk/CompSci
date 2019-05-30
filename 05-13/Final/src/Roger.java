import javax.imageio.ImageIO;
import java.io.*;

public class Roger extends Player {
    public Roger(int x, int y) {
        super(x, y, 96, 200);
        try {
            this.image = ImageIO.read(new File("img/rogerlarge.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
