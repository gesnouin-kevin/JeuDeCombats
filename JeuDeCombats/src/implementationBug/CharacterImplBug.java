package implementationBug;

import service.CharacterService;
import service.Commande;
import service.EngineService;
import service.HitboxService;
import service.RectangleHitboxService;

public class CharacterImplBug implements CharacterService {

	private int positionX;
	private int positionY;
	private EngineService engine;
	private RectangleHitboxService charBox;
	private int life;
	private int speed;
	private boolean faceRight;
	private boolean dead;
	private int numeroPlayer;
	
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
	public RectangleHitboxService getCharBox() {
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
	public void moveLeft() {
		this.positionX+=this.positionX-speed;
	}

	@Override
	public void moveRight() {
		this.positionX+=this.positionX+speed;
	}

	@Override
	public void switchSide() {
		this.faceRight = !this.faceRight;
	}
	
	//modif
	@Override
	public void step(Commande c) {
		
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

	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {
		this.life = l;
		this.dead = false;
		this.speed = s;
		this.faceRight = f;
		this.numeroPlayer = numeroPlayer;
		
	}

	@Override
	public int getNumeroPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNumeroPlayer(int numeroPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRectangleHitboxService(RectangleHitboxService rectangleHitbox) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RectangleHitboxService getRectangleHitboxService() {
		// TODO Auto-generated method stub
		return null;
	}

}
