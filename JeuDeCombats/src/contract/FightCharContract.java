package contract;

import error.PostConditionError;
import error.PreConditionError;
import implementation.RectangleHitboxImpl;
import personnages.InformationsCharacter;
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

	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {

		// pre: l > 0
		if (!(l > 0))
			throw new PreConditionError("Error PreCondition : l>0");

		// pre: s > 0
		if (!(s > 0))
			throw new PreConditionError("Error PreCondition : s>0");

		getDelegate().init(l, s, f, numeroPlayer);

		checkInvariant();

		// post: getLife() == l
		if (!(getLife() == l))
			throw new PostConditionError("Error PostCondition: getLife() == l");

		// post: getSpeed() == s
		if (!(getSpeed() == s))
			throw new PostConditionError("Error PostCondition: getSpeed() == s");

		// post: isfaceRight() == f
		if (!(isFaceRight() == f))
			throw new PostConditionError("Error PostCondition: isfaceRight() == f");

		//post: getNumeroPlayer()==numeroPlayer
		if(!(getNumeroPlayer()==numeroPlayer))
			throw new PostConditionError("Error PostCondition: getNumeroPlayer()==numeroPlayer");
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

		checkInvariant();

		getDelegate().step(c);

		checkInvariant();
	}

	@Override
	public void kick() {
		RectangleHitboxService getCharBox_atPre = getRectangleHitbox();
		RectangleHitboxService getCoupBox_atPre = getCoupBox();

		checkInvariant();

		getDelegate().kick();

		checkInvariant();

		//post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()))
		getCharBox_atPre.setHeight(InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()));
		if(!(getRectangleHitbox().getHeight()==getCharBox_atPre.getHeight()))
			throw new PostConditionError("Error PostCondition: getCharBox().getHeight()==getCharBox_atPre.getHeight()");

		// post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()))
		getCharBox_atPre.setWidth(InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()));
		if(!(getRectangleHitbox().getWidth()==getCharBox_atPre.getWidth()))
			throw new PostConditionError("Error PostCondition: getCharBox().getWidth()==getCharBox_atPre.getWidth()");

		// post: getCoupBox().getHeight()==getCoupBox@Pre.setHeight(InformationsCharacter.getHeightSpritePersoFoot(getNumeroCharacter()))
		getCoupBox_atPre.setHeight(InformationsCharacter.getHeightSpritePersoFoot(getNumeroCharacter()));
		if(!(getCoupBox().getHeight()==getCoupBox_atPre.getHeight()))
			throw new PostConditionError("Error PostCondition: (getCoupBox().getHeight()==getCoupBox_atPre.getHeight()");

		// post: getCoupBox().getWidth()==getCoupBox@Pre.setWidth(InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()))
		getCoupBox_atPre.setWidth(InformationsCharacter.getWidthSpritePersoFoot(this.getNumeroCharacter()));
		if(!(getCoupBox().getWidth()==getCoupBox_atPre.getWidth()))
			throw new PostConditionError("Error PostCondition: getCoupBox().getWidth()==getCoupBox_atPre.getWidth()");

		// post: getCoupBox().getPosY()==getCoupBox@Pre.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoFoot(this.getNumeroCharacter()))
		getCoupBox_atPre.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getHeightSpritePersoFoot(this.getNumeroCharacter()));
		if(!(getCoupBox().getPosY()==getCoupBox_atPre.getPosY()))
			throw new PostConditionError("Error PostCondition: getCoupBox().getPosY()==getCoupBox_atPre.getPosY()");

		// post: isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoKick(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()))
		if(isFaceRight()){
			getCoupBox_atPre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoKick(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()));
			if(!(getCoupBox().getPosX()==getCoupBox_atPre.getPosX()))
				throw new PostConditionError("Error PostCondition: getCoupBox().getPosX()==getCoupBox_atPre.getPosX()");
		}

		// post: not isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()))
		if(!isFaceRight()){
			getCoupBox_atPre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoFoot(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoFoot(getNumeroCharacter()));
			if(!(getCoupBox().getPosX()==getCoupBox_atPre.getPosX()))
				throw new PostConditionError("Error PostCondition: getCoupBox().getPosX()==getCoupBox_atPre.getPosX()");
		}

		/**post: \exist i in {0,1}  
		 * 			getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCharBox()) ||
					getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCoupBox())
					=>
						!getEngine().getPlayer(i).getFightCharacter().isBlocking())
							=> getEngine().getPlayer(i).getFightCharacter().getDurationStunned()==3
		 */
		for(int i=0; i<1;i++){
			if(getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()) ||
					getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCoupBox())){
				if(!getEngine().getPlayer(i).getFightCharacter().isBlocking()){
					if(!(getEngine().getPlayer(i).getFightCharacter().getDurationStunned()==3))
						throw new PostConditionError("Error PostCondition: getEngine().getPlayer(i).getFightCharacter().getDurationStunned()==3");
				}
			}
		}
	}

	@Override
	public void punch() {
		RectangleHitboxService getCharBox_atPre = getRectangleHitbox();
		RectangleHitboxService getCoupBox_atPre = getCoupBox();

		checkInvariant();

		getDelegate().punch();

		checkInvariant();

		//post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()))
		getCharBox_atPre.setHeight(InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()));
		if(!(getRectangleHitbox().getHeight()==getCharBox_atPre.getHeight()))
			throw new PostConditionError("Error PostCondition: getCharBox().getHeight()==getCharBox_atPre.getHeight()");

		// post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()))
		getCharBox_atPre.setWidth(InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()));
		if(!(getRectangleHitbox().getWidth()==getCharBox_atPre.getWidth()))
			throw new PostConditionError("Error PostCondition: getCharBox().getWidth()==getCharBox_atPre.getWidth()");

		// post: getCoupBox().getHeight()==getCoupBox@Pre.setHeight(InformationsCharacter.getHeightSpritePersoArm(getNumeroCharacter()))
		getCoupBox_atPre.setHeight(InformationsCharacter.getHeightSpritePersoArm(getNumeroCharacter()));
		if(!(getCoupBox().getHeight()==getCoupBox_atPre.getHeight()))
			throw new PostConditionError("Error PostCondition: (getCoupBox().getHeight()==getCoupBox_atPre.getHeight()");

		// post: getCoupBox().getWidth()==getCoupBox@Pre.setWidth(InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()))
		getCoupBox_atPre.setWidth(InformationsCharacter.getWidthSpritePersoArm(this.getNumeroCharacter()));
		if(!(getCoupBox().getWidth()==getCoupBox_atPre.getWidth()))
			throw new PostConditionError("Error PostCondition: getCoupBox().getWidth()==getCoupBox_atPre.getWidth()");

		// post: getCoupBox().getPosY()==getCoupBox@Pre.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoArm(this.getNumeroCharacter())InformationsCharacter.getHeightSpritePersoArm(0))
		getCoupBox_atPre.setPosY(this.getPositionY()+InformationsCharacter.getPosYSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getHeightSpritePersoArm(0));
		if(!(getCoupBox().getPosY()==getCoupBox_atPre.getPosY()))
			throw new PostConditionError("Error PostCondition: getCoupBox().getPosY()==getCoupBox_atPre.getPosY()");

		// post: isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoPunch(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(getNumeroCharacter()))
		if(isFaceRight()){
			getCoupBox_atPre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoPunch(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(getNumeroCharacter()));
			if(!(getCoupBox().getPosX()==getCoupBox_atPre.getPosX()))
				throw new PostConditionError("Error PostCondition: getCoupBox().getPosX()==getCoupBox_atPre.getPosX()");
		}

		// post: not isFaceRight() => getCoupBox().getPosX()==getCoupBox@Pre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(getNumeroCharacter()))
		if(!isFaceRight()){
			getCoupBox_atPre.setPosX(this.getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(this.getNumeroCharacter())-InformationsCharacter.getPosXSpritePersoArm(this.getNumeroCharacter())-InformationsCharacter.getWidthSpritePersoArm(getNumeroCharacter()));
			if(!(getCoupBox().getPosX()==getCoupBox_atPre.getPosX()))
				throw new PostConditionError("Error PostCondition: getCoupBox().getPosX()==getCoupBox_atPre.getPosX()");
		}

		/**post: \exist i in {0,1}  
		 * 			getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCharBox()) ||
					getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCoupBox())
					=>
						!getEngine().getPlayer(i).getFightCharacter().isBlocking())
							=> getEngine().getPlayer(i).getFightCharacter().getDurationStunned()==2
		 */
		for(int i=0; i<1;i++){
			if(getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()) ||
					getCoupBox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getCoupBox())){
				if(!getEngine().getPlayer(i).getFightCharacter().isBlocking()){
					if(!(getEngine().getPlayer(i).getFightCharacter().getDurationStunned()==2))
						throw new PostConditionError("Error PostCondition: getEngine().getPlayer("+i+").getFightCharacter().getDurationStunned()==2");
				}
			}
		}
	}

	@Override
	public void block() {

		RectangleHitboxService getCharBox_atPre = getRectangleHitbox();

		checkInvariant();

		getDelegate().block();

		checkInvariant();

		// post: getCharBox().getHeight()==getCharBox()@Pre.setHeight(InformationsCharacter.getHeightSpritePersoBlocking(getNumeroCharacter()))
		getCharBox_atPre.setHeight(InformationsCharacter.getHeightSpritePersoBlocking(getNumeroCharacter()));
		if(!(getRectangleHitbox().getHeight()==getCharBox_atPre.getHeight()))
			throw new PostConditionError("Error PostCondition: getCharBox().getHeight()==getCharBox_atPre.getHeight()");

		// post: getCharBox().getWidth()==getCharBox()@Pre.setWidth(InformationsCharacter.getWidthSpritePersoBlocking(getNumeroCharacter()))
		getCharBox_atPre.setWidth(InformationsCharacter.getWidthSpritePersoBlocking(getNumeroCharacter()));
		if(!(getRectangleHitbox().getWidth()==getCharBox_atPre.getWidth()))
			throw new PostConditionError("Error PostCondition: getCharBox().getWidth()==getCharBox_atPre.getHeight()");
	}



	@Override
	public void hit() {

		int getLife_atPre=getLife();

		checkInvariant();

		getDelegate().hit();

		checkInvariant();

		int otherPlayer = 0;
		if(this.getNumeroPlayer()==0)
			otherPlayer = 1;

		//post: (getLife()==getLife_atPre-InformationsCharacter.getDamage(getOtherPlayer().getFightCharacter().getNumeroCharacter()))

		if(!(getLife()==getLife_atPre-InformationsCharacter.getDamage(getEngine().getPlayer(otherPlayer).getFightCharacter().getNumeroCharacter())))
			throw new PostConditionError("Error PostCondition: getLife()==getLife_atPre-InformationsCharacter.getDamage(getEngine().getPlayer(i).getFightCharacter().getNumeroCharacter())");

	}

	@Override
	public RectangleHitboxService getCoupBox() {
		return getDelegate().getCoupBox();
	}

	@Override
	public void dead() {

		checkInvariant();

		getDelegate().dead();

		checkInvariant();

		/**
		 * post:\exist i && j in {0,1},j!=i, getEngine().getPlayer(i).getFightCharacter().getLife()<=0 
		 * 							=> getEngine().getPlayer(i).getFightCharacter().isDead()
		 */

		if(getEngine().getPlayer(0).getFightCharacter().getLife()<=0){

			if(!(getEngine().getPlayer(0).getFightCharacter().isDead()))
				throw new PostConditionError("Error PostCondition: getEngine().getPlayer(0).getFightCharacter().isDead()");

		}

		if(getEngine().getPlayer(1).getFightCharacter().getLife()<=0){

			if(!(getEngine().getPlayer(1).getFightCharacter().isDead()))
				throw new PostConditionError("Error PostCondition: getEngine().getPlayer(1).getFightCharacter().isDead()");

		}

	}

	@Override
	public void nextFrameTech() {

		int getTechFrame_atPre = getFrameTech();

		checkInvariant();

		getDelegate().nextFrameTech();

		checkInvariant();

		//post: getFrameTech()<2 => getFrameTech()==getFrameTech()@Pre++
		if(getFrameTech()<2)
			if(!(getFrameTech()==getTechFrame_atPre++))
				throw new PostConditionError("Error PostCondition: getFrameTech()==getTechFrame_atPre++");

		//post: getFrameTech()>=2 => getFrameTech()==0 && getTeching()==true
		if(getFrameTech()>=2)
			if(!(getFrameTech()==0 && isTeching()))
				throw new PostConditionError("Error PostCondition: getFrameTech()==0 && isTeching()");
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

		checkInvariant();

		getDelegate().setCoupBox(rectangleHitbox);

		checkInvariant();

		//post: getCoupBox()==rectangleHitbox
		if(!(getCoupBox()==rectangleHitbox))
			throw new PostConditionError("Error PostCondition: getCoupBox()==rectangleHitbox");
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
