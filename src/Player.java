import java.awt.image.BufferedImage;

enum PlayerDirection {
	LEFT,
	RIGHT
}

public class Player {
	private static PlayerDirection direction = PlayerDirection.RIGHT;
	private static int x;
	private static int y;
	private static int STEP = 5;

	//Images for each animation
	static final BufferedImage[] minotaurIdleRight = {
		Sprite.getPlayerSprite(0, 0),
		Sprite.getPlayerSprite(1, 0),
		Sprite.getPlayerSprite(2, 0),
		Sprite.getPlayerSprite(3, 0),
		Sprite.getPlayerSprite(4, 0)
	};
	static final BufferedImage[] minotaurIdleLeft = {
		Sprite.getPlayerSprite(0, 1),
		Sprite.getPlayerSprite(1, 1),
		Sprite.getPlayerSprite(2, 1),
		Sprite.getPlayerSprite(3, 1),
		Sprite.getPlayerSprite(4, 1)
	};
	static final BufferedImage[] minotaurAttackRight = {
		Sprite.getPlayerSprite(0, 4),
		Sprite.getPlayerSprite(1, 4),
		Sprite.getPlayerSprite(2, 4),
		Sprite.getPlayerSprite(3, 4),
		Sprite.getPlayerSprite(4, 4),
		Sprite.getPlayerSprite(5, 4),
		Sprite.getPlayerSprite(6, 4),
		Sprite.getPlayerSprite(7, 4),
		Sprite.getPlayerSprite(8, 4)
	};
	static final BufferedImage[] minotaurAttackLeft = {
			Sprite.getPlayerSprite(0, 5),
			Sprite.getPlayerSprite(1, 5),
			Sprite.getPlayerSprite(2, 5),
			Sprite.getPlayerSprite(3, 5),
			Sprite.getPlayerSprite(4, 5),
			Sprite.getPlayerSprite(5, 5),
			Sprite.getPlayerSprite(6, 5),
			Sprite.getPlayerSprite(7, 5),
			Sprite.getPlayerSprite(8, 5)
		};
	static final BufferedImage[] walkingRight = {
		Sprite.getPlayerSprite(0, 2),
		Sprite.getPlayerSprite(1, 2),
		Sprite.getPlayerSprite(2, 2),
		Sprite.getPlayerSprite(3, 2),
		Sprite.getPlayerSprite(4, 2)
	};
	static final BufferedImage[] walkingLeft = {
		Sprite.getPlayerSprite(0, 3),
		Sprite.getPlayerSprite(1, 3),
		Sprite.getPlayerSprite(2, 3),
		Sprite.getPlayerSprite(3, 3),
		Sprite.getPlayerSprite(4, 3)
	};
	
	//These are animation states
	static final Animation MinoIdleRight = new Animation(minotaurIdleRight, 5);
	static final Animation MinoIdleLeft = new Animation(minotaurIdleLeft, 5);
	static final Animation MinoAttackRight = new Animation(minotaurAttackRight, 6);
	static final Animation MinoAttackLeft = new Animation(minotaurAttackLeft, 6);
	static final Animation MinoWalkRight = new Animation(walkingRight, 5);
	static final Animation MinoWalkLeft = new Animation(walkingLeft, 5);
	
	//This is the actual animation
	static Animation minotaur = MinoIdleRight;
	
	public static Animation getIdle() {
		if(direction == PlayerDirection.RIGHT) {
			return MinoIdleRight;
		}
		return MinoIdleLeft;
	}
	
	public static Animation getAttack() {
		if(direction == PlayerDirection.RIGHT) {
			return MinoAttackRight;
		}
		return MinoAttackLeft;
	}
	
	public static void moveRight() {
		if(Player.x + STEP <= Game.width - Sprite.MINO_SIZEx - 18) {
			Player.x += STEP;
		}
		
		Player.direction = PlayerDirection.RIGHT;
	}
	
	public static void moveLeft() {
		if(Player.x - STEP > 0) {
			Player.x -= STEP;
		}
		
		Player.direction = PlayerDirection.LEFT;
	}
	
	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Player.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Player.y = y;
	}
	
	public static int getSTEP() {
		return STEP;
	}

	public static void setSTEP(int sTEP) {
		STEP = sTEP;
	}
}