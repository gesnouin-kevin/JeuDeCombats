package decorator;

import service.CharacterService;
import service.FightCharService;
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

}
