package pack.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import pack.framework.GameObject;
import pack.framework.ObjectId;
import pack.framework.Texture;
import pack.window.Game;

public class Door extends GameObject{

	Texture tex = Game.getInstance();
	private int type;
	public Door(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.white);
		//g.drawRect((int)x, (int)y, 32, 32);
		
			g.drawImage(tex.block[type], (int) x, (int) y, 32, 32, null);
		
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, 32, 32);
	}


}// end of class