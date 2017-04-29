package implementation;

import service.Command;
import service.EngineService;
import service.PlayerService;

public class EngineImpl implements EngineService{

	private int height;
	private int width;
	private PlayerService player[] = new PlayerService[2];
	private boolean gameOver=false;
	
	private Command commandPlayer1 = Command.NEUTRAL;
	private Command commandPlayer2 = Command.NEUTRAL;
	
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
		
		
		
		p1.init(this, 0);
		p2.init(this, 1);
		
		
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
	public void step() {
		this.player[0].getCharacter().step(this.commandPlayer1);
		this.player[1].getCharacter().step(this.commandPlayer2);
	}

	
	@Override
	public void updateFace() {
		if(this.getPlayer(0).getCharacter().getPositionX()>this.getPlayer(1).getCharacter().getPositionX())
		{
			this.getPlayer(0).getCharacter().setFaceRight(false);
			this.getPlayer(1).getCharacter().setFaceRight(true);
			
		}
		else
		{
			this.getPlayer(0).getCharacter().setFaceRight(true);
			this.getPlayer(1).getCharacter().setFaceRight(false);
		}
		
	}
	@Override
	public Command getCommandPlayer1() {
		return commandPlayer1;
	}
	@Override
	public void setCommandPlayer1(Command commandPlayer1) {
		this.commandPlayer1 = commandPlayer1;
	}
	@Override
	public Command getCommandPlayer2() {
		return commandPlayer2;
	}
	@Override
	public void setCommandPlayer2(Command commandPlayer2) {
		this.commandPlayer2 = commandPlayer2;
	}

}
