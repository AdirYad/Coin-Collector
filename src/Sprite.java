import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
	private static final BufferedImage playerSheet = loadSprite("mino_80x80.png");
	private static final BufferedImage monsterSheet = loadSprite("Dwarf.png");
    public static final int minoTILE_SIZEx = 80;
    private static final int minoTILE_SIZEy = 80;
    public static final int monsterTILE_SIZEx = 30;
    private static final int monsterTILE_SIZEy = 32;
    

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
        return playerSheet.getSubimage(xGrid * minoTILE_SIZEx, yGrid * minoTILE_SIZEy, minoTILE_SIZEx, minoTILE_SIZEy);
    }


    public static BufferedImage getMonsterSprite(int xGrid, int yGrid) {
        return monsterSheet.getSubimage(xGrid * monsterTILE_SIZEx, yGrid * monsterTILE_SIZEy, monsterTILE_SIZEx, monsterTILE_SIZEy);
    }
}