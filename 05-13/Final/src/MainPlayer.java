import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class MainPlayer extends Player {
    public BufferedImage[] images;
    public MainPlayer(int x, int y) {
        super(x, y, 104, 240);
        images = new  BufferedImage[8];
        for (int i = 1; i <= 8; i++) {
            try {
                images[i - 1] = ImageIO.read(new File("img/kingarthur/kingarthur" + i + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        image = images[0];
    }

    public void updateImage(MovementState movementState) {
        int index = -1;
        if      (movementState.xDirection==0 && movementState.yDirection >0) index = 0;
        else if (movementState.xDirection <0 && movementState.yDirection >0) index = 1;
        else if (movementState.xDirection <0 && movementState.yDirection==0) index = 2;
        else if (movementState.xDirection <0 && movementState.yDirection <0) index = 3;
        else if (movementState.xDirection==0 && movementState.yDirection <0) index = 4;
        else if (movementState.xDirection >0 && movementState.yDirection <0) index = 5;
        else if (movementState.xDirection >0 && movementState.yDirection==0) index = 6;
        else if (movementState.xDirection >0 && movementState.yDirection >0) index = 7;
        if (index>=0) image = images[index];
    }
}
