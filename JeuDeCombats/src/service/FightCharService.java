package service;

public interface FightCharService extends CharacterService {

	
	/** A COMPLETER **/
	
	
	/** Observators */

	public boolean isBlocking();
	public boolean isBlockstunned();
	public boolean isHitstunned();
	public boolean isTeching();
	public RectangleHitboxService getCoupBox();
	
	
	/** Constructor */
	public void init(int l, int s, boolean f, int numeroPlayer);
	
	/** Operators */
	
	// pre: isTeching()
    public TechData getTech();
 
    // pre: isTeching()
    public boolean techFrame();
    
    // pre: isTeching()
    public boolean techHasAlreadyHit();
    
    // pre: not isTeching()
    public void startTech(TechData ts);
    
    /** A MODIF
	 * pre: not isDead()
	 * post: step(KICK) == ()
	 * post: step(PUNCH) == ()
	 * post: step(BLOCK) == 
	 */
    public void step(Command c);
    
    public void kick();
    
    public void block();
    
    public void punch();
    
    public void hit();
}
