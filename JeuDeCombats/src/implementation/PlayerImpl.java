package implementation;

import service.CharacterService;
import service.EngineService;
import service.PlayerService;

public class PlayerImpl implements PlayerService {
	
	private CharacterService character;
	private int numeroPlayer;

	@Override
	public void init(EngineService es,int numeroPlayer) {
		this.character = new CharacterImpl();
		this.character.init(es);
		this.numeroPlayer = numeroPlayer;
	}

	@Override
	public CharacterService getCharacter() {
		return this.character;
	}

	@Override
	public int getNumeroPlayer() {
		return this.numeroPlayer;
	}


}
