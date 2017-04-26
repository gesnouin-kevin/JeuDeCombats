package decorator;

import service.CharacterService;
import service.PlayerService;

public abstract class PlayerDecorator implements PlayerService{

	private PlayerService delegateService;
	
	public PlayerDecorator(PlayerService ps) {
		this.delegateService=ps;
	}
	
	@Override
	public CharacterService getCharacter() {
		return this.delegateService.getCharacter();
	}

	@Override
	public int getNumeroPlayer() {
		return this.delegateService.getNumeroPlayer();
	}

	@Override
	public void init(CharacterService cs, int numero) {
		this.delegateService.init(cs, numero);
	}
	
	

}
