package service;

public interface PlayerService {

	/** Observators */

	public CharacterService getCharacter();
	public int getNumeroPlayer();
	public IHM.Animation getAnimationPlayer();
	public FightCharService getFightCharacter();

	/** Invariants */


	/** Constructor */

	/**
	 *pre numeroPlayer >=0 && numeroPlayer<=1
	 *post getNumeroPlayer = numeroPlayer
	 *post get EngineService = es ?
	 */
	public void init(EngineService es, int numeroPlayer); 


	/** Operators */

	/**
	 * post: getAnimationPlayer()==animationPlayer
	 */
	public void setAnimationPlayer(IHM.Animation animationPlayer);
	
}
