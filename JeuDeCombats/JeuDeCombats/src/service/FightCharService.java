package service;

public interface FightCharService extends CharacterService {

	
	/** A COMPLETER **/
	
	
	/** Observators */

	public boolean isBlocking();
	public boolean isBlockstunned();
	public boolean isHitstunned();
	public boolean isTeching();
	
	/** Operators */
	
	// pre: isTeching()
    public TechData getTech();
 
    // pre: isTeching()
    public boolean techFrame();
    
    // pre: isTeching()
    public boolean techHasAlreadyHit();
    
    // pre: not isTeching()
    public void startTech(TechData ts);
    
}
