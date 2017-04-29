package decorator;

import service.Command;
import service.EngineService;
import service.PlayerService;

public abstract class EngineDecorator implements EngineService {

	private EngineService delegateEngine;
	
	public EngineDecorator(EngineService es){
		this.delegateEngine=es;
	}
	
	@Override
	public int getHeight() {
		return this.delegateEngine.getHeight();
	}

	@Override
	public int getWidth() {
		return this.delegateEngine.getWidth();
	}

	@Override
	public PlayerService getPlayer(int i) {
		return this.delegateEngine.getPlayer(i);
	}

	@Override
	public boolean isGameOver() {
		return this.delegateEngine.isGameOver();
	}

	@Override
	public void init(int h, int w, int s, PlayerService p1, PlayerService p2) {
		this.delegateEngine.init(h, w, s, p1, p2);
	}

	@Override
	public void step() {
		this.delegateEngine.step();
	}

	@Override
	public void updateFace() {
		this.delegateEngine.updateFace();
	}

	@Override
	public void setCommandPlayer1(Command commandPlayer1) {
		this.delegateEngine.setCommandPlayer1(commandPlayer1);		
	}

	@Override
	public void setCommandPlayer2(Command commandPlayer2) {
		this.delegateEngine.setCommandPlayer2(commandPlayer2);		
	}

	@Override
	public Command getCommandPlayer1() {
		return this.delegateEngine.getCommandPlayer1();
	}

	@Override
	public Command getCommandPlayer2() {
		return this.delegateEngine.getCommandPlayer2();
	}
	
	

	
}
