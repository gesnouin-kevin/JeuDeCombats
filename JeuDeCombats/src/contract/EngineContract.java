package contract;

import decorator.EngineDecorator;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;
import service.CharacterService;
import service.Commande;
import service.EngineService;
import service.PlayerService;

public class EngineContract extends EngineDecorator{

	public EngineContract(EngineService es) {
		super(es);
	}

	public void checkInvariant(){
		//inv:  isGameOver() == \exist i in {1,2} Character::getChar(i).isDead()
		if(!(isGameOver()== getPlayer(1).getCharacter().isDead() || isGameOver()== getPlayer(2).getCharacter().isDead()))
			throw new InvariantError("Error checkInvariant : isGameOver() with isDead()");
	}
	
	public void step(Commande c1, Commande c2){
		// pre: not isGameOver()
		if(isGameOver())
			throw new PreConditionError("Error Precondition : isGameOver()");
		
		checkInvariant();
		
		CharacterService getChar1_atPre = getPlayer(1).getCharacter();
		CharacterService getChar2_atPre = getPlayer(2).getCharacter();
		super.step(c1, c2);
		
		checkInvariant();
		
		//post: getChar(1) == getChar(1)@Pre.step(C1)
		getChar1_atPre.step(c1);
		if(!(getPlayer(1).getCharacter()==getChar1_atPre))
			throw new PostConditionError("Error PostCondition : getChar(1)==getChar(1)@Pre.step(C1) ");
			
		//post: getChar(2) == getChar(2)@Pre.step(C2)
		getChar2_atPre.step(c2);
		if(!(getPlayer(2).getCharacter()==getChar2_atPre))
			throw new PostConditionError("Error PostCondition : getChar(2)==getChar(2)@Pre.step(C2) ");
	}
	
	public void init(int h, int w, int s, PlayerService p1, PlayerService p2){
		
		// pre: h >= 0
		if(!(h>=0))
			throw new PreConditionError("Error PreCondition: h>=0");
		
		// pre: s >= 0
		if(!(w>=0))
			throw new PreConditionError("Error PreCondition: w>=0");
		
		// pre: w >= s
		if(!(w>=s))
			throw new PreConditionError("Error PreCondition: w>=s");
		
		// pre:  p1 != p2
		if(!(p1!=p2))
			throw new PreConditionError("Error PreCondition: p1!=p2");
		
		checkInvariant();

		
		super.init(h, w, s, p1, p2);
		
		checkInvariant();
		
		
		// post: getHeight() == h
		if(!(getHeight()==h))
			throw new PostConditionError("Error PostCondition : getHeight != h");
		
		// post: getWidth() == w
		if(!(getWidth()==w))
			throw new PostConditionError("Error PostCondition : getWidth != w");
		
		// post: getPlayer(1) == p1
		if(!(getPlayer(1)==p1))
			throw new PostConditionError("Error PostCondition : getPlayer(1)");
		
		// post: getPlayer(2) == p2
		if(!(getPlayer(2)==p2))
			throw new PostConditionError("Error PostCondition : getPlayer(2)");
		
		// post: Character::getPositionX(), char(1).getPositionX() == w//2 - s//2
		if(!(getPlayer(1).getCharacter().getPositionX()== (int) w/2 - (int) s/2))
			throw new PostConditionError("Error PostCondition: getChar(1).getPositionX()== w/2 - s/2");
		
		// post: Character::getPositionX(), char(2).getPositionX() == w//2 + s//2
		if(!(getPlayer(2).getCharacter().getPositionX()== (int) w/2 + (int) s/2))
			throw new PostConditionError("Error PostCondition: getChar(2).getPositionX()== w/2 + s/2");
		
		// post: Character::getPositionY(), char(1).getPositionY() == 0
		if(!(getPlayer(1).getCharacter().getPositionY()==0))
			throw new PostConditionError("Error PostCondition: getChar(1).getPositionY()==0");
		
		// post: Character::getPositionY(), char(2).getPositionY() == 0
		if(!(getPlayer(2).getCharacter().getPositionY()==0))
			throw new PostConditionError("Error PostCondition: getChar(2).getPositionY()==0");
		
		// post: Character::isFaceRight(), char(1).isFaceRight()
		if(!(getPlayer(1).getCharacter().isFaceRight()))
			throw new PostConditionError("Error PostCondition: getChar(1).isFaceRight()");
		
		// post: Character::isFaceRight(), not char(2).isFaceRight()
		if(!(getPlayer(2).getCharacter().isFaceRight()))
			throw new PostConditionError("Error PostCondition: getChar(2).isFaceRight()");
	}

	@Override
	public int getHeight() {
		return super.getHeight();
	}

	@Override
	public int getWidth() {
		return super.getWidth();
	}

	@Override
	public PlayerService getPlayer(int i) {
		return super.getPlayer(i);
	}

	@Override
	public boolean isGameOver() {
		return super.isGameOver();
	}
	
	

}
