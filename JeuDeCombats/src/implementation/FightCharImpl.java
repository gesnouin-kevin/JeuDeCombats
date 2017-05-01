package implementation;

import service.Command;
import service.EngineService;
import service.FightCharService;
import service.RectangleHitboxService;
import service.TechData;

public class FightCharImpl extends CharacterImpl implements FightCharService{

	private boolean blocking;
	private boolean blockstunned;
	private boolean hitstunned;
	private boolean teching;
	private boolean techFrame;
	private boolean techHasAlreadyHit;
	private RectangleHitboxService coupBox;
	private EngineService engine;

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

	@Override
	public void step(Command c) {
		switch (c) {
		case KICK:
			this.teching=true;
			this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(6);
			kick();
			break;

		case PUNCH:
			this.teching=true;
			this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(5);
			punch();
			break;

		case BLOCK_PRESSED:
			this.blocking=true;
			this.teching=true;
			this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(4);
			block();
			break;

		case BLOCK_RELEASED:
			this.blocking=false;
			this.teching=false;;
			break;

		default:
			this.teching=false;
			super.step(c);
			break;
		}

	}

	@Override
	public void kick() {
		//this.
	}

	@Override
	public void block() {
		
	}

	@Override
	public void punch() {
		
	}

	@Override
	public void hit() {
		
	}

	@Override
	public RectangleHitboxService getCoupBox() {
		return this.coupBox;
	}

	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {
		super.init(l, s, f, numeroPlayer);		
	}

	
	
}
