package contract;

import decorator.CharacterDecorator;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;
import personnages.InformationsCharacter;
import service.CharacterService;
import service.Command;
import service.EngineService;
import service.RectangleHitboxService;

public class CharacterContract extends CharacterDecorator {

	public CharacterContract(CharacterService cs) {
		super(cs);
	}


	public void checkInvariant() {

		//inv: getPositionX() >= 0 and getPositionX() < Engine::getWidth()
		if (!(getPositionX() >= 0 && getPositionX() < getEngine().getWidth()))
			throw new InvariantError("Error checkInvariant: getPositionX() > 0 && getPositionX() < getEngine().getWidth()");

		// inv: getPositionY() >= 0 && getPositionY() < Engine::getHeight()
		if (!(getPositionY() >= 0 && getPositionY() < getEngine().getHeight()))
			throw new InvariantError("Error checkInvariant: getPositionY() > 0 && getPositionY() < getEngine().getHeight()");

		// inv: isDead() == not (getLife() >= 0)
		if (!(isDead() == !(getLife() > 0)))
			throw new InvariantError("Error checkInvariant: isDead() == !getLife() > 0");
		
	}
	
	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {

		// pre: l > 0
		if (!(l > 0))
			throw new PreConditionError("Error PreCondition : l>0");

		// pre: s > 0
		if (!(s > 0))
			throw new PreConditionError("Error PreCondition : s>0");

		super.init(l, s, f, numeroPlayer);

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

	}

	@Override
	public void init(EngineService es){

		super.init(es);
		checkInvariant();
		// post: getEngine() == e
		if (!(getEngine() == es))
			throw new PostConditionError("Error PostCondition: getEngine() == e");
	}

	@Override
	public void moveLeft(){
		int getPositionX_atPre = getPositionX();
		int getPositionY_atPre = getPositionY();
		int getSpeed_atPre = getSpeed();
		int getLife_atPre = getLife();
		boolean isFaceRight_atPre = isFaceRight();

		checkInvariant();

		super.moveLeft();

		checkInvariant();

		//post: \exist i { getEngine().getChar(i)!= this and getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox())
		//		 				=> getPositionX() == getPositionX()@Pre }
		int compt=0;
		for (int i = 0; i < 2; i++) {
			if(getEngine().getPlayer(i).getFightCharacter()!= this && getRectangleHitbox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()))
				if(!(getPositionX()==getPositionX_atPre))
					compt++;
		}
		if(compt>0)
			throw new PostConditionError("Error PostCondition: getPositionX() == getPositionX()@Pre");

		//post: getPositionX()<=getSpeed() and
		//		 		\forall i { getEngine().getChar(i)!=this => not getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
		//		 					=> getPositionX() == getPositionX()@Pre - getSpeed() }
		if(getPositionX_atPre<=getSpeed_atPre)
			for (int i = 0; i < 2; i++) {
				if(getEngine().getPlayer(i).getFightCharacter()!=this)
					if(getRectangleHitbox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()))
						throw new PostConditionError("Error PostCondition: !getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()");
					else if(!(getPositionX() == getPositionX_atPre - getSpeed()))
						throw new PostConditionError("Error PostCondition: getPositionX() == getPositionX()@Pre - getSpeed()");
			}


		//post: getPositionX()>getSpeed() and
		//		 		\forall i { getEngine().getChar(i)!=this => not getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
		//		 				=> getPositionX() == 0 }

		if(getPositionX_atPre>getSpeed_atPre){
			for (int i = 0; i < 2; i++) {
				if(getEngine().getPlayer(i).getFightCharacter()!=this)
					if(getRectangleHitbox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()))
						throw new PostConditionError("Error PostCondition: !getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()");
					else if(!(getPositionX() == 0))
						throw new PostConditionError("Error PostCondition: getPositionX() == 0");
			}

		}
		// post: faceRight() == faceRight()@Pre && getLife() == getLife()@Pre
		if (!(isFaceRight() == isFaceRight_atPre && getLife() == getLife_atPre))
			throw new PostConditionError("Error PostCondition: isFaceRight() && getLife() ");

		// post: getPositionY() == getPositionY()@Pre
		if (!(getPositionY() == getPositionY_atPre))
			throw new PostConditionError("Error PostCondition: getPositionY()");
	}


	@Override
	public void moveRight(){
		int getPositionX_atPre = getPositionX();
		int getPositionY_atPre = getPositionY();
		int getSpeed_atPre = getSpeed();
		int getLife_atPre = getLife();
		boolean isFaceRight_atPre = isFaceRight();

		checkInvariant();

		super.moveRight();

		checkInvariant();

		//post: \exist i { getEngine().getChar(i)!= this and getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox())
		//		 				=> getPositionX() == getPositionX()@Pre }
		int compt=0;
		for (int i = 0; i < 2; i++) {
			if(getEngine().getPlayer(i).getFightCharacter()!= this && getRectangleHitbox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()))
				if(!(getPositionX()==getPositionX_atPre))
					compt++;
		}
		if(compt>0)
			throw new PostConditionError("Error PostCondition: getPositionX() == getPositionX()@Pre");

		//post: getPositionX()<=getSpeed() and
		//		 		\forall i { getEngine().getChar(i)!=this => not getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
		//		 					=> getPositionX() == getPositionX()@Pre + getSpeed() }
		if(getPositionX_atPre<=getSpeed_atPre)
			for (int i = 0; i < 2; i++) {
				if(getEngine().getPlayer(i).getFightCharacter()!=this)
					if(getRectangleHitbox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()))
						throw new PostConditionError("Error PostCondition: !getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()");
					else if(!(getPositionX() == getPositionX_atPre + getSpeed())){
						throw new PostConditionError("Error PostCondition: getPositionX() == getPositionX()@Pre - getSpeed()");
					}
			}


		//post: getPositionX()>getSpeed() and
		//		 		\forall i { getEngine().getChar(i)!=this => not getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()@Pre)
		//		 				=> getPositionX() == 0 }

		if(getPositionX_atPre>getSpeed_atPre){
			for (int i = 0; i < 2; i++) {
				if(getEngine().getPlayer(i).getFightCharacter()!=this)
					if(getRectangleHitbox().isCollidesWith(getEngine().getPlayer(i).getFightCharacter().getRectangleHitbox()))
						throw new PostConditionError("Error PostCondition: !getCharBox().isCollidesWith(getEngine().getChar(i).getCharBox()");
					else if(!(getPositionX() == 0))
						throw new PostConditionError("Error PostCondition: getPositionX() == 0");
			}

		}

		// post: faceRight() == isFaceRight()@Pre && getLife() == getLife()@Pre
		if (!(isFaceRight() == (isFaceRight_atPre) && getLife() == getLife_atPre)){
			throw new PostConditionError("Error PostCondition: isFaceRight() && getLife() ");
		}

		// post: getPositionY() == getPositionY()@Pre
		if (!(getPositionY() == getPositionY_atPre))
			throw new PostConditionError("Error PostCondition: getPositionY()");
	}

	@Override
	public void switchSide() {
		boolean faceRight_atPre = isFaceRight();
		int positionX_atPre = getPositionX();

		checkInvariant();

		super.switchSide();

		checkInvariant();

		// post: faceRight() != faceRight()@Pre
		if (!(isFaceRight() != faceRight_atPre))
			throw new PostConditionError("Error PosCondition: isFaceRight()");

		// post: getPositionX() == getPositionX()@Pre
		if (!(getPositionX() == positionX_atPre))
			throw new PostConditionError("Error PosCondition: getPositionX()");
	}

	@Override
	public void step(Command c) {

		int positionX_atPre = getPositionX();
		// pre: !isDead()
		if (!(!isDead()))
			throw new PreConditionError("Error Precondition: !isDead()");

		checkInvariant();

		super.step(c);

		checkInvariant();


		//post: step(LEFT_PRESSED) == moveLeft()
		if(c==Command.LEFT_PRESSED)
			if(!(getPositionX()<positionX_atPre))
				throw new PostConditionError("Error Precondition: step(LEFT) == moveLeft()");

		//post: step(RIGHT_PRESSED) == moveRight()
		if(c==Command.RIGHT_PRESSED)
			if(!(getPositionX()>positionX_atPre))
				throw new PostConditionError("Error Precondition: step(RIGHT) == moveRight()");

		//post: step(NEUTRAL) == this
		if(c==Command.NEUTRAL)
			if(!(getPositionX()==positionX_atPre))
				throw new PostConditionError("Error Precondition: step(NEUTRAL) == this");
	}

	@Override
	public void setPositionX(int x) {

		// pre: x >= 0
		if (!(x >= 0))
			throw new PreConditionError("Error PreCondition: x >= 0");

		checkInvariant();

		super.setPositionX(x);

		checkInvariant();

		// post: getPositionX() == x
		if (!(getPositionX() == x))
			throw new PostConditionError("Error PostCondition: getPositionX() == x");
	}

	@Override
	public void setPositionY(int y) {

		// pre: y >= 0
		if (!(y >= 0))
			throw new PreConditionError("Error PreCondition: y >= 0");

		checkInvariant();

		super.setPositionY(y);

		checkInvariant();

		// post: getPositionY() == y
		if (!(getPositionY() == y))
			throw new PostConditionError("Error PostCondition: getPositionY() == y");
	}

	@Override
	public void setFaceRight(boolean fr) {


		checkInvariant();

		super.setFaceRight(fr);

		checkInvariant();

		// post: isFaceRight() == fr
		if (!(isFaceRight() == fr))
			throw new PostConditionError("Error PostCondition: isFaceRight() == fr");
	}

	@Override
	public int getNumeroPlayer() {
		return super.getNumeroPlayer();
	}

	@Override
	public void setNumeroPlayer(int numeroPlayer) {

		//pre: numeroPlayer>=0 && numeroPlayer<=1
		if(!(numeroPlayer>=0 || numeroPlayer<=1))
			throw new PreConditionError("Error PreCondition: numeroPlayer>=0 || numeroPlayer<=1");

		checkInvariant();

		super.setNumeroPlayer(numeroPlayer);

		checkInvariant();

		//post: getNumeroPlayer == numeroPlayer
		if(!(getNumeroPlayer()==numeroPlayer))
			throw new PostConditionError("Error PostCondition: getNumeroPlayer()==numeroPlayer");
	}


	@Override
	public void setRectangleHitboxService(RectangleHitboxService rectangleHitbox) {

		checkInvariant();

		super.setRectangleHitboxService(rectangleHitbox);

		checkInvariant();

		if(!(getRectangleHitbox()==rectangleHitbox))
			throw new PostConditionError("Error PostCondition: getRectangleHitboxService()==rectangleHitbox");
	}

	@Override
	public void setNumeroCharacter(int numeroCharacter) {

		//pre: numeroPlayer>=0 && numeroPlayer<=15
		if(!(numeroCharacter>=0 || numeroCharacter<=15))
			throw new PreConditionError("Error PreCondition: numeroCharacter>=0 || numeroCharacter<=15");

		checkInvariant();

		super.setNumeroCharacter(numeroCharacter);

		checkInvariant();

		//post: getNumeroPlayer == numeroPlayer
		if(!(getNumeroCharacter()==numeroCharacter))
			throw new PostConditionError("Error PostCondition: getNumeroCharacter()==numeroCharacter");
	}


	@Override
	public boolean isRunning() {
		return super.isRunning();
	}


	@Override
	public boolean isCrouching() {
		return super.isCrouching();
	}


	@Override
	public void moveDown() {

		int getPositionY_atPre = getPositionY();
		int getLife_atPre = getLife();
		boolean isFaceRight_atPre = isFaceRight();

		checkInvariant();

		super.moveDown();

		checkInvariant();

		// post: faceRight() == isFaceRight()@Pre && getLife() == getLife()@Pre
		if (!(isFaceRight() == (isFaceRight_atPre) && getLife() == getLife_atPre))
			throw new PostConditionError("Error PostCondition: isFaceRight() && getLife() ");

		// post: getPositionY() == getPositionY()@Pre
		if (!(getPositionY() == getPositionY_atPre))
			throw new PostConditionError("Error PostCondition: getPositionY()");
	}


	@Override
	public boolean isJumping() {
		return super.isJumping();
	}


	@Override
	public void moveUp() {

		int getPositionY_atPre = getPositionY();
		int getLife_atPre = getLife();
		boolean isFaceRight_atPre = isFaceRight();

		checkInvariant();

		super.moveUp();

		checkInvariant();

		// post: faceRight() == isFaceRight()@Pre && getLife() == getLife()@Pre
		if (!(isFaceRight() == (isFaceRight_atPre) && getLife() == getLife_atPre))
			throw new PostConditionError("Error PostCondition: isFaceRight() && getLife() ");

		// post: getPositionY() == getPositionY()@Pre
		if (!(getPositionY() == getPositionY_atPre))
			throw new PostConditionError("Error PostCondition: getPositionY()");
	}


	@Override
	public void neutral() {
		checkInvariant();
		super.neutral();
		checkInvariant();

		// post: getRectangleHitbox().getHeight == InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter())
		if(this.getRectangleHitbox().getHeight()!= InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter()))
			throw new PostConditionError("Error PostCondition:getRectangleHitbox().getHeight != InformationsCharacter.getHeightSpritePersoIdle(getNumeroCharacter())");

		// post: getRectangleHitbox().getWidth == InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter)
		if(this.getRectangleHitbox().getWidth()!= InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter()))
			throw new PostConditionError("Error PostCondition:getRectangleHitbox().getWidth != InformationsCharacter.getWidthSpritePersoIdle(getNumeroCharacter())");
	}


	@Override
	public void updateY() {
		checkInvariant();
		super.updateY();
		checkInvariant();
	}


	@Override
	public void setLife(int l) {
		checkInvariant();
		super.setLife(l);
		checkInvariant();

		//post : getLife()==l
		if(getLife()!=l)
			throw new PostConditionError("Error PostCondition: getLife()!=l");
	}


	@Override
	public void crouch() {
		checkInvariant();
		super.crouch();
		checkInvariant();

		// post: getRectangleHitbox().getHeight == InformationsCharacter.getHeightSpritePersoCrouch(getNumeroCharacter())
		if(this.getRectangleHitbox().getHeight()!= InformationsCharacter.getHeightSpritePersoCrouch(getNumeroCharacter()))
			throw new PostConditionError("Error PostCondition:getRectangleHitbox().getHeight != InformationsCharacter.getHeightSpritePersoCrouch(getNumeroCharacter())");

		// post: getRectangleHitbox().getWidth == InformationsCharacter.getWidthSpritePersoCrouch(getNumeroCharacter)
		if(this.getRectangleHitbox().getWidth()!= InformationsCharacter.getWidthSpritePersoCrouch(getNumeroCharacter()))
			throw new PostConditionError("Error PostCondition:getRectangleHitbox().getWidth != InformationsCharacter.getWidthSpritePersoCrouch(getNumeroCharacter())");
	}

	@Override
	public void setDead(boolean d) {
		checkInvariant();
		super.setDead(d);
		checkInvariant();
		
		// post: isDead = d
		if(isDead()!= d)
			throw new PostConditionError("Error PostCondition: isDead != d");
	}


	@Override
	public int getLife(){return super.getLife();}
	@Override
	public int getPositionX(){return super.getPositionX();}
	@Override
	public int getPositionY(){return super.getPositionY();}
	@Override
	public EngineService getEngine(){return super.getEngine();}
	@Override
	public int getSpeed(){return super.getSpeed();}
	@Override
	public RectangleHitboxService getRectangleHitbox() {return super.getRectangleHitbox();}
	@Override
	public int getNumeroCharacter() {return super.getNumeroCharacter();}
	@Override
	public boolean isFaceRight(){return super.isFaceRight();}
	@Override
	public boolean isDead(){return super.isDead();}



}
