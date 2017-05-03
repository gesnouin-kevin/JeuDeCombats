package decorator;

import service.CharacterService;
import service.Command;
import service.FightCharService;
import service.RectangleHitboxService;

public class FightCharDecorator extends CharacterDecorator implements FightCharService {

	public FightCharDecorator(CharacterService cs) {
		super(cs);
	}
	
	@Override
	protected FightCharService getDelegate() {
		return (FightCharService) super.getDelegate();
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
		getDelegate().block();
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
		getDelegate().nextFrameTech();
	}

	@Override
	public void setDurationStunned(int bs) {
		getDelegate().setDurationStunned(bs);
	}

	@Override
	public void updateDurationStunned() {
		getDelegate().updateDurationStunned();
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
