package service;

public interface RectangleHitboxService extends HitboxService {


	/** Observator */

	public int getWidth();
	public int getHeight();
	public boolean isCollidesWith(RectangleHitboxService rhs);
	public boolean isEqualsTo(RectangleHitboxService rhs);

	/** invariants */
	// \inv : isCollidesWith(H1) == \exist x,y { H.isBelongsTo(x,y) and H1.isBelongsTo(x,y) }
	// \inv : isEqualsTo(H1) == \forall x,y { H.isBelongsTo(x,y) == H1.isBelongsTo(x,y) }
	

	/** Constructors*/

	/**
	 * pre: w > 0
	 * pre: h > 0
	 * post: getPositionX() == x
	 * post: getPositionY() == y
	 * post: getWidth() == w
	 * post: getHeight() == h
	 */
	public void init(int x, int y, int w, int h);
	
	public void init(int w, int h);

	/** Operators */
	/**
	* post: getPositionX() == x
	* post: getPositionY() == y
	* post: \forall u, v: int x int { belongsTo(u, v) == belongsTo(u-(x-getPositionX()@pre), v-(y-getPositionY()@pre)) }
	*/
	
	public int getPosX();
	
	public void setPosX(int posX);
	
	public int getPosY();
	
	public void setPosY(int posY);
	

}
