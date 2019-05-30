import javax.imageio.ImageIO;
import java.io.*;

public class BridgeKeeper extends Player {
    public BridgeKeeper(int x, int y) {
        super(x, y, 270, 350);
        try {
            this.image = ImageIO.read(new File("img/bridgekeeper.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}