import javax.imageio.ImageIO;
import java.io.*;

public class ThreeHeadedGiant extends Player {
    public ThreeHeadedGiant(int x, int y) {
        super(x, y, 230, 228);
        try {
            this.image = ImageIO.read(new File("img/threeheadedgiant.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
