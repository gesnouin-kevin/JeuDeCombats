package contract;

import decorator.PlayerDecorator;
import implementation.CharacterImpl;
import service.PlayerService;

public class PlayerContrat extends PlayerDecorator{

	public PlayerContrat(PlayerService ps) {
		super(ps);
	}

	public void init(CharacterImpl cs, int numeroPlayer) {
		super.init(cs, numeroPlayer);
	}
}
