package implementation;

import service.CharacterService;
import service.Commande;
import service.EngineService;
import service.HitboxService;

public class CharacterImpl implements CharacterService {

	private int positionX;
	private int positionY;
	private EngineService engine;
	private HitboxService charBox;
	private int life;
	private int speed;
	private boolean faceRight;
	private boolean dead;
	
	@Override
	public int getPositionX() {
		return this.positionX;
	}

	@Override
	public int getPositionY() {
		return this.positionY;
	}

	@Override
	public EngineService getEngine() {
		return this.engine;
	}

	@Override
	public HitboxService getCharBox() {
		return this.charBox;
	}

	@Override
	public int getLife() {
		return this.life;
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public boolean isFaceRight() {
		return this.faceRight;
	}

	@Override
	public boolean isDead() {
		return this.dead;
	}

	@Override
	public void init(int l, int s, boolean f) {
		this.life = l;
		this.dead = false;
		this.speed = s;
		this.faceRight = f;
	}

	@Override
	public void moveLeft() {
		this.positionX=this.positionX-speed;
	}

	@Override
	public void moveRight() {
		this.positionX=this.positionX+speed;
	}

	@Override
	public void switchSide() {
		this.faceRight = !this.faceRight;
	}

	@Override
	public void step(Commande c) {

		switch (c) {
		case LEFT:
				this.moveLeft();
			break;
		case RIGHT:
			    this.moveRight();
			break;
		case NEUTRAL:
			//do nothing
			break;
		}
		
		
	}
	
	public void setPositionX(int x){
		this.positionX=x;
	}
	
	public void setPositionY(int y){
		this.positionY=y;
	}
	
	public void setFaceRight(boolean fr){
		this.faceRight=fr;
	}

	@Override
	public void init(EngineService es) {
		this.engine = es;
		
	}

}
