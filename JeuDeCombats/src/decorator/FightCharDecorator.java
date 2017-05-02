package decorator;

import service.CharacterService;
import service.Command;
import service.FightCharService;
import service.RectangleHitboxService;
import service.TechData;

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
	public boolean isBlockstunned() {
		return getDelegate().isBlockstunned();
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
	public TechData getTech() {
		return getDelegate().getTech();
	}

	@Override
	public boolean techFrame() {
		return getDelegate().techFrame();
	}

	@Override
	public boolean techHasAlreadyHit() {
		return getDelegate().techHasAlreadyHit();
	}

	@Override
	public void startTech(TechData ts) {
		getDelegate().startTech(ts);		
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
	public void setLife(int l) {
		getDelegate().setLife(l);
		
	}

	
}
