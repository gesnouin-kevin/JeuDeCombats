package contract;

import implementation.HitboxImpl;
import decorator.HitboxDecorator;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;
import service.HitboxService;

public class HitboxContract extends HitboxDecorator{

	public HitboxContract(HitboxService hs) {
		super(hs);
	}

	public void checkInvariant(){

	}


	public void moveTo(int x, int y){
		checkInvariant();

		boolean belongsTo_centre_at_pre = isBelongsTo(getPositionX(), getPositionY());

		boolean belongsTo_centre_100_at_pre = isBelongsTo(getPositionX() + 100, getPositionY() + 100);

		int getPositionX_at_pre = getPositionX();
		int getPositionY_at_pre = getPositionY();
		boolean belongsTo_abs_at_pre = isBelongsTo(300, 0);

		super.moveTo(x,y);

		checkInvariant();

		if(! isBelongsTo(getPositionX(), getPositionY()) == belongsTo_centre_at_pre)
		{throw new PostConditionError("Error PostCondition : belongsTo != belongsTo_centre_at_pre");}

		if(! isBelongsTo(getPositionX() + 100, getPositionY() + 100) == belongsTo_centre_100_at_pre)
		{throw new PostConditionError("Error PostCondition : belongsTo != belongsTo_centre_100_at_pre");}

		if(! isBelongsTo(300 + (x - getPositionX_at_pre), 0 + (y - getPositionY_at_pre)) == belongsTo_abs_at_pre)
		{throw new PostConditionError("belongsTo != belongsTo_abs_at_pre");}
	}

	public void init(int x, int y){
		checkInvariant();

		super.init(x, y);

		checkInvariant();

		if(!(getPositionX()==x))
			throw new PostConditionError("Error PostConditions : getPositionX");

		if(!(getPositionY()==y))
			throw new PostConditionError("Error PostConditions : getPositionY");
	}


	@Override
	public int getPositionX() {
		return super.getPositionX();
	}


	@Override
	public int getPositionY() {
		return super.getPositionY();
	}


	@Override
	public boolean isBelongsTo(int x, int y) {
		return super.isBelongsTo(x, y);
	}


	@Override
	public boolean isEqualsTo(HitboxService hs) {
		return super.isEqualsTo(hs);
	}


	@Override
	public boolean isCollidesWith(HitboxService hs) {
		return super.isCollidesWith(hs);
	}

	public void setPosX(int posX) {

		//pre: posX > 0
		if(!(posX>0))
			throw new PreConditionError("Error PreCondition: posX>=0");

		checkInvariant();
		super.setPosX(posX);

		checkInvariant();

		//post: getPositionX()==posX
		if(!(getPositionX()==posX))
			throw new PostConditionError("Error PostCondition: getPositionX()==posX");
	}

	public void setPosY(int posY) {
		
		//pre: posY > 0
		if(!(posY>0))
			throw new PreConditionError("Error PreCondition: posY>0");

		checkInvariant();

		super.setPosY(posY);

		checkInvariant();

		//post: getPositionX()==posX
		if(!(getPositionY()==posY))
			throw new PostConditionError("Error PostCondition: getPositionX()==posY");

	}


}