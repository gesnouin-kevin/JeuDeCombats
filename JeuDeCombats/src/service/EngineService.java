package service;

public interface EngineService {

	/** Observators */

	public boolean isGameOver();
	public int getHeight();
	public int getWidth();
	public PlayerService getPlayer(int i);
	public Command getCommandPlayer1();
	public Command getCommandPlayer2();

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
	 * post: getFightCharacter::getPositionX(), getChar(0).getPositionX() == w//2 - s//2
	 * post: getFightCharacter::getPositionX(), getChar(1).getPositionX() == w//2 + s//2
	 * post: getFightCharacter::getPositionY(), getChar(0).getPositionY() == 0
	 * post: getFightCharacter::getPositionY(), getChar(1).getPositionY() == 0
	 * post: getFightCharacter::isFaceRight(), getChar(0).isFaceRight()
	 * post: getFightCharacter::isFaceRight(), not getChar(1).isFaceRight()
	 */
	public void init(int h, int w, int s, PlayerService p1, PlayerService p2);
	
	/** Operators */
	
	/**
	 * post: getCommandPlayer1 = Command.NEUTRAL
	 * post: getCommandPlayer2 = Command.NEUTRAL 
	 */
	public void step();
	
	
	/**
	 * post: getPlayer(Math.max(getPlayer(0).getPosX(), getPlayer(1).getPosX()).getNumeroPlayer()).isFaceRight() == false
	 * post: getPlayer(Math.min(getPlayer(0).getPosX(), getPlayer(1).getPosX()).getNumeroPlayer()).isFaceRight() == true
	 */
	public void updateFace();
	
	/**
	 * pre: commandplayer1 in Command
	 * post: getCommandPlayer1() == commandPlayer1
	 */
	public void setCommandPlayer1(Command commandPlayer1);

	/**
	 * pre: commandplayer2 in Command
	 * post: getCommandPlayer2() == commandPlayer2
	 */
	public void setCommandPlayer2(Command commandPlayer2);
}
