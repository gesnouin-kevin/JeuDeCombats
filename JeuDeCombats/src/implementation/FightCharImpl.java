package implementation;

import personnages.InformationsCharacter;
import service.Command;
import service.FightCharService;
import service.RectangleHitboxService;


public class FightCharImpl extends CharacterImpl implements FightCharService{

	
	private boolean blocking;
	private boolean hitstunned;
	private boolean teching;
	private int techFrame;
	private int technique;
	private int durationStunned;
	private RectangleHitboxService coupBox;
	
	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {
		super.init(l, s, f, numeroPlayer);
		this.blocking=false;
		this.durationStunned=0;
		this.hitstunned=false;
		this.teching=false;
		this.techFrame=0;
		this.technique=0;
		this.coupBox=new RectangleHitboxImpl();
	}

	@Override
	public void step(Command c) {

		if(!this.teching && this.durationStunned==0){
			switch (c) {
			case KICK:
				this.techFrame=0;
				this.teching=true;
				this.technique=6;
				this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(6);
				break;

			case PUNCH:
				this.techFrame=0;
				this.teching=true;
				this.technique=5;
				this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(5);
				break;

			case BLOCK_PRESSED:
				this.blocking=true;
				this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(4);
				block();
				break;

			case BLOCK_RELEASED:
				this.blocking=false;
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

		this.getRectangleHitbox().setHeight(InformationsCharacter.getHeightSpritePersoIdle(this.getNumeroCharacter()));
		this.getRectangleHitbox().setWidth(InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter()));

		this.coupBox.setHeight(InformationsCharacter.getHeightSpritePersoFoot(this.getNumeroCharacter()));
		this.coupBox.setWidth(InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()));
		this.coupBox.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getHeightSpritePersoFoot(this.getNumeroCharacter()));

		if(this.isFaceRight())
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoKick(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()));
		else
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()));
		
		if(this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getRectangleHitbox()) ||
				this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getCoupBox()))
		{
			if(!this.getEngine().getPlayer(otherPlayer).getFightCharacter().isBlocking()){
				this.getEngine().getPlayer(otherPlayer).getFightCharacter().hit();
				this.getEngine().getPlayer(otherPlayer).getFightCharacter().setDurationStunned(3);

			}
		}
	}

	@Override
	public void punch() {
		int otherPlayer = -1;

		if(getNumeroPlayer() == 0)
			otherPlayer =1;
		else
			otherPlayer =0;

		this.getRectangleHitbox().setHeight(InformationsCharacter.getHeightSpritePersoIdle(this.getNumeroCharacter()));
		this.getRectangleHitbox().setWidth(InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter()));

		this.coupBox.setHeight(InformationsCharacter.getHeightSpritePersoArm(this.getNumeroCharacter()));
		this.coupBox.setWidth(InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()));
		this.coupBox.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getHeightSpritePersoArm(this.getNumeroCharacter()));

		if(this.isFaceRight())
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoPunch(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()));
		else
			this.coupBox.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()));
		
		if(this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getRectangleHitbox()) ||
				this.coupBox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getCoupBox()))
		{
			if(!this.getEngine().getPlayer(otherPlayer).getFightCharacter().isBlocking()){
				this.getEngine().getPlayer(otherPlayer).getFightCharacter().hit();
				this.getEngine().getPlayer(otherPlayer).getFightCharacter().setDurationStunned(2);

			}
		}
	}

	@Override
	public void hit() {
		int otherPlayer = -1;

		if(getNumeroPlayer() == 0)
			otherPlayer =1;
		else
			otherPlayer =0;

		this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(7);
		
		this.setLife(this.getLife()-InformationsCharacter.getDamage(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getNumeroCharacter()));
		dead();
	}
	
	@Override
	public void block() {
		this.getRectangleHitbox().setHeight(InformationsCharacter.getHeightSpritePersoBlocking(this.getNumeroCharacter()));
		this.getRectangleHitbox().setWidth(InformationsCharacter.getWidthSpritePersoBlocking(this.getNumeroCharacter()));
	}

	@Override
	public void dead() {
		int otherPlayer = -1;

		if(getNumeroPlayer() == 0)
			otherPlayer =1;
		else
			otherPlayer =0;
		
		if(this.getLife()<=0){
			this.setDead(true);
			this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(9);
			this.getEngine().getPlayer(otherPlayer).getAnimationPlayer().setCurrentAnimation(10);
			
		}else if(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getLife()<=0){
			this.getEngine().getPlayer(otherPlayer).getFightCharacter().setDead(true);
			this.getEngine().getPlayer(otherPlayer).getAnimationPlayer().setCurrentAnimation(9);
			this.getEngine().getPlayer(getNumeroPlayer()).getAnimationPlayer().setCurrentAnimation(10);
		}
	}

	@Override
	public void nextFrameTech() {
		if(this.techFrame<2){
			this.techFrame++;
			
			if(this.techFrame==1){
				if(this.technique==5){
					punch();
					this.technique=0;
				}else if(this.technique==6){
					kick();
					this.technique=0;
				}				
			}	
		}else{
			this.techFrame=0;
			this.teching=false;
			this.coupBox.setWidthHeight(0, 0);
		}
	}

	@Override
	public void updateDurationStunned() {
		if(this.durationStunned>0){
			this.durationStunned--;
		}
	}
	
	@Override
	public boolean isBlocking() { return this.blocking; }
	@Override
	public boolean isHitstunned() { return this.hitstunned; }
	@Override
	public boolean isTeching() { return this.teching; }
	@Override
	public RectangleHitboxService getCoupBox() { return this.coupBox; }
	@Override
	public void setCoupBox(RectangleHitboxService rectangleHitbox){ this.coupBox=rectangleHitbox; }
	@Override
	public int getDurationStunned() { return this.durationStunned; }
	@Override
	public void setDurationStunned(int bs) { this.durationStunned=bs; }
	@Override
	public int getFrameTech() { return 0; }

}
