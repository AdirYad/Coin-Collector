import java.awt.image.BufferedImage;

public class Player {
	//Images for each animation
		static final BufferedImage[] minotaurIdle = {
			Sprite.getSprite(0, 0),
			Sprite.getSprite(1, 0),
			Sprite.getSprite(2, 0),
			Sprite.getSprite(3, 0),
			Sprite.getSprite(4, 0)
		};
		static final BufferedImage[] minotaurAttack1 = {
			Sprite.getSprite(0, 3),
			Sprite.getSprite(1, 3),
			Sprite.getSprite(2, 3),
			Sprite.getSprite(3, 3),
			Sprite.getSprite(4, 3),
			Sprite.getSprite(5, 3),
			Sprite.getSprite(6, 3),
			Sprite.getSprite(7, 3),
			Sprite.getSprite(8, 3)
		};
		static final BufferedImage[] walkingRight = {
			Sprite.getSprite(0, 1),
			Sprite.getSprite(1, 1),
			Sprite.getSprite(2, 1),
			Sprite.getSprite(3, 1),
			Sprite.getSprite(4, 1)
		};
		static final BufferedImage[] walkingLeft = {
			Sprite.getSprite(0, 2),
			Sprite.getSprite(1, 2),
			Sprite.getSprite(2, 2),
			Sprite.getSprite(3, 2),
			Sprite.getSprite(4, 2)
		};
		
		//These are animation states
		static final Animation MinoIdle = new Animation(minotaurIdle, 10);
		static final Animation MinoAttack1 = new Animation(minotaurAttack1, 10);
		static final Animation MinoWalkRight = new Animation(walkingRight, 10);
		static final Animation MinoWalkLeft = new Animation(walkingLeft, 10);
		
		//This is the actual animation
		static Animation minotaur = MinoIdle;
}