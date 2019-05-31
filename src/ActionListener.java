import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionListener implements KeyListener {
	private Game gm;
	
	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];
	private boolean[] keysLast = new boolean[NUM_KEYS];

	public ActionListener(Game gm) {
		this.gm = gm;

		gm.getWindow().getCanvas().addKeyListener(this);
	}
	
	public void update() {
		for(int i = 0; i < NUM_KEYS; i++) {
			keysLast[i] = keys[i];
		}
	}

	public boolean isKey(int keyCode) {
		return keys[keyCode];
	}
	
	public boolean isKeyUp(int keyCode) {
		return !keys[keyCode] && keysLast[keyCode];
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode] && !keysLast[keyCode];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	public void moveLeft() {
//    	System.out.println("Left");
	    Player.minotaur = Player.MinoWalkLeft;
	    Player.minotaur.start();
	}
	
	public void moveRight() {
//    	System.out.println("Right");
	    Player.minotaur = Player.MinoWalkRight;
	    Player.minotaur.start();
	}
	
	public void attack() {
//    	System.out.println("attack");
	    Player.minotaur = Player.MinoAttack1;
	    Player.minotaur.start();
	}
	
	public void idle() {
//		System.out.println("idling");
		Player.minotaur.stop();
		Player.minotaur.reset();
		Player.minotaur = Player.MinoIdle;
	}
}