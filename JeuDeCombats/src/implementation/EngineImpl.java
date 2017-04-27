package implementation;

import service.Commande;
import service.EngineService;
import service.PlayerService;

public class EngineImpl implements EngineService{

	private int height;
	private int width;
	private PlayerService player[] = new PlayerService[2];
	private boolean gameOver=false;
	
	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public PlayerService getPlayer(int i) {
		return this.player[i];
	}

	@Override
	public boolean isGameOver() {
		return this.gameOver;
	}

	@Override
	public void init(int h, int w, int s, PlayerService p1, PlayerService p2) {
		this.height=h;
		this.width=w;
		p1.init(new CharacterImpl(), 1);
		p2.init(new CharacterImpl(), 2);
		
		this.player[0] = p1;
		this.player[1] = p2;
		this.player[0].getCharacter().setPositionX(w/2 - s/2);
		this.player[1].getCharacter().setPositionX(w/2 + s/2);
		this.player[0].getCharacter().setPositionY(0);
		this.player[1].getCharacter().setPositionY(0);
		this.player[0].getCharacter().setFaceRight(true);
		this.player[1].getCharacter().setFaceRight(false);
		
		this.player[0].getCharacter().setRectangleHitboxService(new RectangleHitboxImpl());
		this.player[1].getCharacter().setRectangleHitboxService(new RectangleHitboxImpl());
		
		this.player[0].getCharacter().getCharBox().setPosX(w/2 - s/2);
		this.player[1].getCharacter().getCharBox().setPosX(w/2 + s/2);
		this.player[0].getCharacter().getCharBox().setPosY(0);
		this.player[1].getCharacter().getCharBox().setPosY(0);
	}

	@Override
	public void step(Commande c1, Commande c2) {
		this.player[0].getCharacter().step(c1);
		this.player[1].getCharacter().step(c2);
		
	}

}
