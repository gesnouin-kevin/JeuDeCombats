package implementation;

import personnages.InformationsCharacter;
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

		if(!this.teching || !this.blockstunned){
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
				this.teching=false;
				this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(0);
				break;

			default:
				this.teching=false;
				super.step(c);
				break;
			}
		}
	}

	@Override
	public void kick() {
		int otherPlayer = -1;

		if(this.getNumeroPlayer() == 0)
			otherPlayer =1;
		else
			otherPlayer =0;

		this.getCharBox().setHeight(InformationsCharacter.getHeightSpritePersoIdle(this.getNumeroCharacter()));
		this.getCharBox().setWidth(InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter()));

		this.coupBox.setHeight(InformationsCharacter.getHeightSpritePersoFoot(this.getNumeroCharacter()));
		this.coupBox.setWidth(InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()));
		this.coupBox.setPosY(InformationsCharacter.getPosYSpritePersoFoot(this.getNumeroCharacter()));

		if(this.isFaceRight())
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoKick(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()));
		else
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()));
		
		if(this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getCharacter().getCharBox()) ||
				this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getCoupBox()))
		{
			this.getEngine().getPlayer(otherPlayer).getFightCharacter().hit();
		}
	}

	@Override
	public void block() {
		this.getCharBox().setHeight(InformationsCharacter.getHeightSpritePersoBlocking(this.getNumeroCharacter()));
		this.getCharBox().setWidth(InformationsCharacter.getWidthSpritePersoBlocking(this.getNumeroCharacter()));
	}

	@Override
	public void punch() {
		int otherPlayer = -1;

		if(getNumeroPlayer() == 0)
			otherPlayer =1;
		else
			otherPlayer =0;

		this.getCharBox().setHeight(InformationsCharacter.getHeightSpritePersoIdle(this.getNumeroCharacter()));
		this.getCharBox().setWidth(InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter()));

		this.coupBox.setHeight(InformationsCharacter.getHeightSpritePersoArm(this.getNumeroCharacter()));
		this.coupBox.setWidth(InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()));
		this.coupBox.setPosY(InformationsCharacter.getPosYSpritePersoArm(this.getNumeroCharacter()));

		if(this.isFaceRight())
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoPunch(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()));
		else
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()));
		
		if(this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getCharacter().getCharBox()) ||
				this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getCoupBox()))
			this.getEngine().getPlayer(otherPlayer).getFightCharacter().hit();
	}

	@Override
	public void hit() {
		int otherPlayer = -1;

		if(getNumeroPlayer() == 0)
			otherPlayer =1;
		else
			otherPlayer =0;
		//ptete remove car on ne sait pas quand fini le truc de se faire hit donc on ne sait pas quand remettre bounding box idle
		//this.getCharBox().setHeight(InformationsCharacter.getHeightSpritePersoHit(this.getNumeroCharacter()));
		//this.getCharBox().setWidth(InformationsCharacter.getWidthSpritePersoHit(this.getNumeroCharacter()));
		this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(7);
		
		super.setLife(super.getLife()-InformationsCharacter.getDamage(this.getEngine().getPlayer(otherPlayer).getCharacter().getNumeroCharacter()));
	}

	@Override
	public RectangleHitboxService getCoupBox() {
		return this.coupBox;
	}

	public void setCoupBox(RectangleHitboxService rectangleHitbox){
		this.coupBox=rectangleHitbox;
	}

	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {
		super.init(l, s, f, numeroPlayer);
		this.blocking=false;
		this.blockstunned=false;
		this.hitstunned=false;
		this.teching=false;
		this.techFrame=false;
		this.techHasAlreadyHit=false;

		this.coupBox=new RectangleHitboxImpl();
		//this.setCoupBox(this.coupBox);
	}
}
