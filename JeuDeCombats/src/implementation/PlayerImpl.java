package implementation;

import contract.FightCharContract;
import service.EngineService;
import service.FightCharService;
import service.PlayerService;

public class PlayerImpl implements PlayerService {
	
	private int numeroPlayer;
	private FightCharContract fightcharacter;
	private IHM.Animation animationPlayer;

	@Override
	public void init(EngineService es,int numeroPlayer) {
		this.fightcharacter = new FightCharContract(new FightCharImpl());
		this.fightcharacter.init(es);
		this.numeroPlayer = numeroPlayer;
	}

	@Override
	public FightCharService getFightCharacter() {
		return this.fightcharacter;
	}

	@Override
	public int getNumeroPlayer() {
		return this.numeroPlayer;
	}

	@Override
	public IHM.Animation getAnimationPlayer() {
		return animationPlayer;
	}

	@Override
	public void setAnimationPlayer(IHM.Animation animationPlayer) {
		this.animationPlayer = animationPlayer;
	}

}
