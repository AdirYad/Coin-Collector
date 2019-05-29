import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
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
	private Player player;
	
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
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void update() {
//		graphics.setColor(Color.black);
//		graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight()); // filling background in black
		
		graphics.drawImage(map, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		graphics.drawImage(Sprite.getSprite(0, 0), 111, 111, null);
//		player.minotaur.update();
		bs.show(); 
	}
}