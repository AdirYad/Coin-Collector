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
		Player.x = canvas.getWidth() / 2;
		Player.y = canvas.getHeight() - 138;
		
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
		Monster m1 = new Monster(100, 11);
		graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graphics.drawImage(map, 0, 0, canvas.getWidth(), canvas.getHeight(), null); // drawing the map
		graphics.drawImage(Player.minotaur.getSprite(), Player.x, Player.y, 120, 120, null);
//		m1.runMonster();
	}
}