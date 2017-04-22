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

	/**
	 * A demander w//2 etc ...
	 * */
	
	public void checkInvariant(){
		//inv:  isGameOver() == \exist i in {1,2} Character::getChar(i).isDead()
		if(!(isGameOver()== getChar(1).isDead() || isGameOver()== getChar(2).isDead()))
			throw new InvariantError("Error checkInvariant : isGameOver() with isDead()");
	}
	
	public void step(Commande c1, Commande c2){
		// pre: not isGameOver()
		if(isGameOver())
			throw new PreConditionError("Error Precondition : isGameOver()");
		
		checkInvariant();
		
		CharacterService getChar1_atPre = getChar(1);
		CharacterService getChar2_atPre = getChar(2);
		super.step(c1, c2);
		
		checkInvariant();
		
		//post: getChar(1) == getChar(1)@Pre.step(C1)
		getChar1_atPre.step(c1);
		if(!(getChar(1)==getChar1_atPre))
			throw new PostConditionError("Error PostCondition : getChar(1)==getChar(1)@Pre.step(C1) ");
			
		//post: getChar(2) == getChar(2)@Pre.step(C2)
		getChar2_atPre.step(c2);
		if(!(getChar(2)==getChar2_atPre))
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
		if(!(getChar(1).getPositionX()== w/2 - s/2))
			throw new PostConditionError("Error PostCondition: getChar(1).getPositionX()== w/2 - s/2");
		
		// post: Character::getPositionX(), char(2).getPositionX() == w//2 + s//2
		if(!(getChar(2).getPositionX()== w/2 + s/2))
			throw new PostConditionError("Error PostCondition: getChar(2).getPositionX()== w/2 + s/2");
		
		// post: Character::getPositionY(), char(1).getPositionY() == 0
		if(!(getChar(1).getPositionY()==0))
			throw new PostConditionError("Error PostCondition: getChar(1).getPositionY()==0");
		
		// post: Character::getPositionY(), char(2).getPositionY() == 0
		if(!(getChar(2).getPositionY()==0))
			throw new PostConditionError("Error PostCondition: getChar(2).getPositionY()==0");
		
		// post: Character::isFaceRight(), char(1).isFaceRight()
		if(!(getChar(1).isFaceRight()))
			throw new PostConditionError("Error PostCondition: getChar(1).isFaceRight()");
		
		// post: Character::isFaceRight(), not char(2).isFaceRight()
		if(!(getChar(2).isFaceRight()))
			throw new PostConditionError("Error PostCondition: getChar(2).isFaceRight()");
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public CharacterService getChar(int i) {
		// TODO Auto-generated method stub
		return super.getChar(i);
	}

	@Override
	public PlayerService getPlayer(int i) {
		// TODO Auto-generated method stub
		return super.getPlayer(i);
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return super.isGameOver();
	}
	
	

}
