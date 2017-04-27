package contract;

import decorator.PlayerDecorator;
import implementation.CharacterImpl;
import service.EngineService;
import service.PlayerService;

public class PlayerContrat extends PlayerDecorator{

	public PlayerContrat(PlayerService ps) {
		super(ps);
	}

	public void init(EngineService es, int numeroPlayer) {
		super.init(es, numeroPlayer);
	}
}
