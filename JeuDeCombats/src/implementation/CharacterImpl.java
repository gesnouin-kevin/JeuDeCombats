package implementation;

import service.CharacterService;
import service.Command;
import service.EngineService;
import service.HitboxService;
import service.RectangleHitboxService;

public class CharacterImpl implements CharacterService {

	private int positionX;
	private int positionY;
	private EngineService engine;
	private RectangleHitboxService rectangleHitbox;
	private int life;
	private int speed;
	private boolean faceRight;
	private boolean dead;
	private int numeroPlayer;  // 0 ou 1
	private int numeroCharacter; // contient le numero de perso //0->15
	private boolean running;

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
		return this.rectangleHitbox;
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
		int otherPlayer = -1;
		
		if(this.numeroPlayer == 0)
			otherPlayer =1;
		else
			otherPlayer =0;
		
		this.positionX=this.positionX-speed;
		this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()-speed, this.rectangleHitbox.getPositionY());
		if(this.rectangleHitbox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getCharacter().getCharBox()))
		{
			this.positionX=this.positionX+speed;
			this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()+speed, this.rectangleHitbox.getPositionY());
		}
	}

@Override
public void moveRight() {
	int otherPlayer = -1;
	
	if(this.numeroPlayer == 0)
		otherPlayer =1;
	else
		otherPlayer =0;
	
	this.positionX=this.positionX+speed;
	this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()+speed, this.rectangleHitbox.getPositionY());
	if(this.rectangleHitbox.isCollidesWith(this.getEngine().getPlayer(otherPlayer).getCharacter().getCharBox()))
	{
		this.positionX=this.positionX-speed;
		this.rectangleHitbox.moveTo(this.rectangleHitbox.getPositionX()-speed, this.rectangleHitbox.getPositionY());
	}
}

@Override
public void switchSide() {
	this.faceRight = !this.faceRight;
}

@Override
public void step(Command c) {

	switch (c) {
	case LEFT:
		moveLeft();
		this.running = true;
		break;
	case RIGHT:
		moveRight();
		this.running = true;
		break;
	case OTHERPLAYER:
		//do nothing
		break;
		
	case UP:
		
		break;
	case NEUTRAL:
		this.running = false;
		break;
	default:
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

@Override
public void init(int l, int s, boolean f, int numeroPlayer) {
	this.life = l;
	this.dead = false;
	this.speed = s;
	this.faceRight = f;
	this.numeroPlayer = numeroPlayer;
}

public int getNumeroPlayer() {
	return numeroPlayer;
}

public void setNumeroPlayer(int numeroPlayer) {
	this.numeroPlayer = numeroPlayer;
}

public void setRectangleHitboxService(RectangleHitboxService rectangleHitbox)
{
	this.rectangleHitbox = rectangleHitbox;
}

public RectangleHitboxService getRectangleHitboxService()
{
	return this.rectangleHitbox;
}

public int getNumeroCharacter() {
	return numeroCharacter;
}

public void setNumeroCharacter(int numeroCharacter) {
	this.numeroCharacter = numeroCharacter;
}

@Override
public boolean isRunning() {
	return this.running;
}

}
