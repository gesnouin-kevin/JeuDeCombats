package contract;

import error.InvariantError;
import error.PostConditionError;
import implementation.RectangleHitboxImpl;
import service.RectangleHitboxService;

public class RectangleHitboxContract extends HitboxContract implements RectangleHitboxService {

	public RectangleHitboxContract(RectangleHitboxService rhs) {
		super(rhs);
	}
	
	public void checkInvariant() {
		super.checkInvariant();
		
		// inv: getWidth() > 0
		if (!(getWidth() >= 0))
		    throw new InvariantError("getWidth() >= 0");
		// inv: getWidth() > 0
		if (!(getHeight() >= 0))
		    throw new InvariantError("getHeight() >= 0");
		
		try {
			RectangleHitboxImpl rhb1 = (RectangleHitboxImpl) this.clone();
			RectangleHitboxImpl rhb2 = (RectangleHitboxImpl) this.clone();
			
			// \inv : isCollidesWith(H1) == \exist x,y { H.isBelongsTo(x,y) and H1.isBelongsTo(x,y) }
			if(!(rhb1.isCollidesWith(rhb2) == rhb1.isBelongsTo(getHeight(),getWidth()) && rhb1.isCollidesWith(rhb2) == rhb2.isBelongsTo(getHeight(),getWidth())))
				throw new InvariantError("Error checkInvariant : collidesWith");
			
			// \inv : isEqualsTo(H1) == \forall x,y { H.isBelongsTo(x,y) == H1.isBelongsTo(x,y) }
			if(!(rhb1.isBelongsTo(getHeight(),getWidth())==rhb2.isBelongsTo(getHeight(),getWidth())))
				throw new InvariantError("Error checkInvariant : equalsTo");
			
		} catch (CloneNotSupportedException e) {e.printStackTrace();}	
	}
	
	@Override
	protected RectangleHitboxService getDelegate() {
		return (RectangleHitboxService) super.getDelegate();
	}

	@Override
	public int getWidth() {
		return getDelegate().getWidth();
	}

	@Override
	public int getHeight() {
		return getDelegate().getHeight();
	}

	@Override
	public boolean isCollidesWith(RectangleHitboxService rhs) {
		return getDelegate().isCollidesWith(rhs);
	}

	@Override
	public boolean isEqualsTo(RectangleHitboxService rhs) {
		return getDelegate().isEqualsTo(rhs);
	}

	@Override
	public void init(int x, int y, int w, int h) {
		
		
		checkInvariant();
		
		getDelegate().init(x, y, w, h);
		
		checkInvariant();
		
		if(!(getPositionX()==x))
			throw new PostConditionError("Error PostConditions : getPositionX");
		
		if(!(getPositionY()==y))
			throw new PostConditionError("Error PostConditions : getPositionY");
		

		if (!(getWidth() == w))
		    throw new PostConditionError("Error PostConditions : getWidth()");

		if (!(getHeight() == h))
		    throw new PostConditionError("Error PostConditions : getHeight()");
	}

	

}
