package implementationBug;

import service.CharacterService;
import service.Commande;
import service.EngineService;
import service.HitboxService;

public class CharacterImplBug implements CharacterService {

	private int positionX;
	private int positionY;
	private EngineService engine;
	private HitboxService charBox;
	private int life;
	private int speed;
	private boolean faceRight;
	private boolean dead = true;
	
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
	
	//modif dead
	@Override
	public void init(int l, int s, boolean f, EngineService e) {
		this.life = l;
		this.dead = true;
		this.speed = s;
		this.faceRight = f;
		this.engine = e;
	}

	@Override
	public void moveLeft() {
		this.positionX+=this.positionX-speed;
	}

	@Override
	public void moveRight() {
		this.positionX+=this.positionX+speed;
	}

	//modif
	@Override
	public void switchSide() {
		this.faceRight = this.faceRight;
	}
	
	//modif
	@Override
	public void step(Commande c) {
		// TODO Auto-generated method stub
		
	}
	
	//modif
	public void setPositionX(int x){
		this.positionX=-x;
	}
	
	//modif
	public void setPositionY(int y){
		this.positionY=-y;
	}
	
	//modif
	public void setFaceRight(boolean fr){
		this.faceRight=!fr;
	}

}
