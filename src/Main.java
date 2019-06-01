import java.awt.event.KeyEvent;

public class Main extends AbstractGame {
	
	private int frame = 0;
	private int lastAttackFrame = 0;
	
	@Override
	public void update(Game gm, float dt) {
		if(gm.getAl().isKeyDown(KeyEvent.VK_X) && !isAttacking()) {
			gm.getAl().playerAttack();
			lastAttackFrame = frame;
		} else if(gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT) && !isAttacking()) {
			gm.getAl().playerMoveLeft();
			Player.moveLeft();
		} else if(!gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT) && !isAttacking()) {
			gm.getAl().playerMoveRight();
			Player.moveRight();
		} else if((!gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT) || gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT)) && !isAttacking()) {
			gm.getAl().playerIdle();
		}
		
		Window.monsters.forEach((i) -> {
			i.monsterIdle();
		});
		
		frame++;
	}
	
	public static void main(String args[]) {
		Game gc = new Game(new Main());
		gc.start();
	}
	
	public boolean isAttacking() {
		if(lastAttackFrame > 0 && frame > 0 && lastAttackFrame + 54 > frame) {
			return true;
		}
		
		return false;
	}
}