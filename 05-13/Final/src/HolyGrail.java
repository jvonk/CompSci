import javax.imageio.ImageIO;
import java.io.*;

public class HolyGrail extends Item {
    public HolyGrail(int x, int y) {
        super(x, y, 80, 128);
        try {
            this.image = ImageIO.read(new File("img/holygraillarger.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        className = "Holy Grail";
    }
}
