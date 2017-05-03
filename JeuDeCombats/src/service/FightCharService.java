package service;

public interface FightCharService extends CharacterService {

	/** A COMPLETER **/
	
	
	/** Observators */

	public boolean isBlocking();
	public boolean isHitstunned();
	public boolean isTeching();
	public RectangleHitboxService getCoupBox();
	public int getDurationStunned();
	public int getFrameTech();
	
	/** Constructor */
	
	/**
	 * pre: l>0
	 * pre: s>0
	 * post: getLife()==l
	 * post: getSpeed()=s
	 * post: isFaceRight() = f
	 * post: getNumeroPlayer()==numeroPlayer
	 * post: \exist h :RectangleHitboxService { getCoupBox() = h }
	 */
	public void init(int l, int s, boolean f, int numeroPlayer);
	
	/** Operators */
    
    /** A MODIF
	 * pre: not isDead()
	 * post: step(KICK) == kick()
	 * post: step(PUNCH) == punch()
	 * post: step(BLOCK_PRESSED) == block()
	 * post: step(BLOCK_RELEASED) == 
	 */
    public void step(Command c);
    
    
    /**
     * post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()))
     * post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()))
     * 
     * post: getCoupBox()==getCoupBox@Pre.setHeight(InformationsCharacter.getHeightSpritePersoFoot(getNumeroCharacter())) 
     * post: getCoupBox()==getCoupBox@Pre.setWidth(InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()))
     * post: getCoupBox()==getCoupBox@Pre.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoFoot(this.getNumeroCharacter()))
     * 
     * post: isFaceRight() => getCoupBox()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoKick(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()))
     * post: not isFaceRight() => getCoupBox()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()))
     * 
     * post: 
     */
    public void kick();
    
    public void punch();
    
    /**
     * post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoBlocking(getNumeroCharacter()))
     * post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoBlocking(getNumeroCharacter()))
     */
    public void block();
    
    
    /**
     * post: \exist i in {0,1} getLife()==getLife()@Pre-InformationsCharacter.getDamage(getEngine().getPlayer(i).getFightCharacter().getNumeroCharacter())
     */
    public void hit();
    
    /**
     * post:\exist i && j in {0,1},j!=i, getEngine().getPlayer(i).getFightCharacter().getLife()<=0 
     * 							=> getEngine().getPlayer(i).getFightCharacter().getDead()==true && getEngine().getPlayer(i).getAnimationPlayer().getCurrentAnimation(10)
     * 							&& this.getEngine().getPlayer(j).getAnimationPlayer().setCurrentAnimation(9);
     * 
     */
    public void dead();
    
    /**
     * post: getTechFrame()<2 => getTechFrame()==getTechFrame()@Pre++
     * post: getTechFrame()>=2 => getTechFrame()==0 && getTeching()==true
     * 
     */
    public void nextFrameTech();
    
    /**
     * pre: bs>0
     * post: getDurationStunned()==bs
     */
    public void setDurationStunned(int bs);
    
    /**
     * post: getCoupBox()==rectangleHitbox
     */
    public void setCoupBox(RectangleHitboxService rectangleHitbox);
    
    
    /**
     * post: getDurationStunned()>0 => getDurationStunned()==getDurationStunned()@Pre -1
     */
    public void updateDurationStunned();
}
