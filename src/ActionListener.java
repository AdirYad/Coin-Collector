import java.awt.event.MouseEvent;

public class ActionListener {
	private Player player;

	// Move Left
	public void mousePressedLeft(MouseEvent a) {
	    player.minotaur = player.MinoWalkLeft;
	    player.minotaur.start();
	}
	
	public void mouseReleasedLeft(MouseEvent a) {
		player.minotaur.stop();
		player.minotaur.reset();
		player.minotaur = player.MinoIdle;
	}

	// Move Right
	public void mousePressedRight(MouseEvent d) {
	    player.minotaur = player.MinoWalkLeft;
	    player.minotaur.start();
	}
	
	public void mouseReleasedRight(MouseEvent d) {
		player.minotaur.stop();
		player.minotaur.reset();
		player.minotaur = player.MinoIdle;
	}

	// Attack - Still need to change it to toggle event handler - remind Adir if you see this comment.
	public void mousePressedAttack1(MouseEvent x) {
	    player.minotaur = player.MinoAttack1;
	    player.minotaur.start();
	}
	
	public void mouseReleasedAttack1(MouseEvent x) {
		player.minotaur.stop();
		player.minotaur.reset();
		player.minotaur = player.MinoIdle;
	}
}