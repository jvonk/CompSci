import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class MainPlayer extends Player {
    public BufferedImage[] images;
    public BufferedImage image;
    public MainPlayer(int x, int y) {
        super(x, y);
        this.width = 104;
        this.height = 240;
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

    @Override
    public void drawMe(Graphics2D g) {
        g.drawImage(image, x-width/2, y-height, null);
    }

    public void updateImage(Screen.MovementState movementState) {
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
