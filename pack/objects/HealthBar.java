package pack.objects;

import pack.framework.ObjectId;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.framework.GameObject;

public class HealthBar extends GameObject{

	private float width = 100, height = 10;
	private int life = 0;
	boolean active = false;
	

	
	public HealthBar(float x, float y, ObjectId id, int life) {
		super(x, y, id);
		this.life = life;
		
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(active) {
			g.setColor(Color.red);
			g.fillRect((int)x, (int)y, (int)width, (int)height);
			g.setColor(Color.blue);
			g.fillRect((int)x, (int)y, (int)width, (int)height);
		}
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int x) {
		life = x;
	}
	
	public void setActive(boolean x) {
		active = x;
	}
	
}
