package implementation;

import service.CharacterService;
import service.EngineService;
import service.FightCharService;
import service.PlayerService;

public class PlayerImpl implements PlayerService {
	
	private CharacterService character;
	private int numeroPlayer; // 0 ou 1
	private FightCharService fightcharacter;
	
	private IHM.Animation animationPlayer;

	@Override
	public void init(EngineService es,int numeroPlayer) {
		this.fightcharacter = new FightCharImpl();
		this.fightcharacter.init(es);
		//this.character = new CharacterImpl();
		//this.character.init(es);
		this.numeroPlayer = numeroPlayer;
	}

	@Override
	public FightCharService getFightCharacter() {
		return this.fightcharacter;
	}
	
	public FightCharService getCharacter() {
		return this.fightcharacter;
	}

	@Override
	public int getNumeroPlayer() {
		return this.numeroPlayer;
	}

	public IHM.Animation getAnimationPlayer() {
		return animationPlayer;
	}

	public void setAnimationPlayer(IHM.Animation animationPlayer) {
		this.animationPlayer = animationPlayer;
	}


}
