package service;

public interface PlayerService {

	public void init(CharacterService cs, int numeroPlayer); 
	public CharacterService getCharacter();
	public int getNumeroPlayer();
}
