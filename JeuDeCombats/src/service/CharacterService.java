package service;

public interface CharacterService {

	/** Observators */
	
	public int getPositionX();
	public int getPositionY();
	public EngineService getEngine();
	public RectangleHitboxService getCharBox();
	public int getLife();
	public int getSpeed();
	public boolean isFaceRight();
	public boolean isDead();
	public boolean isRunning();
	public boolean isCrouching();
	public boolean isJumping();
	
	
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
	  * post: getEngine() = e
	  * post: \exist h :HitboxService { getCharbox() = h }
	  */
	public void init(int l, int s, boolean f, int numeroPlayer);
	
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
	
	/** AJOUTER LES NOUVEAUX MOVE AUX PRE DE STEP */
	/**
	 * pre: not isDead()
	 * post: step(LEFT) == moveLeft()
	 * post: step(RIGHT) == moveRight()
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
	
	
	public int getNumeroPlayer() ;

	public void setNumeroPlayer(int numeroPlayer);
	
	public void setRectangleHitboxService(RectangleHitboxService rectangleHitbox);
	
	public RectangleHitboxService getRectangleHitboxService();
	
	public int getNumeroCharacter();

	public void setNumeroCharacter(int numeroCharacter);
	
	public void moveDown();
	
	public void moveUp();
	
	public void neutral();
}
