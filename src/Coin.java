import java.awt.image.BufferedImage;

public class Coin {
	private int x;
	private int y;
	
	//Images for each animation
	final BufferedImage coin = Sprite.loadSprite("coin_128x128.png");

	public Coin() {}
	
	public Coin(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// -------------
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
