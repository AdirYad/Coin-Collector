import java.awt.event.KeyEvent;

public class Main extends AbstractGame {
	private int frame = 0;
	private int lastAttackFrame = 0;
	
	@Override
	public void update(Game gm, float dt) {
		if(gm.getAl().isKeyDown(KeyEvent.VK_X) && !isAttacking()) {
			gm.getAl().attack();
			lastAttackFrame = frame;
		} else if(gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT) && !isAttacking()) {
			gm.getAl().moveLeft();
			Player.moveLeft();
		} else if(!gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT) && !isAttacking()) {
			gm.getAl().moveRight();
			Player.moveRight();
		} else if((!gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT) || gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT)) && !isAttacking()) {
			gm.getAl().idle();
		}
		frame++;
	}
	
	public static void main(String args[]) {
		Game gc = new Game(new Main());
		gc.start();
	}
	
	public boolean isAttacking() {
		if(lastAttackFrame > 0 && frame > 0 && lastAttackFrame + 72 > frame) {
			return true;
		}
		
		return false;
	}
}