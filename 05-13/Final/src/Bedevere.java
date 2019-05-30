import javax.imageio.ImageIO;
import java.io.*;

public class Bedevere extends Player {
    public Bedevere(int x, int y) {
        super(x, y, 75, 187);
        try {
            this.image = ImageIO.read(new File("img/bedevere.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
