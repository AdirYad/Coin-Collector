import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.swing.JFrame;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Window {
	private static void printUsage() {
	  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
	  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
	    method.setAccessible(true);
	    if (method.getName().startsWith("get")
	        && Modifier.isPublic(method.getModifiers())) {
	            Object value;
	        try {
	            value = method.invoke(operatingSystemMXBean);
	        } catch (Exception e) {
	            value = e;
	        } // try
	        System.out.println(method.getName() + " = " + value);
	    } // if
	  } // for
	}
	private Canvas canvas;
	private JFrame frame;
	private BufferStrategy bs;
	private Graphics graphics;
	private BufferedImage map;
	
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
		
//		graphics.drawImage(Player.minotaur.getSprite(), canvas.getWidth() / 2, canvas.getHeight() - 110, null);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	private int c;
			
	public void update() {
		paint();
		Player.minotaur.update(); // updating the minotaur
		c++;
		if(c >= 300) {
			c = 0;
			printUsage();
		}
		bs.show();
	}
	
	public void paint() {
//		graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graphics.drawImage(map, 0, 0, canvas.getWidth(), canvas.getHeight(), null); // drawing the map
		graphics.drawImage(Player.minotaur.getSprite(), canvas.getWidth() / 2, canvas.getHeight() - 138, 120, 120, null);
	}
}