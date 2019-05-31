import java.awt.event.KeyEvent;

public class Main extends AbstractGame {
	private int attackCounter;
	
	@Override
	public void update(Game gm, float dt) {
		if(gm.getAl().isKeyDown(KeyEvent.VK_X) && attackCounter == 0 || attackCounter > 0) {
			attackCounter++;
			gm.getAl().attack();
			if(attackCounter > 50) {
				attackCounter = 0;
			}
		} else if(gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT) && attackCounter == 0) {
			gm.getAl().moveLeft();
		} else if(!gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT) && attackCounter == 0) {
			gm.getAl().moveRight();
		} else if((!gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT) || gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT)) && attackCounter == 0) {
			gm.getAl().idle();
		}
	}
	
	public static void main(String args[]) {
		Game gc = new Game(new Main());
		gc.start();
	}
}