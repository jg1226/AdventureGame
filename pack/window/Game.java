package pack.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pack.framework.GameObject;
import pack.framework.KeyInput;
import pack.framework.ObjectId;
import pack.framework.Texture;
import pack.objects.Block;
import pack.objects.Door;
import pack.objects.Octorock;
import pack.objects.Player;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean running = false;
	private Thread thread;
	public static int WIDTH, HEIGHT;
	public static Font font28;
	private BufferedImage background = null;
	
	//object
	
	Handler handler;
	Level level;
	Camera cam;
	static Texture tex;
	
	private void init() {// Initializer
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		background = loader.loadImage("/Ground.png");
		
		
		handler = new Handler();
		
		cam = new Camera(0,0);
		
		level = new Level(cam, handler);
		level.LoadImageLevel(level.getLevel(0));

		
		//handler.addObject(new Player(100, 100, handler, ObjectId.Player)); OG level is being called on from the handler class
		//handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
	}

	public synchronized void start() {
		if(running) {// prevents start from being called twice and creating more threads
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		init();//Initializes everything
		this.requestFocus();
		System.out.println("thread has begun");
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime= now;
			while(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}

	}// end of run

	private void tick() {// ticks is number of updates
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ObjectId.Player)
				cam.tick(handler.object.get(i));
		}
		
		
	}

	private void render() {// graphical stuff

		BufferStrategy bs = this.getBufferStrategy();// "this" is a canvas method
		if(bs == null) { // bs is defaulted to null
			this.createBufferStrategy(3);// buffer strategy is important because it sets a limit to the speed the computer can render an images
			return;//by setting the number 3 we are triple buffering creating three images if the computer has enough time and simply replacing them as needed
		}// three is a bit over kill most computers have a hard time doing that if they even can

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
 		/////////////////////////////////// 
		//draw between comment lines
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(), cam.getY());// begin of cam everything inbetween is effected by the cam
		
		for(int xx = 0; xx < background.getWidth() * 5; xx += background.getWidth()) {
			g.drawImage(background, xx, 0, this);
			g.drawImage(background, xx, 358, this);
		}
			
			handler.render(g);// renders objects
		
		g2d.translate(-cam.getX(), -cam.getY());// end of cam
		///////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static Texture getInstance() {
		return tex;
	}
	
	public static void main(String args[]){
			new Window(1000, 600, "Fantasy", new Game());
		
		
	}// end of main

}// end of class
