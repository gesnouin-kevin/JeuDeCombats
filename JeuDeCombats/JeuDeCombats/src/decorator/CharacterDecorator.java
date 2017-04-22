package decorator;

import service.CharacterService;
import service.Commande;
import service.EngineService;
import service.HitboxService;

public abstract class CharacterDecorator implements CharacterService {

	private CharacterService delegateCharacter;
	
	public CharacterDecorator(CharacterService cs) {
		this.delegateCharacter=cs;
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
	public HitboxService getCharBox() {
		return this.delegateCharacter.getCharBox();
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
	public void init(int l, int s, boolean f, EngineService e) {
		this.delegateCharacter.init(l, s, f, e);		
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
	public void step(Commande c) {
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

}
