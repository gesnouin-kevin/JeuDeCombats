package service;

public interface HitboxService {

	/** Observators */
	
	public int getPositionX();
	public int getPositionY();
	public boolean isBelongsTo(int x,int y);
	public boolean isCollidesWith(HitboxService hs);
	public boolean isEqualsTo(HitboxService hs);
	
	/** invariants */
	// \inv : isCollidesWith(H1) == \exist x,y { H.isBelongsTo(x,y) and H1.isBelongsTo(x,y) }
	// \inv : isEqualsTo(H1) == \forall x,y { H.isBelongsTo(x,y) == H1.isBelongsTo(x,y) }
	
	/** constructor */
	// \post : getPositionX() == x
	// \post : getPositionY() == y
	public void init(int x, int y);
	
	/** operators */
	// \post : moveTo(x,y).getPositionX() == x
	// \post : moveTo(x,y).getPositionY() == y
	// \post : \forall u,v { moveTo(x,y).isBelongsTo(u,v) == isBelongsTo(u-(x-getPositionX()),v-(y-getPositionY(H)) }
	public void moveTo(int x, int y);
	
	
	/**
	 * pre: posX > 0
	 * post: getPositionX()==posX
	 */
	public void setPosX(int posX);
	
	
	/**
	 * pre: posY > 0
	 * post: getPositionY()==posY
	 */
	public void setPosY(int posY);
}
