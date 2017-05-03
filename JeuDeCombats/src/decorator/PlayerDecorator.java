package decorator;

import IHM.Animation;
import service.CharacterService;
import service.EngineService;
import service.FightCharService;
import service.PlayerService;

public abstract class PlayerDecorator implements PlayerService{

	private PlayerService delegateService;
	
	public PlayerDecorator(PlayerService ps) {
		this.delegateService=ps;
	}

	@Override
	public int getNumeroPlayer() {
		return this.delegateService.getNumeroPlayer();
	}

	@Override
	public void init(EngineService es, int numero) {
		this.delegateService.init(es, numero);
	}

	@Override
	public Animation getAnimationPlayer() {
		return this.delegateService.getAnimationPlayer();
	}

	@Override
	public void setAnimationPlayer(Animation animationPlayer) {
		this.delegateService.setAnimationPlayer(animationPlayer);
	}

	@Override
	public FightCharService getFightCharacter() {
		return this.delegateService.getFightCharacter();
	}
}
