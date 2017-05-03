package contract;

import decorator.PlayerDecorator;
import error.PreConditionError;
import service.CharacterService;
import service.EngineService;
import service.FightCharService;
import service.PlayerService;

public class PlayerContract extends PlayerDecorator{

	public PlayerContract(PlayerService ps) {
		super(ps);
	}
	
	public void checkInvariant(){
		//getNumeroPlayer == 0 || getNumeroPlayer == 1
		if(!(getNumeroPlayer()==0  || getNumeroPlayer()==1))
			throw new PreConditionError("Check Invariant error : getNumeroPlayer() == 0 || getNumeroPlayer() == 1");
		
	}

	public void init(EngineService es, int numeroPlayer) {
		
		// pre numeroPlayer == 0 || numeroPlayer == 1
		if(!(numeroPlayer==0  ||  numeroPlayer==1))
			throw new PreConditionError("Error PreCondition : pre numeroPlayer == 0 || numeroPlayer == 1");
			
		checkInvariant();
		
		super.init(es, numeroPlayer);
		
		//post getNumeroPlayer = numeroPlayer
		if(!(getNumeroPlayer()==numeroPlayer))
			throw new PreConditionError("Error PostCondition: getNumeroPlayer()==numeroPlayer");
	}
	
	public IHM.Animation getAnimationPlayer() {
		return super.getAnimationPlayer();
	}

	public void setAnimationPlayer(IHM.Animation animationPlayer) {
		
		checkInvariant();
		
		super.setAnimationPlayer(animationPlayer);
		
		checkInvariant();
		
		//post: getAnimationPlayer()==animationPlayer
		if(!(getAnimationPlayer()==animationPlayer))
			throw new PreConditionError("Error PostCondition: getAnimationPlayer()==animationPlayer");
	}

	@Override
	public int getNumeroPlayer() {
		return super.getNumeroPlayer();
	}

	@Override
	public FightCharService getFightCharacter() {
		return super.getFightCharacter();
	}
	
	
}
