package pack.framework;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		//BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
		BufferedImage img = image.getSubimage(col, row, width, height);
		return img;
	}
	public BufferedImage grabPlayer(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage(col, row, width, height);
		return img;
	}
	public BufferedImage grabSword(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage(col, row, width, height);
		return img;
	}
	public BufferedImage grabMonster(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage(col, row, width, height);
		return img;
	}
	
}
