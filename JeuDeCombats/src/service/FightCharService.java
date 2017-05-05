package service;

public interface FightCharService extends CharacterService {
	
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
	 */
	public void init(int l, int s, boolean f, int numeroPlayer);
	
	/** Operators **/
	/**
	 * pre: not isDead()
	 * post: step(KICK) == kick()
	 * post: step(PUNCH) == punch()
	 * post: step(BLOCK_PRESSED) == block()
	 * 
	 */
    public void step(Command c);
    
    
    /**
     * post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()))
     * post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()))
     * 
     * post: getCoupBox().getHeight()==getCoupBox@Pre.setHeight(InformationsCharacter.getHeightSpritePersoFoot(getNumeroCharacter())) 
     * post: getCoupBox().getWidth()==getCoupBox@Pre.setWidth(InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()))
     * post: getCoupBox().getPosY()==getCoupBox@Pre.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getHeightSpritePersoFoot(this.getNumeroCharacter()))
     * 
     * post: isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()
     * +InformationsCharacter.getWidthSpritePersoKick(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()))
     * post: not isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()
     * +InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()))
     * 
     * post: \exist i in {0,1}  
     * 			getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCharBox()) ||
				getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCoupBox())
				=>
					!getEngine().getPlayer(i).getFightCharacter().isBlocking())
						=> getEngine().getPlayer(i).getFightCharacter().getDurationStunned()==3
				
				
     */
    public void kick();
    
    
    /**
     * post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()))
     * post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()))
     * 
     * post: getCoupBox().getHeight()==getCoupBox@Pre.setHeight(InformationsCharacter.getHeightSpritePersoArm(getNumeroCharacter())) 
     * post: getCoupBox().getWidth()==getCoupBox@Pre.setWidth(InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()))
     * post: getCoupBox().getPosY()==getCoupBox@Pre.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getHeightSpritePersoArm(this.getNumeroCharacter()))
     * 
     * post: isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoPunch(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(getNumeroCharacter()))
     * post: not isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(getNumeroCharacter()))
     * 
     * post: \exist i in {0,1}  
     * 			getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCharBox()) ||
				getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCoupBox())
				=>
					!getEngine().getPlayer(i).getFightCharacter().isBlocking())
						=> getEngine().getPlayer(i).getFightCharacter().getDurationStunned()==2
				
				
     */
    public void punch();
    
    /**
     * post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoBlocking(getNumeroCharacter()))
     * post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoBlocking(getNumeroCharacter()))
     */
    public void block();
    
    
    /**
     * //post: (getLife()==getLife_atPre-InformationsCharacter.getDamage(getOtherPlayer().getFightCharacter().getNumeroCharacter()))
     */
    public void hit();
    
    /**
     * post:\exist i && j in {0,1},j!=i, getEngine().getPlayer(i).getFightCharacter().getLife()<=0 
     * 							=> getEngine().getPlayer(i).getFightCharacter().isDead()
     * 
     */
    public void dead();
    
    /**
     * post: getTechFrame()<2 => getTechFrame()==getTechFrame()@Pre++
     * post: getTechFrame()>=2 => getTechFrame()==0 && isTeching()==true
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
