package implementation;

import service.FightCharService;
import service.TechData;

public class FightCharImpl extends CharacterImpl implements FightCharService{

	private boolean blocking;
	private boolean blockstunned;
	private boolean hitstunned;
	private boolean teching;
	private boolean techFrame;
	private boolean techHasAlreadyHit;
	
	@Override
	public boolean isBlocking() {
		return this.blocking;
	}

	@Override
	public boolean isBlockstunned() {
		return this.blockstunned;
	}

	@Override
	public boolean isHitstunned() {
		return this.hitstunned;
	}

	@Override
	public boolean isTeching() {
		return this.teching;
	}

	@Override
	public TechData getTech() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean techFrame() {
		return this.techFrame;
	}

	@Override
	public boolean techHasAlreadyHit() {
		return this.techHasAlreadyHit;
	}

	@Override
	public void startTech(TechData ts) {
		// TODO Auto-generated method stub
		
	}

}
