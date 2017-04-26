package implementation;

import service.CharacterService;
import service.PlayerService;

public class PlayerImpl implements PlayerService {
	
	private CharacterService character;
	private int numeroPlayer;

	@Override
	public void init(CharacterService cs, int numeroPlayer) {
		this.character = cs;
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
