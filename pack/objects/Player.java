package pack.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.framework.GameObject;
import pack.framework.ObjectId;
import pack.framework.Texture;
import pack.window.Animation;
import pack.window.Camera;
import pack.window.Game;
import pack.window.Handler;
import pack.window.Level;

public class Player extends GameObject{
	
	private float width = 32, height = 32;
	private Level level;
	private Handler handler;
	private Camera cam;
	Texture tex = Game.getInstance();
	HealthBar health = new HealthBar(0,0,ObjectId.HealthBar,10);
	
	private Animation playerdown;
	private Animation playerright;
	private Animation playerleft;
	private Animation playerup;
	
	public Player(float x, float y, Handler handler, Camera cam, Level level, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		this.cam = cam;
		this.level = level;
		playerdown = new Animation(6, tex.player[0], tex.player[1]);
		playerright = new Animation(6, tex.player[2], tex.player[3]);
		playerleft = new Animation(6, tex.player[4], tex.player[5]);
		playerup = new Animation(6, tex.player[6], tex.player[7]);
		handler.addObject(health);
	}


	
	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		health.setActive(true);
		if(sword == true) {
			velX = 0;
			velY = 0;
		}else {
			x += velX;
			y += velY;
		}
		
		health.setX(5);
		health.setY(5);
		
		playerdown.runAnimation();
		playerright.runAnimation();
		playerleft.runAnimation();
		playerup.runAnimation();
		Collision(object);
	}
	
	private void Collision(LinkedList<GameObject> object) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBoundsTop().intersects(tempObject.getBound())){// checks for intersection with Blocks on the top
					y = tempObject.getY() + height;
					velY = 0;
				}
			}
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBound().intersects(tempObject.getBound())){// checks for intersection with Blocks on the bottom
					y = tempObject.getY() - height;
					velY = 0;
				}
			}
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBoundsLeft().intersects(tempObject.getBound())){// checks for intersection with Blocks on the left
					x = tempObject.getX() + width;
					velX = 0;
				}
			}
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBoundsRight().intersects(tempObject.getBound())){// checks for intersection with Blocks on the right
					x = tempObject.getX() - width;
					velX = 0;
				}
			}
			
			if(tempObject.getId() == ObjectId.Door) {// tempObject becomes block for later collision checks
				if(getBoundsLeft().intersects(tempObject.getBound())){// checks for intersection with Blocks on the left
					handler.clearLevel();
					level.set(1);
					cam.setX(0);
					cam.setY(0);
				}
			}
			
			if(tempObject.getId() == ObjectId.DoorBack) {// tempObject becomes block for later collision checks
				if(getBoundsLeft().intersects(tempObject.getBound())){// checks for intersection with Blocks on the left
					handler.clearLevel();
					level.set(0);
					cam.setX(0);
					cam.setY(0);
				}
			}
			
			
		}
	}// end of collision

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.blue);
		//g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		//down
		if(facing == 22 && sword == true || facing == 2 && sword == true) {//attacking sword
			g.drawImage(tex.player[8], (int)x, (int)y, 32, 32, null);
		}
		else if(facing == 22) {//moving
			playerdown.drawAnimation(g, (int)x, (int)y, 32, 32);
		}
		else if(facing == 2) {//idle
			g.drawImage(tex.player[0], (int) x, (int) y, 32, 32, null);
		}

		//left
		if(facing == 44 && sword == true || facing  == 4 && sword == true) {
			g.drawImage(tex.player[11], (int)x, (int)y, 32, 32, null);
		}
		else if(facing == 44) {
			playerleft.drawAnimation(g, (int)x, (int)y, 32, 32);
		}
		else if(facing == 4) {
			g.drawImage(tex.player[4], (int) x, (int) y, 32, 32, null);
		}
		
		//right
		if(facing == 66 && sword == true || facing == 6 && sword == true) {
			g.drawImage(tex.player[10], (int)x, (int)y, 32, 32, null);
		}
		else if(facing == 66) {
			playerright.drawAnimation(g, (int)x, (int)y, 32, 32);
		}
		else if(facing == 6) {
			g.drawImage(tex.player[3], (int) x, (int) y, 32, 32, null);
		}
		
		//left
		if(facing == 88 && sword == true || facing == 8 && sword == true) {
			g.drawImage(tex.player[9], (int)x, (int)y, 32, 32, null);
		}
		else if(facing == 88) {
			playerup.drawAnimation(g, (int)x, (int)y, 32, 32);
		}
		else if(facing == 8) {
			g.drawImage(tex.player[6], (int) x, (int) y, 32, 32, null);
		}
		
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		//hit boxes for player
		g2d.draw(getBound());// bottom
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
		
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
		public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+width-7), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
	
}// end of class
