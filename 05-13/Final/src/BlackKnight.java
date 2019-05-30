import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class BlackKnight extends Player {
    public BufferedImage[] images;
    public int state;

    public BlackKnight(int x, int y) {
        super(x, y, 115, 245);
        images = new BufferedImage[5];
        try {
            for (int i = 1; i <= 5; i++) {
                images[i - 1] = ImageIO.read(new File("img/blackknight/blackknight" + i + ".png"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        state = 0;
        image = images[state];
    }

    public void updateImage(int newState) {
        state = newState;
        image = images[state];
    }
}
