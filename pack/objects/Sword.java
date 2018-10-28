package pack.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.framework.GameObject;
import pack.framework.ObjectId;
import pack.framework.Texture;
import pack.window.Game;

public class Sword extends GameObject{
	
	Texture tex = Game.getInstance();
	
	public Sword(float x, float y, ObjectId id, int facing) {// bullets going up
		super(x, y, id);
			this.facing = facing;
			
	}

	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub

	}

	
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.red);
		if(facing == 4 || facing == 44) {// left
			g.drawImage(tex.sword[0], (int)x-24, (int)y+1, 32, 32, null);
		}
		if(facing == 6 || facing == 66) {// right
			g.drawImage(tex.sword[1], (int)x+24, (int)y+1, 32, 32, null);
		}
		if(facing == 88 || facing == 8) {// up
			g.drawImage(tex.sword[2], (int)x-5, (int)y-25, 32, 32, null);
		}
		if(facing == 22 || facing == 2) {// down
			g.drawImage(tex.sword[3], (int)x+2, (int)y+25, 32, 32, null);
		}
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		//hit boxes for sword
		g2d.draw(getBound());// bottom
	}


	public Rectangle getBound() {
		// TODO Auto-generated method stub
		if(facing == 4 || facing == 44) {// left
			return new Rectangle((int)x-24, (int)y+10, 32, 15);
		}
		if(facing == 6 || facing == 66) {// right
			return new Rectangle((int)x+24, (int)y+10, 32, 15);
		}
		if(facing == 88 || facing == 8) {// up
			return new Rectangle((int)x+4, (int)y-25, 15, 32);
		}
		if(facing == 22 || facing == 2) {// down
			return new Rectangle((int)x+11, (int)y+25, 15, 32);
		}
		return null;
		
	}// end of get bound
	

}// end of class