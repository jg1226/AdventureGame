package pack.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import pack.framework.ObjectId;

import pack.objects.Bullet;
import pack.objects.Sword;
import pack.window.Handler;

public class KeyInput extends KeyAdapter{
	Handler handler;
	int count = 0;
	int speed = 3;
	Sword sword = new Sword(0, 0, ObjectId.Sword, 0);
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ObjectId.Player) {
				if(tempObject.getSword() == false) {
					if(key == KeyEvent.VK_D) {
						tempObject.setVelX(speed);
						tempObject.setVelY(0);
						tempObject.setFacing(66);
					}
					if(key == KeyEvent.VK_A) {
						tempObject.setVelX(-1*speed);
						tempObject.setVelY(0);
						tempObject.setFacing(44);
					}
					if(key == KeyEvent.VK_W) {
						tempObject.setVelY(-1*speed);
						tempObject.setVelX(0);
						tempObject.setFacing(88);
					}
					if(key == KeyEvent.VK_S) {
						tempObject.setVelY(speed);
						tempObject.setVelX(0);
						tempObject.setFacing(22);
					}
					if(key == KeyEvent.VK_SPACE) {
						sword.setX(tempObject.getX());
						sword.setY(tempObject.getY());
						sword.setFacing(tempObject.getFacing());
						tempObject.setSword(true);
						if(count == 0) {
						handler.addObject(sword);
						count++;
						}
						
					}
					
					
				}
			}
		}// end of for loop
		
		if(key==KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ObjectId.Player) {
				if(tempObject.getSword() == false) {
					if(key == KeyEvent.VK_D) {
						tempObject.setVelX(0);
						tempObject.setFacing(6);
					}
					if(key == KeyEvent.VK_A) {
						tempObject.setVelX(0);
						tempObject.setFacing(4);
					}
					if(key == KeyEvent.VK_W) {
						tempObject.setVelY(0);
						tempObject.setFacing(8);
					}
					if(key == KeyEvent.VK_S) {
						tempObject.setVelY(0);
						tempObject.setFacing(2);
					}
				}
				if(key == KeyEvent.VK_SPACE) {
					tempObject.setSword(false);
					sword.setX(-5000);
					sword.setY(-5000);
				}
			}
				
		}

	}// end of key released

}
