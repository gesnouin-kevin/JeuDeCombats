package service;

public interface PlayerService {

	public CharacterService getCharacter();
	public EngineService getEngine();
	public int getNumeroPlayer();
	
	public void init(CharacterService cs); 
}
