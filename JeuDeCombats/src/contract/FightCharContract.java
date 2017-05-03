package contract;

import error.PostConditionError;
import error.PreConditionError;
import service.CharacterService;
import service.Command;
import service.FightCharService;
import service.RectangleHitboxService;

public class FightCharContract extends CharacterContract implements FightCharService{

	public FightCharContract(CharacterService cs) {
		super(cs);
	}
	
	@Override
	protected FightCharService getDelegate() {
		return (FightCharService) super.getDelegate();
	}

	public void checkInvariant(){
		super.checkInvariant();
	}
	
	@Override
	public boolean isBlocking() {
		return getDelegate().isBlocking();
	}

	@Override
	public boolean isHitstunned() {
		return getDelegate().isHitstunned();
	}

	@Override
	public boolean isTeching() {
		return getDelegate().isTeching();
	}

	@Override
	public void step(Command c) {
		getDelegate().step(c);
	}

	@Override
	public void kick() {
		getDelegate().kick();
	}

	@Override
	public void block() {
		getDelegate().block();
	}

	@Override
	public void punch() {
		getDelegate().punch();
	}

	@Override
	public void hit() {
		getDelegate().hit();
	}

	@Override
	public RectangleHitboxService getCoupBox() {
		return getDelegate().getCoupBox();
	}

	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {
		getDelegate().init(l, s, f, numeroPlayer);		
	}

	@Override
	public void dead() {
		getDelegate().dead();
	}

	@Override
	public void nextFrameTech() {
		
		int getTechFrame_atPre = getFrameTech();
		
		checkInvariant();
		
		getDelegate().nextFrameTech();
		
		checkInvariant();
		
		//post: getFrameTech()<2 => getFrameTech()==getFrameTech()@Pre++
		if(getFrameTech()<2)
			if(getFrameTech()==getTechFrame_atPre++)
				throw new PostConditionError("");
		//post: getFrameTech()>=2 => getFrameTech()==0 && getTeching()==true
	}

	@Override
	public void setDurationStunned(int bs) {
		
		//pre: bs>0
		if(!(bs>0))
			throw new PreConditionError("Error PreCondition: bs>0");
		
		checkInvariant();
		
		getDelegate().setDurationStunned(bs);
		
		checkInvariant();
		
		//post: getDurationStunned()==bs
		if(!(getDurationStunned()==bs))
			throw new PreConditionError("Error PostCondition: getDurationStunned()==bs");
	}

	@Override
	public void updateDurationStunned() {
		
		int getDurationStunned_atPre=getDurationStunned();
		
		checkInvariant();
		
		getDelegate().updateDurationStunned();		
	
		checkInvariant();
		
		//post: getDurationStunned()>0 => getDurationStunned()==getDurationStunned()@Pre -1
		if(getDurationStunned()>0)
			if(!(getDurationStunned()==getDurationStunned_atPre -1))
				throw new PostConditionError("Error PostCondition: getDurationStunned()==getDurationStunned_atPre -1");
	}

	@Override
	public void setCoupBox(RectangleHitboxService rectangleHitbox) {
		getDelegate().setCoupBox(rectangleHitbox);
	}

	@Override
	public int getDurationStunned() {
		return getDelegate().getDurationStunned();
	}

	@Override
	public int getFrameTech() {
		return getDelegate().getFrameTech();
	}
	
	
}
