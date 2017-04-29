package service;

public interface RectangleHitboxService extends HitboxService {


	/** Observator */

	public int getWidth();
	public int getHeight();
	public boolean isCollidesWith(RectangleHitboxService rhs);
	public boolean isEqualsTo(RectangleHitboxService rhs);
	public int getPosX();
	public int getPosY();

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
	
	
	//A RENOMMER
	/**
	 * pre: w > 0
	 * pre: h > 0
	 * post: getWidth() == w
	 * post: getHeight() == h
	 */
	public void init(int w, int h);

	
	/** Operators */
		
	/**
	 * pos: getPosX()==posX
	 */
	public void setPosX(int posX);
		

	/**
	 * pos: getPosY()==posY
	 */
	public void setPosY(int posY);


	/**
	 * pre: height > 0	
	 * pos: getHeight()==height
	 */	
	public void setHeight(int height);

	
	/**
	 * pre: width > 0	
	 * pos: getWidth()==width
	 */	
	public void setWidth(int width);
	

}
