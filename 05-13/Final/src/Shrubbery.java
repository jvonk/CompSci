import javax.imageio.ImageIO;
import java.io.*;

public class Shrubbery extends Item {
    public Shrubbery(int x, int y) {
        super(x, y, 84, 90);
        try {
            this.image = ImageIO.read(new File("img/shrubbery.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        className = "Shrubbery";
    }
}