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
import pack.window.Game;
import pack.window.Handler;

public class Octorock extends GameObject{
	private boolean alive = true;
	private float width = 32, height = 28;
	private int count = 0, wait = 40, speed = 3;
	
	private Handler handler;
	
	Texture tex = Game.getInstance();
	
	private Animation Down;
	private Animation Right;
	private Animation Left;
	private Animation Up;
	private Animation Death;
	
	
	
	public Octorock(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
			this.handler = handler;
			Left = new Animation(5, tex.octorock[0], tex.octorock[1]);
			Down = new Animation(5, tex.octorock[2], tex.octorock[3]);
			Right = new Animation(5, tex.octorock[4], tex.octorock[5]);
			Up = new Animation(5, tex.octorock[6], tex.octorock[7]);
			Death = new Animation(5, tex.octorock[8], tex.octorock[9], tex.octorock[10]);
			
	}

	public void tick(LinkedList<GameObject> object){
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(facing != 0) {
			
			if(facing == 88) {//moving up
				velX = 0;
				velY = -1 * speed;
				if(count > wait) {
					facing = 8;
					count = 0;
				}
				count++;
			}
			else if(facing == 8) {//up
				velX = 0;
				velY = 0;
				if(count > wait) {
					facing = 66;
					count = 0;
				}
				count++;
			}
			
			else if(facing == 22) {//moving down
				velX = 0;
				velY = speed;
				if(count > wait) {
					facing = 2;
					count = 0;
				}
				count++;
			}
			else if(facing == 2) {//down
				velX = 0;
				velY = 0;
				if(count > wait) {
					facing = 44;
					count = 0;
				}
				count++;
			}
			
			else if(facing == 66) {//moving right
				velX = speed;
				velY = 0;
				if(count > wait) {
					facing = 6;
					count = 0;
				}
				count++;
			}
			else if(facing == 6) {//right
				velX = 0;
				velY = 0;
				if(count > wait) {
					facing = 22;
					count = 0;
				}
				count++;
			}
			
			else if(facing == 44) {//moving left
				velX = -1*speed;
				velY = 0;
				if(count > wait) {
					facing = 4;
					count = 0;
				}
				count++;
			}
			else if(facing == 4) {//down
				velX = 0;
				velY = 0;
				if(count > wait) {
					facing = 88;
					count = 0;
				}
				count++;
			}
			else if(facing == 666) {//dead animation followed by moving the object to the top left corner of the map
				velX = 0;
				velY = 0;
				if(count > wait) {
					count = 0;
					facing = 0;
					x = 0;
					y = 0;
				}
				count++;
			}
			
			
		}
		
		
		Down.runAnimation();
		Right.runAnimation();
		Left.runAnimation();
		Up.runAnimation();
		Death.runAnimation();
		Collision(object);
	}
	
	private void Collision(LinkedList<GameObject> object) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(alive==true) {
				if(tempObject.getId() == ObjectId.Sword) {// tempObject becomes block for later collision checks
					if(getBound().intersects(tempObject.getBound())){// checks for intersection with Blocks on the left
						facing = 666;
						count = 0;
						alive = false;
						
					}
				}
			}
			

		}
	}
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.red);
		if(facing == 44) {// left moving
			Left.drawAnimation(g, (int)x, (int)y, 32, 28);
		}
		if(facing == 4) {// left
			g.drawImage(tex.octorock[0], (int)x, (int)y, 32, 28, null);
		}
		
		if(facing == 66) {// right moving
			Right.drawAnimation(g, (int)x, (int)y, 32, 28);
		}
		if(facing == 6) {// right
			g.drawImage(tex.octorock[4], (int)x, (int)y, 32, 28, null);
		}
		
		if(facing == 88) {// up moving
			Up.drawAnimation(g, (int)x, (int)y, 32, 28);
		}
		if(facing == 8) {// up
			g.drawImage(tex.octorock[6], (int)x, (int)y, 32, 28, null);
		}
		
		if(facing == 22) {// down moving
			Down.drawAnimation(g, (int)x, (int)y, 32, 28);
		}
		if(facing == 2) {// down
			g.drawImage(tex.octorock[2], (int)x, (int)y, 32, 28, null);
		}
		
		if(facing == 666) {// dead
			Death.drawAnimation(g, (int)x, (int)y, 32, 28);
		}
		
		if(facing == 0) {// one with the earth
			g.drawImage(tex.block[1], (int)x, (int)y, 32, 32, null);
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		//hit boxes for Octorock
		g2d.draw(getBound());// bottom

		
	}


	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}// end of bounds
	

}// end of class