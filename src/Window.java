import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.List;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
	private Canvas canvas;
	private JFrame frame;
	private BufferStrategy bs;
	private Graphics graphics;
	private BufferedImage map;
	private Animation lastUpdatedPlayerAnimation = Player.minotaur;

	private int randRight;
	private int randLeft;
	private int rand;
	private int counter;
	
	static public List<Monster> monsters = new ArrayList<Monster>();
	private List<Animation> lastUpdatedMonsterAnimation = new ArrayList<Animation>();
	
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
		if(lastUpdatedPlayerAnimation != Player.minotaur) {
			lastUpdatedPlayerAnimation.reset();
		}
		
		monsters.forEach(i -> {
			if(lastUpdatedMonsterAnimation.get(monsters.indexOf(i)) != i.monster) {
				i.monster.reset();
			}
		});
		
		paint();
		Player.minotaur.update(); // updating the minotaur
		monsters.forEach(i -> {
			i.monster.update(); // updating the monster
			lastUpdatedMonsterAnimation.set(monsters.indexOf(i), i.monster);
		});
		
		lastUpdatedPlayerAnimation = Player.minotaur;
		bs.show();
	}


	
	public void paint() {
		graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graphics.drawImage(map, 0, 0, canvas.getWidth(), canvas.getHeight(), null); // drawing the map
		graphics.drawImage(Player.minotaur.getSprite(), Player.getX(), Player.getY(), 120, 120, null);
		callMonster();
	}
	
	public void reset() {
		counter = 0;
	}
	
	public void callMonster() {
		createMonster();
		
		monsters.forEach(i -> {
			if(i.isIfNew()) {
				lastUpdatedMonsterAnimation.add(i.monster);
				i.setIfNew(false);
			}

			graphics.drawImage(i.monster.getSprite(), i.getX(), i.getY(), 60, 68, null);
		});
	}
	
	public void createMonster() {
		if(Game.sixtySeconds == 1) {
			if(counter == 0) {
				randRight = (int) (Math.random() * ((canvas.getWidth() + 1  - Sprite.monsterTILE_SIZEx - 42) - (Player.getX() + 301))) + (Player.getX() + 301);
				randLeft = (int) (Math.random() * (Player.getX() - 301));
				
				if(canvas.getWidth() - 600 < Player.getX()) {
					rand = randLeft;
				} else if(600 > Player.getX()) {
					rand = randRight;
				} else {
					int leftOrRight = (int) (Math.random() * (3 - 1)) + 1;
					if(leftOrRight == 1) {
						rand = randLeft;
					} else {
						rand = randRight;
					}
				}
				
				counter++;
			}

			monsters.add(new Monster(rand, Game.height - 102));
		}
	}
}