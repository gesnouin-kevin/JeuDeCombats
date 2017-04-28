package service;

public interface EngineService {

	/** Observators */

	public int getHeight();
	public int getWidth();
	public PlayerService getPlayer(int i);
	public boolean isGameOver();

	/** Invariants */
	//inv:  isGameOver() == \exist i in {1,2} getCharacter::getChar(i).isDead()

	/** Constructor */

	/**
	 * pre: h >= 0 
	 * pre: s >= 0
	 * pre: w >= s
	 * pre:  p1 != p2
	 * post: getHeight() == h
	 * post: getWidth() == w
	 * post: getPlayer(1) == p1
	 * post: getPlayer(2) == p2
	 * post: getCharacter::getPositionX(), getChar(1).getPositionX() == w//2 - s//2
	 * post: getCharacter::getPositionX(), getChar(2).getPositionX() == w//2 + s//2
	 * post: getCharacter::getPositionY(), getChar(1).getPositionY() == 0
	 * post: getCharacter::getPositionY(), getChar(2).getPositionY() == 0
	 * post: getCharacter::isFaceRight(), getChar(1).isFaceRight()
	 * post: getCharacter::isFaceRight(), not getChar(2).isFaceRight()
	 */
	public void init(int h, int w, int s, PlayerService p1, PlayerService p2);
	
	/** Operators */
	
	public void step();
}
