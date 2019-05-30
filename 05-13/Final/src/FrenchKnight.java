import javax.imageio.ImageIO;
import java.io.*;

public class FrenchKnight extends Player {
    public FrenchKnight(int x, int y) {
        super(x, y, 95, 225);
        try {
            this.image = ImageIO.read(new File("img/greenknight.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
