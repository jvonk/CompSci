import javax.imageio.ImageIO;
import java.io.*;

public class NiKnight extends Player {
    public NiKnight(int x, int y) {
        super(x, y, 129, 287);
        try {
            this.image = ImageIO.read(new File("img/ni.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
