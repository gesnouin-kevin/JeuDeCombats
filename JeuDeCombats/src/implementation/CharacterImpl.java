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
	private int numeroPlayer;
	private int numeroCharacter;
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
		// test collision avec autre player
		int otherPlayer;
		if(this.numeroPlayer == 1)
			otherPlayer =0;
		else
			otherPlayer =1;
		// PRobleme ne voit pas les bonnes coordonnees
		System.out.println("playerCourant:"+this.numeroPlayer);
		System.out.println("posX: "+this.positionX);
		System.out.println("autrePosx"+this.engine.getPlayer(otherPlayer).getCharacter().getRectangleHitboxService().getPositionX());

		if(this.positionX-speed*4<this.engine.getPlayer(otherPlayer).getCharacter().getRectangleHitboxService().getPositionX() || this.positionX-speed*4 >
		  this.engine.getPlayer(otherPlayer).getCharacter().getRectangleHitboxService().getPositionX()+this.engine.getPlayer(otherPlayer).getCharacter().getRectangleHitboxService().getWidth())
		{
			this.positionX=this.positionX-speed*4;
			this.getCharBox().setPosX(this.getCharBox().getPositionX()-speed*4);
		}
	}

@Override
public void moveRight() {
	this.positionX=this.positionX+speed*4;
	this.getCharBox().setPosX(this.getCharBox().getPositionX()+speed*4);
}

@Override
public void switchSide() {
	this.faceRight = !this.faceRight;
}

@Override
public void step(Command c) {

	switch (c) {
	case LEFT:
		this.moveLeft();
		this.running = true;
		break;
	case RIGHT:
		this.moveRight();
		this.running = true;
		break;
	case OTHERPLAYER:
		//do nothing
		break;
	case NEUTRAL:
		this.running = false;
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
