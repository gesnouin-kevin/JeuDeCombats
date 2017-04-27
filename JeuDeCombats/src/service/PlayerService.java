package service;

public interface PlayerService {

	public void init(EngineService es, int numeroPlayer); 
	public CharacterService getCharacter();
	public int getNumeroPlayer();
}
