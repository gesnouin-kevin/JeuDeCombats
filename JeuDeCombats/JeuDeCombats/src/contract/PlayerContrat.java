package contract;

import decorator.PlayerDecorator;
import service.CharacterService;
import service.EngineService;
import service.PlayerService;

public class PlayerContrat extends PlayerDecorator{

	public PlayerContrat(PlayerService ps) {
		super(ps);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CharacterService getCharacter() {
		// TODO Auto-generated method stub
		return super.getCharacter();
	}

	@Override
	public int getNumeroPlayer() {
		// TODO Auto-generated method stub
		return super.getNumeroPlayer();
	}

	@Override
	public void init(CharacterService cs) {
		// TODO Auto-generated method stub
		super.init(cs);
	}

	@Override
	public EngineService getEngine() {
		// TODO Auto-generated method stub
		return super.getEngine();
	}
	

}
