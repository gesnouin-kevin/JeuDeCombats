package implementation;

import personnages.InformationsCharacter;
import service.CharacterService;
import service.Command;
import service.EngineService;
import service.HitboxService;
import service.RectangleHitboxService;

public class CharacterImpl implements CharacterService {
	private EngineService engine;
	private RectangleHitboxService rectangleHitbox;
	private int positionX;
	private int positionY;
	private int positionXforJump;
	private int life;
	private int speed;
	private boolean faceRight;
	private boolean dead;
	private int numeroPlayer;
	private int numeroCharacter;
	private boolean running;
	private boolean crouching;
	private boolean jumping;

	@Override
	public void init(EngineService es) {
		this.engine = es;
	}

	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {
		this.life = l;
		this.dead = false;
		this.running = false;
		this.crouching = false;
		this.jumping = false;
		this.speed = s;
		this.faceRight = f;
		this.numeroPlayer = numeroPlayer;
		this.positionXforJump = -50;
	}

	@Override
	public void moveLeft() {
		int otherPlayer = 0;

		if(this.numeroPlayer == 0)
			otherPlayer =1;

		this.positionX=this.positionX-speed;
		this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()-speed, this.rectangleHitbox.getPositionY());
		if(this.rectangleHitbox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getRectangleHitbox()) && !this.jumping){
			this.positionX=this.positionX+speed;
			this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()+speed, this.rectangleHitbox.getPositionY());
		}

		if(this.rectangleHitbox.getPositionX()<=0){
			this.positionX=0;
			this.rectangleHitbox.moveTo(0, this.rectangleHitbox.getPositionY());
		}
	}

	@Override
	public void moveRight() {
		int otherPlayer = 0;

		if(this.numeroPlayer == 0)
			otherPlayer =1;

		this.positionX=this.positionX+speed;
		this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()+speed, this.rectangleHitbox.getPositionY());
		if(this.rectangleHitbox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getFightCharacter().getRectangleHitbox()) && !this.jumping){
			this.positionX=this.positionX-speed;
			this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()-speed, this.rectangleHitbox.getPositionY());
		}

		if(this.rectangleHitbox.getPositionX()>=this.engine.getWidth()-this.rectangleHitbox.getWidth()){
			this.positionX=this.engine.getWidth()-this.rectangleHitbox.getWidth();
			this.rectangleHitbox.moveTo(this.engine.getWidth()-this.rectangleHitbox.getWidth(), this.rectangleHitbox.getPositionY());
		}
	}

	@Override
	public void moveDown() {
		this.rectangleHitbox.setHeight(InformationsCharacter.getHeightSpritePersoCrouch(this.numeroCharacter));
		this.rectangleHitbox.setWidth(InformationsCharacter.getWidthSpritePersoCrouch(this.numeroCharacter));
	}

	@Override
	public void moveUp() {
		this.rectangleHitbox.setHeight(InformationsCharacter.getHeightSpritePersoJump(this.numeroCharacter));
		this.rectangleHitbox.setWidth(InformationsCharacter.getWidthSpritePersoJump(this.numeroCharacter));
	}


	@Override
	public void switchSide() {
		this.faceRight = !this.faceRight;
	}

	@Override
	public void step(Command c) {
		switch (c) {
		case LEFT_PRESSED:
			moveLeft();
			if(!this.jumping)
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(1);
			this.running = true;
			break;

		case LEFT_RELEASED:
			this.running = false;
			neutral();
			if(!this.jumping)
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(0);
			break;

		case RIGHT_PRESSED:
			moveRight();
			if(!this.jumping)
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(1);
			this.running = true;
			break;

		case RIGHT_RELEASED:
			this.running = false;
			neutral();
			if(!this.jumping)
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(0);
			break;

		case DOWN_PRESSED:
			this.crouching = true;
			crouch();
			if(!this.jumping)
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(3);
			break;

		case DOWN_RELEASED:
			this.crouching = false;
			neutral();
			if(!this.jumping)
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(0);
			break;

		case UP:
			moveUp();
			if(!this.jumping)
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(2);
			this.jumping=true;
			break;

		default:
			break;
		}
	}

	@Override
	public void neutral() {
		this.rectangleHitbox.setHeight(InformationsCharacter.getHeightSpritePersoIdle(this.numeroCharacter));
		this.rectangleHitbox.setWidth(InformationsCharacter.getWidthSpritePersoIdle(this.numeroCharacter));
	}

	@Override
	public void crouch(){
		this.rectangleHitbox.setHeight(InformationsCharacter.getHeightSpritePersoCrouch(this.numeroCharacter));
		this.rectangleHitbox.setWidth(InformationsCharacter.getWidthSpritePersoCrouch(this.numeroCharacter));
	}

	@Override
	public void updateY() {
		if(this.jumping)
		{
			this.positionXforJump ++;
			if(this.positionXforJump>=100)
				this.positionXforJump=-50;
			this.positionY = 0;
			
			this.positionY = this.positionY + (int) (-0.06*(this.positionXforJump*this.positionXforJump)+200);

			this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX(),  this.positionY);

			if(this.positionY <= 0){
				this.positionY = 0;
				this.positionXforJump = -50;
				this.jumping = false;
				this.engine.getPlayer(numeroPlayer).getAnimationPlayer().setCurrentAnimation(0);
				this.rectangleHitbox.setHeight(InformationsCharacter.getHeightSpritePersoIdle(this.numeroCharacter));
				this.rectangleHitbox.setWidth(InformationsCharacter.getWidthSpritePersoIdle(this.numeroCharacter));
			}
		}	
	}

	public CharacterImpl() {this.dead  = true;}

	@Override
	public int getPositionX() {return this.positionX;}
	@Override
	public int getPositionY() {return this.positionY;}
	@Override
	public EngineService getEngine() {return this.engine;}
	@Override
	public int getLife() {return this.life;}
	@Override
	public int getSpeed() {return this.speed;}
	@Override
	public RectangleHitboxService getRectangleHitbox() {return this.rectangleHitbox;}
	@Override
	public int getNumeroCharacter() {return numeroCharacter;}
	@Override
	public int getNumeroPlayer() {return numeroPlayer;}
	@Override
	public boolean isFaceRight() {return this.faceRight;}
	@Override
	public boolean isDead() {return this.dead;}
	@Override
	public boolean isRunning() {return this.running;}
	@Override
	public boolean isCrouching() {return this.crouching;}
	@Override
	public boolean isJumping() {return this.jumping;}

	@Override
	public void setLife(int l) {this.life = l;}
	@Override
	public void setDead(boolean d) {this.dead=d;}
	@Override
	public void setNumeroPlayer(int numeroPlayer) {this.numeroPlayer = numeroPlayer;}
	@Override
	public void setRectangleHitboxService(RectangleHitboxService rectangleHitbox) {this.rectangleHitbox = rectangleHitbox;}
	@Override
	public void setNumeroCharacter(int numeroCharacter) {this.numeroCharacter = numeroCharacter;}
	@Override
	public void setPositionX(int x) {this.positionX=x;}
	@Override
	public void setPositionY(int y){this.positionY=y;}
	@Override
	public void setFaceRight(boolean fr){this.faceRight=fr;}
}
