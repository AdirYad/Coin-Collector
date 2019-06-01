import java.awt.image.BufferedImage;

enum MonsterDirection {
	LEFT,
	RIGHT
}

public class Monster {
	MonsterDirection direction = MonsterDirection.RIGHT;
	private int x;
	private int y;
	private int STEP = 2;
	private int hp;
	private boolean ifNew;

	//Images for each animation
	private final BufferedImage[] monsterIdleRight = {
		Sprite.getMonsterSprite(0, 0),
		Sprite.getMonsterSprite(1, 0),
		Sprite.getMonsterSprite(2, 0),
		Sprite.getMonsterSprite(3, 0),
		Sprite.getMonsterSprite(4, 0)
	};
	private final BufferedImage[] monsterIdleLeft = {
		Sprite.getMonsterSprite(0, 5),
		Sprite.getMonsterSprite(1, 5),
		Sprite.getMonsterSprite(2, 5),
		Sprite.getMonsterSprite(3, 5),
		Sprite.getMonsterSprite(4, 5)
	};
	private final BufferedImage[] monsterAttackRight = {
		Sprite.getMonsterSprite(0, 2),
		Sprite.getMonsterSprite(1, 2),
		Sprite.getMonsterSprite(2, 2),
		Sprite.getMonsterSprite(3, 2),
		Sprite.getMonsterSprite(4, 2),
		Sprite.getMonsterSprite(5, 2),
		Sprite.getMonsterSprite(6, 2)
	};
	private final BufferedImage[] monsterAttackLeft = {
		Sprite.getMonsterSprite(0, 7),
		Sprite.getMonsterSprite(1, 7),
		Sprite.getMonsterSprite(2, 7),
		Sprite.getMonsterSprite(3, 7),
		Sprite.getMonsterSprite(4, 7),
		Sprite.getMonsterSprite(5, 7),
		Sprite.getMonsterSprite(6, 7)
	};
	private final BufferedImage[] walkingRight = {
		Sprite.getMonsterSprite(0, 3),
		Sprite.getMonsterSprite(1, 3),
		Sprite.getMonsterSprite(2, 3),
		Sprite.getMonsterSprite(3, 3)
	};
	private final BufferedImage[] walkingLeft = {
		Sprite.getMonsterSprite(0, 8),
		Sprite.getMonsterSprite(1, 8),
		Sprite.getMonsterSprite(2, 8),
		Sprite.getMonsterSprite(3, 8)
	};
	
	//These are animation states
	final Animation MonsterIdleRight = new Animation(monsterIdleRight, 5);
	final Animation MonsterIdleLeft = new Animation(monsterIdleLeft, 5);
	final Animation MonsterAttackRight = new Animation(monsterAttackRight, 8);
	final Animation MonsterAttackLeft = new Animation(monsterAttackLeft, 8);
	final Animation MonsterWalkRight = new Animation(walkingRight, 5);
	final Animation MonsterWalkLeft = new Animation(walkingLeft, 5);
	
	//This is the actual animation
	Animation monster = MonsterIdleRight;
	
	public Monster(int x, int y) {
		this.x = x;
		this.y = y;
		ifNew = true;
	}
	
	public Animation monsterGetIdle() {
		if(direction == MonsterDirection.RIGHT) {
			return MonsterIdleRight;
		}
		return MonsterIdleLeft;
	}
	
	public Animation monsterGetAttack() {
		if(direction == MonsterDirection.RIGHT) {
			return MonsterAttackRight;
		}
		return MonsterAttackLeft;
	}
	
	public void moveRight() {
		if(x + STEP <= Game.width - Sprite.monsterTILE_SIZEx - 10) {
			x += STEP;
		}
		
		direction = MonsterDirection.RIGHT;
	}
	
	public void moveLeft() {
		if(x - STEP > 0) {
			x -= STEP;
		}
		
		direction = MonsterDirection.LEFT;
	}
	
	public void monsterMoveLeft() {
		monster = MonsterWalkLeft;
	    monster.start();
	}
	
	public void monsterMoveRight() {
	    monster = MonsterWalkLeft;
	    monster.start();
	}
	
	public void monsterAttack() {
		monster = monsterGetAttack();
		monster.start();
	}
	
	public void monsterIdle() {
		monster = monsterGetIdle();
		monster.start();
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public boolean isIfNew() {
		return ifNew;
	}

	public void setIfNew(boolean ifNew) {
		this.ifNew = ifNew;
	}
}
