package implementation;

import service.Command;
import service.EngineService;
import service.PlayerService;
import contract.PlayerContract;
import contract.RectangleHitboxContract;

public class EngineImpl implements EngineService{

	private int height;
	private int width;
	private PlayerContract player[];
	private boolean gameOver;
	private Command commandPlayer1;
	private Command commandPlayer2;

	@Override
	public void init(int h, int w, int s, PlayerService p1, PlayerService p2) {
		this.height=h;
		this.width=w;
		this.gameOver=false;
		this.player = new PlayerContract[2];
		this.commandPlayer1 = Command.NEUTRAL;
		this.commandPlayer2 = Command.NEUTRAL;

		p1.init(this, 0);
		p2.init(this, 1);

		this.player[0] = new PlayerContract(p1);
		this.player[1] = new PlayerContract(p2);
		this.player[0].getFightCharacter().setPositionX(w/2 - s/2);
		this.player[1].getFightCharacter().setPositionX(w/2 + s/2);
		this.player[0].getFightCharacter().setPositionY(0);
		this.player[1].getFightCharacter().setPositionY(0);
		this.player[0].getFightCharacter().setFaceRight(true);
		this.player[1].getFightCharacter().setFaceRight(false);
		
		this.player[0].getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		this.player[1].getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		
		this.player[0].getFightCharacter().getRectangleHitbox().setPosX(w/2 - s/2);
		this.player[1].getFightCharacter().getRectangleHitbox().setPosX(w/2 + s/2);
		this.player[0].getFightCharacter().getRectangleHitbox().setPosY(0);
		this.player[1].getFightCharacter().getRectangleHitbox().setPosY(0);
	
	}

	@Override
	public void step() {
		if(!this.getPlayer(0).getFightCharacter().isDead() && !this.getPlayer(1).getFightCharacter().isDead()){
			this.player[0].getFightCharacter().step(this.commandPlayer1);
			this.commandPlayer1 = Command.NEUTRAL;
			this.player[1].getFightCharacter().step(this.commandPlayer2);
			this.commandPlayer2 = Command.NEUTRAL;
		}
		else{
			this.gameOver = true;
			this.commandPlayer1 = Command.NEUTRAL;
			this.commandPlayer2 = Command.NEUTRAL;
		}
	}


	@Override
	public void updateFace() {
		if(this.getPlayer(0).getFightCharacter().getPositionX()>this.getPlayer(1).getFightCharacter().getPositionX()){
			this.getPlayer(0).getFightCharacter().setFaceRight(false);
			this.getPlayer(1).getFightCharacter().setFaceRight(true);
		}
		else{
			this.getPlayer(0).getFightCharacter().setFaceRight(true);
			this.getPlayer(1).getFightCharacter().setFaceRight(false);
		}
	}
	
	@Override
	public int getHeight() { return this.height; }
	@Override
	public int getWidth() { return this.width;}
	@Override
	public PlayerContract getPlayer(int i) { return this.player[i]; }
	@Override
	public boolean isGameOver() { return this.gameOver;}
	@Override
	public Command getCommandPlayer1() { return commandPlayer1; }
	@Override
	public void setCommandPlayer1(Command commandPlayer1) { this.commandPlayer1 = commandPlayer1; }
	@Override
	public Command getCommandPlayer2() { return commandPlayer2; }
	@Override
	public void setCommandPlayer2(Command commandPlayer2) { this.commandPlayer2 = commandPlayer2; }
	

}
