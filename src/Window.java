import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Font;

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
	private int coinsAmount;
	private boolean isCoin;
	private int coinLeftX;
	private int coinRightX;
	private final int coinSize = 128;
	
	private Coin coin = new Coin();
	
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
		graphics.setFont(new Font("Arial", Font.BOLD, 24));
		
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
		
		checkCoin();
		paint();
		paintFont();
		Player.minotaur.update(); // updating the player
		
		lastUpdatedPlayerAnimation = Player.minotaur;
		bs.show();
	}

	public void paint() {
		graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // clearing the frames every nano second
		graphics.drawImage(map, 0, 0, canvas.getWidth(), canvas.getHeight(), null); // drawing the map
		graphics.drawImage(Player.minotaur.getSprite(), Player.getX(), Player.getY(), 120, 120, null); // drawing the player
		if(Game.isThreeSecs()) {
			graphics.drawImage(coin.coin, coin.getX(), Player.getY() + 62, 30, 30, null); // drawing the coins
		}
	}
	
	public void paintFont() {
		graphics.setFont(new Font("Arial", Font.BOLD, 24));
		graphics.setColor(Color.black);
		graphics.drawString("FPS: " + Game.getFps(), 0, 20);
		if(Game.isThreeSecs()) {
			graphics.setColor(Color.lightGray);
			
			if(Player.getX() - 50 >= 35 && Player.getX() - 50 <= 1400) {
				graphics.drawString("Coins Collected: " + coinsAmount, Player.getX() - 50, Player.getY() - 30);
			} else if(Player.getX() - 50 >= 1400) {
				graphics.drawString("Coins Collected: " + coinsAmount, 1400, Player.getY() - 30);
			} else if(Player.getX() - 50 <= 50) {
				graphics.drawString("Coins Collected: " + coinsAmount, 35, Player.getY() - 30);
			}
			
			if(coinsAmount >= 10) {
				graphics.setFont(new Font("Arial", Font.BOLD, 60));
				graphics.setColor(Color.white);
				graphics.drawString("CONGRATS, YOU HAVE REACHED " + coinsAmount + " COINS!", canvas.getWidth() / 2 - 600, 200);
			}
		} else {
			if(Game.getThreeSecs() == 0) {	
				graphics.setFont(new Font("Arial", Font.BOLD, 100));
				graphics.setColor(Color.black);
				graphics.drawString("> GO <", canvas.getWidth() / 2 - 200, canvas.getHeight() / 2 - 100);
			} else {
				graphics.setFont(new Font("Arial", Font.BOLD, 100));
				graphics.setColor(Color.white);
				graphics.drawString("> IN " + Game.getThreeSecs() + " <", canvas.getWidth() / 2 - 200, canvas.getHeight() / 2 - 100);
			}
		}
	}
	
	public void createCoin() {
		rand();
		
		if(rand < 50 || rand > 1500) {
			rand();
		}

		coin = new Coin(rand, Game.height - 65);
		isCoin = true;

		coinLeftX = coin.getX() - 68;
		coinRightX = coin.getX() - 14;
	}
	
	public void checkCoin() {
		if(Player.getX() >= coinLeftX && Player.getX() <= coinRightX) {
			coinsAmount++;
			isCoin = false;
			createCoin();
		}
		
		if(coinsAmount == 0 && !isCoin && Game.isThreeSecs()) { // happens only once - creating the first coin
			createCoin();
		}
	}
	
	public void rand() {
		randRight = (int) (Math.random() * ((canvas.getWidth() + 1  - coinSize - 42) - (Player.getX() + 301))) + (Player.getX() + 301);
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
	}
}