package implementationBug;

import service.CharacterService;
import service.Commande;
import service.EngineService;
import service.PlayerService;

public class EngineImpl implements EngineService{

	private int height;
	private int width;
	private PlayerService player[] = new PlayerService[2];
	private CharacterService character[] = new CharacterService[2];
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
	public CharacterService getChar(int i) {
		return this.character[i];
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
		this.player[0] = p1;
		this.player[1] = p2;
		this.character[0] = p1.getCharacter();
		this.character[1]=p2.getCharacter();
		this.character[0].setPositionX(w/2 - s/2);
		this.character[1].setPositionX(w/2 + s/2);
		this.character[0].setPositionY(0);
		this.character[1].setPositionY(0);
		this.character[0].setFaceRight(true);
		this.character[1].setFaceRight(false);
	}

	@Override
	public void step(Commande c1, Commande c2) {
		this.character[0].step(c1);
		this.character[1].step(c2);
		
	}

}
