package service;

public interface CharacterService {

	/** Observators */

	public int getPositionX();
	public int getPositionY();
	public EngineService getEngine();
	public RectangleHitboxService getRectangleHitbox();
	public int getLife();
	public int getSpeed();
	public boolean isFaceRight();
	public boolean isDead();
	public boolean isRunning();
	public boolean isCrouching();
	public boolean isJumping();
	public int getNumeroPlayer() ;
	public int getNumeroCharacter();



	/** Invariant */
	//inv: getPositionX() > 0 and getPositionX() < Engine::getWidth()
	//inv: getPositionY() > 0 and getPositionY() < Engine::getHeight()
	//inv: isDead() = not (getLife() > 0)


	/** Constructor */
	/**
	 * pre: l>0
	 * pre: s>0
	 * post: getLife() = l 
	 * post: getSpeed() = s 
	 * post: isFaceRight() = f
	 */
	public void init(int l, int s, boolean f, int numeroPlayer);

	/**
	 * post: getEngine() = e
	 * */
	public void init(EngineService es);


	/** Operators */

	/**
	 * post: \exist i { getEngine().getChar(i)!= this and getCharBox().getCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
	 * 					=> getPositionX() == getPositionX()@Pre }
	 * 
	 * post: getPositionX()<=getSpeed() and
	 * 		\forall i { getEngine().getChar(i)!=this => not getCharBox().getCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
	 * 					=> getPositionX() == getPositionX()@Pre - getSpeed() }
	 * 
	 * post: getPositionX()>getSpeed() and
	 * 		\forall i { getEngine().getChar(i)!=this => not getCharBox().getCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
	 * 					=> getPositionX() == 0 }
	 * 
	 * post: getFaceRight() = faceRight()@Pre and getLife() = getLife()@Pre
	 * 
	 * post: getPositionY() == getPositionY()@Pre
	 */
	public void moveLeft();


	/**
	 * post: \exist i { getEngine().getChar(i)!= this and getCharBox().getCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
	 * 					=> getPosition() == getPositionX()@Pre }
	 * 
	 * post: getPositionX()<=getSpeed() and
	 * 		\forall i { getEngine().getChar(i)!=this => not getCharBox().getCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
	 * 					=> getPositionX() == getPositionX()@Pre - getSpeed() }
	 * 
	 * post: getPositionX()>getSpeed() and
	 * 		\forall i { getEngine().getChar(i)!=this => not getCharBox().getCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
	 * 					=> getPositionX() == 0 }
	 * 
	 * post: getFaceRight() = faceRight()@Pre and getLife() = getLife()@Pre
	 * 
	 * post: getPositionY() == getPositionY()@Pre
	 */
	public void moveRight();


	/**
	 * post: getFaceRight() != getFaceRight()@Pre
	 * post: getPositionX() == getPositionX()@Pre
	 * */
	public void switchSide();

	/**
	 * pre: not isDead()
	 * post: step(LEFT_PRESSED) == moveLeft()
	 * post: step(RIGHT_PRESSED) == moveRight()
	 * post: step(NEUTRAL) == this
	 */
	public void step(Command c);


	/**
	 * pre: x >= 0
	 * post: getPositionX() == x
	 */
	public void setPositionX(int i);


	/**
	 * pre: y >= 0
	 * post: getPositionY() == y
	 */
	public void setPositionY(int i);


	/**
	 * post: isFaceRight() == fr
	 */
	public void setFaceRight(boolean fr);


	/**
	 * pre: numeroPlayer>=0 && numeroPlayer<=1
	 * post: getNumeroPlayer == numeroPlayer
	 */
	public void setNumeroPlayer(int numeroPlayer);

	/**
	 * pre: numeroCharacter>=0 && numeroCharacter<=15
	 * post: getNumeroCharacter == numeroCharacter
	 */
	public void setNumeroCharacter(int numeroCharacter);


	/**
	 * post: getFaceRight() = faceRight()@Pre and getLife() = getLife()@Pre
	 * post: getPositionY() == getPositionY()@Pre	
	 */
	public void moveDown();


	/**
	 * post: getFaceRight() = faceRight()@Pre and getLife() = getLife()@Pre
	 * post: getPositionY() == getPositionY()@Pre	
	 */
	public void moveUp();

	/**
	 * post: getRectangleHitbox().getHeight == InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter())
	 * post: getRectangleHitbox().getWidth == InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter)
	 * */
	public void neutral();


	public void updateY();

	/**
	 * post: getLife()==l
	 * */
	public void setLife(int l);

	public void setRectangleHitboxService(RectangleHitboxService rectangleHitbox);

	/**
	 * post: isDead = d
	 * */
	public void setDead(boolean d);

	/**
	 * post: getRectangleHitbox().getHeight == InformationsCharacter.getHeightSpritePersoCrouch(getNumeroCharacter())
	 * post: getRectangleHitbox().getWidth == InformationsCharacter.getWidthSpritePersoCrouch(getNumeroCharacter)
	 * */
	public void crouch();
}
