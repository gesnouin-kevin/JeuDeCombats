package contract;

import decorator.PlayerDecorator;
import error.PreConditionError;
import service.EngineService;
import service.PlayerService;

public class PlayerContrat extends PlayerDecorator{

	public PlayerContrat(PlayerService ps) {
		super(ps);
	}
	
	public void checkInvariant(){
		
	}

	public void init(EngineService es, int numeroPlayer) {
		
		//pre: numeroPlayer >=0 && numeroPlayer<=1
		if(!(numeroPlayer >=0 && numeroPlayer<=1))
			throw new PreConditionError("Error PreCondition : numeroPlayer >=0 && numeroPlayer<=1");
			
		checkInvariant();
		
		super.init(es, numeroPlayer);
		
		//post getNumeroPlayer = numeroPlayer
		if(!(getNumeroPlayer()==numeroPlayer))
			throw new PreConditionError("Error PostCondition: getNumeroPlayer()==numeroPlayer");
	}
	
	public IHM.Animation getAnimationPlayer() {
		return getAnimationPlayer();
	}

	public void setAnimationPlayer(IHM.Animation animationPlayer) {
		
		checkInvariant();
		
		this.setAnimationPlayer(animationPlayer);
		
		checkInvariant();
		
		//post: getAnimationPlayer()==animationPlayer
		if(!(getAnimationPlayer()==animationPlayer))
			throw new PreConditionError("Error PostCondition: getAnimationPlayer()==animationPlayer");
	}
}
