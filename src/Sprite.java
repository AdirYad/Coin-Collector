import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
	private static final BufferedImage playerSheet = loadSprite("mino_80x80.png");
    public static final int MINO_SIZEx = 80;
    private static final int MINO_SIZEy = 80;
    

    public static BufferedImage loadSprite(String file) {
        try {
            return ImageIO.read(Sprite.class.getResource("/img/" + file));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public static BufferedImage getPlayerSprite(int xGrid, int yGrid) {
        return playerSheet.getSubimage(xGrid * MINO_SIZEx, yGrid * MINO_SIZEy, MINO_SIZEx, MINO_SIZEy);
    }

}