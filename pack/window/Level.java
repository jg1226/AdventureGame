package pack.window;

import java.awt.Container;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pack.framework.ObjectId;
import pack.objects.Block;
import pack.objects.Octorock;
import pack.objects.Player;

public class Level {
	private BufferedImage[] level = new BufferedImage[3];
	Camera cam;
	Handler handler;
	Container con;
	
	public Level(Camera cam, Handler h) {
		BufferedImageLoader loader = new BufferedImageLoader();
		level[2] = loader.loadImage("/LinkLevel.png");//loading the level
		level[1] = loader.loadImage("/Forest.png");//loading the level
		level[0] = loader.loadImage("/Combat.png");
		this.cam = cam;
		this.handler = h;
		
	}
	
	public void set(int i) {
		LoadImageLevel(level[i]);
	}
	
	public BufferedImage getLevel(int i) {
		return level[i];
	}
	
	public void text() {
		
	}
	
	public void LoadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;
				
				// enemy
				if(red == 225 && green == 79 && blue == 0) handler.addObject(new Octorock(xx*32, yy*32, handler, ObjectId.Octorock));// octorock
			}
		}
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;
	
				// orange blocks
				//mountains
				if(red == 255 && green == 255 && blue == 255) handler.addObject(new Block(xx*32, yy*32, 1, ObjectId.Block));//255,255,255 = white
				if(red == 200 && green == 200 && blue == 200) handler.addObject(new Block(xx*32, yy*32, 2, ObjectId.Block));
				if(red == 150 && green == 150 && blue == 150) handler.addObject(new Block(xx*32, yy*32, 3, ObjectId.Block));
				if(red == 100 && green == 100 && blue == 100) handler.addObject(new Block(xx*32, yy*32, 4, ObjectId.Block));
				if(red == 50 && green == 50 && blue == 50) handler.addObject(new Block(xx*32, yy*32, 5, ObjectId.Block));
				if(red == 25 && green == 25 && blue == 25) handler.addObject(new Block(xx*32, yy*32, 6, ObjectId.Block));
			}
		}
		
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;
	
				//Miscellaneous
				if(red == 0 && green == 255 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 7, ObjectId.Block));// green
				if(red == 0 && green == 200 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 8, ObjectId.Block));
				if(red == 0 && green == 150 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 9, ObjectId.Block));
				if(red == 0 && green == 100 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 10, ObjectId.Door));
				if(red == 0 && green == 50 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 11, ObjectId.Block));
				if(red == 0 && green == 25 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 12, ObjectId.DoorBack));
			}
		}
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;
	
				//water
				if(red == 0 && green == 0 && blue == 255) handler.addObject(new Block(xx*32, yy*32, 13, ObjectId.Block));// blue
				if(red == 0 && green == 0 && blue == 225) handler.addObject(new Block(xx*32, yy*32, 14, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 200) handler.addObject(new Block(xx*32, yy*32, 15, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 175) handler.addObject(new Block(xx*32, yy*32, 16, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 150) handler.addObject(new Block(xx*32, yy*32, 17, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 125) handler.addObject(new Block(xx*32, yy*32, 18, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 100) handler.addObject(new Block(xx*32, yy*32, 19, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 75) handler.addObject(new Block(xx*32, yy*32, 20, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 50) handler.addObject(new Block(xx*32, yy*32, 21, ObjectId.Block));
			}
		}
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;
	
				//tree dungeon
				if(red == 200 && green == 0 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 22, ObjectId.Block));//red
				if(red == 150 && green == 0 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 23, ObjectId.Block));
				if(red == 100 && green == 0 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 24, ObjectId.Block));
				if(red == 50 && green == 0 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 25, ObjectId.Block));
				if(red == 25 && green == 0 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 26, ObjectId.Block));
			}
		}
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;

				//dry 
				if(red == 255 && green == 255 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 27, ObjectId.Block));//yellow
				if(red == 225 && green == 225 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 28, ObjectId.Block));
				if(red == 200 && green == 200 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 29, ObjectId.Block));
				if(red == 175 && green == 175 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 30, ObjectId.Block));
				if(red == 150 && green == 150 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 31, ObjectId.Block));
				if(red == 125 && green == 125 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 32, ObjectId.Block));
				if(red == 100 && green == 100 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 33, ObjectId.Block));
				if(red == 75 && green == 75 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 34, ObjectId.Block));
				if(red == 50 && green == 50 && blue == 0) handler.addObject(new Block(xx*32, yy*32, 35, ObjectId.Block));
				
			}
		}
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;
				// player
				if(red == 255 && green == 0 && blue == 0) handler.addObject(new Player(xx*32, yy*32, handler, cam, this, ObjectId.Player));//player
			}
		}
		text();
		
	}// end of load image
	
}
