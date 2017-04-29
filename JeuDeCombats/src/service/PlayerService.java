package service;

public interface PlayerService {

	public void init(EngineService es, int numeroPlayer); 
	public CharacterService getCharacter();
	public int getNumeroPlayer();
	public IHM.Animation getAnimationPlayer();

	public void setAnimationPlayer(IHM.Animation animationPlayer);
}
