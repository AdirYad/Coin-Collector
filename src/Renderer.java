//import java.awt.image.DataBufferInt;
//
//public class Renderer {
//	private int pW, pH; // pixel width, pixel height
//	private int[] p; // pixels
//	
//	public Renderer(Game gc) {
//		pW = Game.width;
//		pH = Game.height;
//		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
//	}
//	
//	public void clear() {
//		for(int i = 0; i < p.length; i++) {
//			p[i] = 0;
//		}
//	}
//}