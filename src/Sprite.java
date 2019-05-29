import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
    private static BufferedImage spriteSheet;
    private static final int TILE_SIZEx = 103;
    private static final int TILE_SIZEy = 90;

    public static BufferedImage loadSprite(String file) {
        try {
            return ImageIO.read(Sprite.class.getResource("/img/" + file));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid) {
        if (spriteSheet == null) {
            spriteSheet = loadSprite("Minotaur_103x90.png");
        }

        return spriteSheet.getSubimage(xGrid * TILE_SIZEx, yGrid * TILE_SIZEy, TILE_SIZEx, TILE_SIZEy);
    }
}