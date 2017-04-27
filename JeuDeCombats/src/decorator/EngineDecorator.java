package decorator;

import service.Command;
import service.EngineService;
import service.PlayerService;

public abstract class EngineDecorator implements EngineService {

	private EngineService delegateEnfine;
	
	public EngineDecorator(EngineService es){
		this.delegateEnfine=es;
	}
	
	@Override
	public int getHeight() {
		return this.delegateEnfine.getHeight();
	}

	@Override
	public int getWidth() {
		return this.delegateEnfine.getWidth();
	}

	@Override
	public PlayerService getPlayer(int i) {
		return this.delegateEnfine.getPlayer(i);
	}

	@Override
	public boolean isGameOver() {
		return this.delegateEnfine.isGameOver();
	}

	@Override
	public void init(int h, int w, int s, PlayerService p1, PlayerService p2) {
		this.delegateEnfine.init(h, w, s, p1, p2);
	}

	@Override
	public void step(Command c1, Command c2) {
		this.delegateEnfine.step(c1, c2);
	}

}
