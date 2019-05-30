import javax.imageio.ImageIO;
import java.io.*;

public class Soldier extends Player {
    public Soldier(int x, int y) {
        super(x, y, 90, 259);
        try {
            this.image = ImageIO.read(new File("img/soldier.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
