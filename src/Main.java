import java.awt.event.KeyEvent;

public class Main extends AbstractGame {
	@Override
	public void update(Game gm, float dt) {
		if(gm.getAl().isKeyDown(KeyEvent.VK_X)) {
			gm.getAl().attack();
			
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		} else if(gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT)) {
			gm.getAl().moveLeft();
		} else if(!gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT)) {
			gm.getAl().moveRight();
		} else if(!gm.getAl().isKey(KeyEvent.VK_LEFT) && !gm.getAl().isKey(KeyEvent.VK_RIGHT) || gm.getAl().isKey(KeyEvent.VK_LEFT) && gm.getAl().isKey(KeyEvent.VK_RIGHT)) {
			gm.getAl().idle();
		}
	}
	
	public static void main(String args[]) {
		Game gc = new Game(new Main());
		gc.start();
	}
}