import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
	private Canvas canvas;
	private JFrame frame;
	private BufferStrategy bs;
	private Graphics graphics;
	private BufferedImage map;
	private Animation lastUpdatedAnimation = Player.minotaur;

	private int randRight;
	private int randLeft;
	private int rand;
	
	public Window(int width, int height, float scale, String title, Game game) {
		canvas = new Canvas();
		Dimension dimension = new Dimension((int) (width * scale), (int) (height * scale));

		canvas.setPreferredSize(dimension);
		canvas.setMaximumSize(dimension);
		canvas.setMinimumSize(dimension);
		
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		graphics = bs.getDrawGraphics();
		
		map = Sprite.loadSprite("mapOLD.jpg");
		
		Player.setX(canvas.getWidth() / 2);
		Player.setY(canvas.getHeight() - 138);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public void update() {
		if(lastUpdatedAnimation != Player.minotaur) {
			lastUpdatedAnimation.reset();
		}
		
		paint();
		Player.minotaur.update(); // updating the minotaur
		lastUpdatedAnimation = Player.minotaur;
		bs.show();
	}

	public void paint() {
		graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graphics.drawImage(map, 0, 0, canvas.getWidth(), canvas.getHeight(), null); // drawing the map
		graphics.drawImage(Player.minotaur.getSprite(), Player.getX(), Player.getY(), 120, 120, null);
		this.monster();
	}
	
	public void monster() {
//		if(Game.sixtySeconds == 60) {
			randRight = (int) (Math.random() * ((canvas.getWidth() + 1  - Sprite.monsterTILE_SIZEx - 42) - (Player.getX() + 201))) + (Player.getX() + 201);
			randLeft = (int) (Math.random() * (Player.getX() - 201));

			if(canvas.getX() - 500 < Player.getX()) {
				
			}

			Monster m1 = new Monster(rand, Game.height - 102);
			graphics.drawImage(m1.monster.getSprite(), m1.getX(), m1.getY(), 60, 68, null);
			m1.monster.update(); // updating the monster
//		}
	}
}