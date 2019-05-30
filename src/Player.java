import java.awt.image.BufferedImage;

public class Player {
	//Images for each animation
		BufferedImage[] minotaurIdle = {
			Sprite.getSprite(0, 0),
			Sprite.getSprite(1, 0),
			Sprite.getSprite(2, 0),
			Sprite.getSprite(3, 0),
			Sprite.getSprite(4, 0)
		};
		private BufferedImage[] minotaurAttack1 = {
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
		private BufferedImage[] walkingRight = {
			Sprite.getSprite(0, 1),
			Sprite.getSprite(1, 1),
			Sprite.getSprite(2, 1),
			Sprite.getSprite(3, 1),
			Sprite.getSprite(4, 1),
			Sprite.getSprite(5, 1),
			Sprite.getSprite(6, 1),
			Sprite.getSprite(7, 1)
		};
		private BufferedImage[] walkingLeft = {
			Sprite.getSprite(0, 12),
			Sprite.getSprite(1, 12),
			Sprite.getSprite(2, 12),
			Sprite.getSprite(3, 12),
			Sprite.getSprite(4, 12)
		};
		
		//These are animation states
		Animation MinoIdle = new Animation(minotaurIdle, 10);
		Animation MinoAttack1 = new Animation(minotaurAttack1, 10);
		Animation MinoWalkRight = new Animation(walkingRight, 10);
		Animation MinoWalkLeft = new Animation(walkingLeft, 10);
		
		//This is the actual animation
		Animation minotaur = MinoIdle;
}