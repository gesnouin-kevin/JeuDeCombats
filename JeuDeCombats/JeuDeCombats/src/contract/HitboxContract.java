package contract;

import decorator.HitboxDecorator;
import error.InvariantError;
import error.PostConditionError;
import service.HitboxService;

public class HitboxContract extends HitboxDecorator{

	private HitboxDecorator hs1,hs2;

	public HitboxContract(HitboxService hs) {
		super(hs);
	}


	/**
	 * A DEMANDER/MODIF POUR LES LIMITES de i et j
	 * 
	 **/

	public void checkInvariant(){

		// \inv : isCollidesWith(H1) == \exist x,y { H.isBelongsTo(x,y) and H1.isBelongsTo(x,y) }
		int compt=0;
		for(int i=0; i<1000;i++)
			for(int j=0;j<1000;j++)
				if(hs1.isCollidesWith(hs2) == hs1.isBelongsTo(i,j) && hs1.isCollidesWith(hs2) == hs2.isBelongsTo(i,j))
					compt++;
		if(compt>0)
			throw new InvariantError("Error checkInvariant : collidesWith");

		// \inv : isEqualsTo(H1) == \forall x,y { H.isBelongsTo(x,y) == H1.isBelongsTo(x,y) }
		for(int i=0; i<1000;i++)
			for(int j=0;j<1000;j++)
				if(!(hs1.isBelongsTo(i, j)==hs2.isBelongsTo(i, j)))
					throw new InvariantError("Error checkInvariant : equalsTo");
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
		// TODO Auto-generated method stub
		return super.getPositionX();
	}


	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return super.getPositionY();
	}


	@Override
	public boolean isBelongsTo(int x, int y) {
		// TODO Auto-generated method stub
		return super.isBelongsTo(x, y);
	}


	@Override
	public boolean isEqualsTo(HitboxService hs) {
		// TODO Auto-generated method stub
		return super.isEqualsTo(hs);
	}


	@Override
	public boolean isCollidesWith(HitboxService hs) {
		// TODO Auto-generated method stub
		return super.isCollidesWith(hs);
	}
	
	
}
