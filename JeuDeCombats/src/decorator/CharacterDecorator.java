package decorator;

import service.CharacterService;
import service.Command;
import service.EngineService;
import service.HitboxService;
import service.RectangleHitboxService;

public abstract class CharacterDecorator implements CharacterService {

	private CharacterService delegateCharacter;
	
	public CharacterDecorator(CharacterService cs) {
		this.delegateCharacter=cs;
	}
	
	protected CharacterService getDelegate() {
		return delegateCharacter;
	}
	
	@Override
	public int getPositionX() {
		return this.delegateCharacter.getPositionX();
	}

	@Override
	public int getPositionY() {
		return this.delegateCharacter.getPositionY();
	}

	@Override
	public EngineService getEngine() {
		return this.delegateCharacter.getEngine();
	}

	@Override
	public int getLife() {
		return this.delegateCharacter.getLife();
	}

	@Override
	public int getSpeed() {
		return this.delegateCharacter.getSpeed();
	}

	@Override
	public boolean isFaceRight() {
		return this.delegateCharacter.isFaceRight();
	}

	@Override
	public boolean isDead() {
		return this.delegateCharacter.isDead();
	}

	@Override
	public void init(int l, int s, boolean f, int numeroPlayer) {
		this.delegateCharacter.init(l, s, f, numeroPlayer);		
	}
	
	@Override
	public void init(EngineService es) {
		this.delegateCharacter.init(es);		
	}

	@Override
	public void moveLeft() {
		this.delegateCharacter.moveLeft();		
	}

	@Override
	public void moveRight() {
		this.delegateCharacter.moveRight();		
	}

	@Override
	public void switchSide() {
		this.delegateCharacter.switchSide();		
	}

	@Override
	public void step(Command c) {
		this.delegateCharacter.step(c);		
	}

	@Override
	public void setPositionX(int i) {
		this.delegateCharacter.setPositionX(i);
	}

	@Override
	public void setPositionY(int i) {
		this.delegateCharacter.setPositionY(i);
	}

	@Override
	public void setFaceRight(boolean b) {
		this.delegateCharacter.setFaceRight(b);
	}

	@Override
	public int getNumeroPlayer() {
		return this.delegateCharacter.getNumeroPlayer();
	}

	@Override
	public void setNumeroPlayer(int numeroPlayer) {
		this.delegateCharacter.setNumeroPlayer(numeroPlayer);
	}

	@Override
	public void setRectangleHitboxService(RectangleHitboxService rectangleHitbox) {
		this.delegateCharacter.setRectangleHitboxService(rectangleHitbox);}

	@Override
	public RectangleHitboxService getRectangleHitbox() {
		return this.delegateCharacter.getRectangleHitbox();
	}

	@Override
	public int getNumeroCharacter() {
		return this.delegateCharacter.getNumeroCharacter();
	}

	@Override
	public void setNumeroCharacter(int numeroCharacter) {
		this.delegateCharacter.setNumeroCharacter(numeroCharacter);
		
	}

	@Override
	public boolean isRunning() {
		return this.delegateCharacter.isRunning();
	}

	@Override
	public boolean isCrouching() {
		return this.delegateCharacter.isCrouching();
	}

	@Override
	public void moveDown() {
		this.delegateCharacter.moveDown();
	}

	@Override
	public boolean isJumping() {
		return this.delegateCharacter.isJumping();
	}

	@Override
	public void moveUp() {
		this.delegateCharacter.moveUp();
	}

	@Override
	public void neutral() {
		this.delegateCharacter.neutral();
		
	}

	@Override
	public void updateY() {
		this.delegateCharacter.updateY();
	}

	@Override
	public void setLife(int l) {
		this.delegateCharacter.setLife(l);
	}

	@Override
	public void setDead(boolean d) {
		this.delegateCharacter.setDead(d);
	}

	@Override
	public void crouch() {
		this.delegateCharacter.crouch();
		
	}

	
	
}
