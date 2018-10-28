package pack.framework;

import java.awt.image.BufferedImage;

import pack.window.BufferedImageLoader;

public class Texture {

	SpriteSheet bs, ps, ms;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage monster_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[36];
	public BufferedImage[] player = new BufferedImage[12];
	public BufferedImage[] sword = new BufferedImage[4];
	public BufferedImage[] octorock = new BufferedImage[11];
	
	public Texture() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("/LinkOverWorld.png");
			player_sheet = loader.loadImage("/Link.png");
			monster_sheet = loader.loadImage("/LinkMonsters.png");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		ms = new SpriteSheet(monster_sheet);
		
		getTextures();
		
	}
	
	private void getTextures() {
		//orange pallet
		block[0] = bs.grabImage(35,1,16,16);// ground
		//mountain barriers
		block[1] = bs.grabImage(18,52,16,16);// base mountain 255,255,255
		block[2] = bs.grabImage(18,35,16,16);// mountain top 200,200,200
		block[3] = bs.grabImage(1,35,16,16);// mountain top left 150,150,150
		block[4] = bs.grabImage(35,35,16,16);// mountain top right 100,100,100
		block[5] = bs.grabImage(1,52,16,16);// mountain bottom left 50,50,50
		block[6] = bs.grabImage(35,52,16,16);// mountain top left 25,25,25
		//Miscellaneous
		block[7] = bs.grabImage(18,18,16,16);// tree
		block[8] = bs.grabImage(18,1,16,16);// rock
		block[9] = bs.grabImage(1,18,16,16);// bridge
		block[10] = bs.grabImage(1,1,16,16);// stairs
		block[11] = bs.grabImage(35,18,16,16);// statue
		block[12] = bs.grabImage(69,18,16,16);// door/entrance
		//water
		block[13] = bs.grabImage(18,86,16,16);// water
		block[14] = bs.grabImage(1,86,16,16);// water left edge
		block[15] = bs.grabImage(35,86,16,16);// water right edge
		block[16] = bs.grabImage(18,69,16,16);// water top edge
		block[17] = bs.grabImage(1,69,16,16);// water top left edge
		block[18] = bs.grabImage(35,69,16,16);// water top right edge
		block[19] = bs.grabImage(18,103,16,16);// water bottom edge
		block[20] = bs.grabImage(1,103,16,16);// water bottom left edge
		block[21] = bs.grabImage(35,103,16,16);// water bottom right edge
		//tree dungeon entrance
		block[22] = bs.grabImage(52, 1, 16, 16);// top left portion of tree
		block[23] = bs.grabImage(69, 1, 16, 16);// top middle portion of tree
		block[24] = bs.grabImage(86, 1, 16, 16);// top right portion of tree
		block[25] = bs.grabImage(52, 18, 16, 16);// left portion of tree
		block[26] = bs.grabImage(86, 18, 16, 16);// right portion of tree
		//dried up water
		block[27] = bs.grabImage(18+51,86,16,16);// dry
		block[28] = bs.grabImage(1+51,86,16,16);// dry left edge
		block[29] = bs.grabImage(35+51,86,16,16);// dry right edge
		block[30] = bs.grabImage(18+51,69,16,16);// dry top edge
		block[31] = bs.grabImage(1+51,69,16,16);// dry top left edge
		block[32] = bs.grabImage(35+51,69,16,16);// dry top right edge
		block[33] = bs.grabImage(18+51,103,16,16);// dry bottom edge
		block[34] = bs.grabImage(1+51,103,16,16);// dry bottom left edge
		block[35] = bs.grabImage(35+51,103,16,16);// dry bottom right edge
		
		// player
		player[0] = ps.grabPlayer(159, 1, 16, 16);// idle facing down
		player[1] = ps.grabPlayer(177, 1, 16, 16);// moving down
		player[2] = ps.grabPlayer(213, 1, 16, 16);// moving right
		player[3] = ps.grabPlayer(231, 1, 16, 16);// idle facing right
		player[4] = ps.grabPlayer(123, 1, 16, 16);// idle facing left
		player[5] = ps.grabPlayer(141, 1, 16, 16);// moving left
		player[6] = ps.grabPlayer(105, 1, 16, 16);// idle facing up
		player[7] = ps.grabPlayer(195, 1, 16, 16);// moving up
		
		player[8] = ps.grabPlayer(321, 1, 16, 16);// sword down
		player[9] = ps.grabPlayer(339, 1, 16, 16);// sword up
		player[10] = ps.grabPlayer(357, 1, 16, 16);// sword right
		player[11] = ps.grabPlayer(87, 1, 16, 16);// sword left
		
		//sword
		sword[0] = ps.grabSword(105-18-18-18-18-18,1,16,16);
		sword[1] = ps.grabSword(105-18-18-18-18,1,16,16);
		sword[2] = ps.grabSword(105-18-18-18,1,16,16);
		sword[3] = ps.grabSword(105-18-18,1,16,16);
		
		//octorock
		octorock[0] = ms.grabMonster(10, 8, 14, 16);//left
		octorock[1] = ms.grabMonster(32, 8, 16, 16);
		
		octorock[2] = ms.grabMonster(56, 8, 16, 14);//down
		octorock[3] = ms.grabMonster(80, 8, 16, 16);
		
		octorock[4] = ms.grabMonster(104, 8, 14, 16);//right
		octorock[5] = ms.grabMonster(128, 8, 16, 16);
		
		octorock[6] = ms.grabMonster(152, 10, 16, 14);//up
		octorock[7] = ms.grabMonster(176, 8, 16, 16);
		
		octorock[8] = ms.grabMonster(1532, 32, 16, 16);//death
		octorock[9] = ms.grabMonster(1556, 32, 16, 16);//death
		octorock[10] = ms.grabMonster(1580, 32, 16, 16);//death
	}
}
