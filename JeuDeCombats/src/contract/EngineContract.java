package contract;

import decorator.EngineDecorator;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;
import service.CharacterService;
import service.Command;
import service.EngineService;
import service.PlayerService;

public class EngineContract extends EngineDecorator{

	public EngineContract(EngineService es) {
		super(es);
	}

	public void checkInvariant(){
		//inv:  isGameOver() == \exist i in {1,2} Character::getChar(i).isDead()
		if(!(isGameOver()== getPlayer(0).getFightCharacter().isDead() || isGameOver()== getPlayer(1).getFightCharacter().isDead()))
			throw new InvariantError("Error checkInvariant : isGameOver() with isDead()");
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

		super.init(h, w, s, p1, p2);

		// post: getHeight() == h
		if(!(getHeight()==h))
			throw new PostConditionError("Error PostCondition : getHeight != h");

		// post: getWidth() == w
		if(!(getWidth()==w))
			throw new PostConditionError("Error PostCondition : getWidth != w");

		// post: Character::getPositionX(), char(0).getPositionX() == w//2 - s//2
		if(!(getPlayer(0).getFightCharacter().getPositionX()== (int) w/2 - (int) s/2))
			throw new PostConditionError("Error PostCondition: getChar(0).getPositionX()== w/2 - s/2");

		// post: Character::getPositionX(), char(1).getPositionX() == w//2 + s//2
		if(!(getPlayer(1).getFightCharacter().getPositionX()== (int) w/2 + (int) s/2))
			throw new PostConditionError("Error PostCondition: getChar(1).getPositionX()== w/2 + s/2");

		// post: Character::getPositionY(), char(1).getPositionY() == 0
		if(!(getPlayer(0).getFightCharacter().getPositionY()==0))
			throw new PostConditionError("Error PostCondition: getChar(0).getPositionY()==0");

		// post: Character::getPositionY(), char(2).getPositionY() == 0
		if(!(getPlayer(1).getFightCharacter().getPositionY()==0))
			throw new PostConditionError("Error PostCondition: getChar(1).getPositionY()==0");

		// post: Character::isFaceRight(), char(0).isFaceRight()
		if(!(getPlayer(0).getFightCharacter().isFaceRight()))
			throw new PostConditionError("Error PostCondition: getChar(0).isFaceRight()");

		// post: Character::isFaceRight(), not char(1).isFaceRight()
		if((getPlayer(1).getFightCharacter().isFaceRight()))
			throw new PostConditionError("Error PostCondition: getChar(1).isFaceRight()");
	}


	public void step(){
		checkInvariant();
		super.step();
		checkInvariant();

		// post: getCommandPlayer1 = Command.NEUTRAL
		if(getCommandPlayer1() != Command.NEUTRAL)
			throw new PostConditionError("Error PostCondition: getCommandPlayer1() == Command.NEUTRAL");

		//  post: getCommandPlayer2 = Command.NEUTRAL
		if(getCommandPlayer2() != Command.NEUTRAL)
			throw new PostConditionError("Error PostCondition: getCommandPlayer2() == Command.NEUTRAL");
	}
	
	@Override
	public void updateFace() {
		checkInvariant();
		super.updateFace();
		checkInvariant();

		// post: getPlayer(Math.max(getPlayer(0).getPosX(), getPlayer(1).getPosX()).getNumeroPlayer()).isFaceRight() == false
		// post: getPlayer(Math.min(getPlayer(0).getPosX(), getPlayer(1).getPosX()).getNumeroPlayer()).isFaceRight() == true
		if(getPlayer(0).getFightCharacter().getPositionX()>getPlayer(1).getFightCharacter().getPositionX())
		{
			if(getPlayer(0).getFightCharacter().isFaceRight())
				throw new PostConditionError("Error PostCondition: getPlayer(0).getCharacter().isFaceRight()");
			if(!getPlayer(1).getFightCharacter().isFaceRight())
				throw new PostConditionError("Error PostCondition: !getPlayer(1).getCharacter().isFaceRight()");
		}
		else 
		{
			if(!getPlayer(0).getFightCharacter().isFaceRight())
				throw new PostConditionError("Error PostCondition: getPlayer(0).getCharacter().isFaceRight()");
			if(getPlayer(1).getFightCharacter().isFaceRight())
				throw new PostConditionError("Error PostCondition: getPlayer(1).getCharacter().isFaceRight()");
		}
	}

	@Override
	public void setCommandPlayer1(Command commandPlayer1) {
		//pre: commandplayer1 in Command
		if(!(commandPlayer1==Command.LEFT_PRESSED || commandPlayer1==Command.LEFT_RELEASED || commandPlayer1==Command.RIGHT_PRESSED || commandPlayer1==Command.RIGHT_RELEASED 
				|| commandPlayer1==Command.UP || commandPlayer1==Command.DOWN_PRESSED || commandPlayer1==Command.DOWN_RELEASED
				|| commandPlayer1==Command.BLOCK_PRESSED || commandPlayer1==Command.BLOCK_RELEASED || commandPlayer1==Command.PUNCH || commandPlayer1==Command.KICK
				|| commandPlayer1==Command.NEUTRAL
				))
			throw new PreConditionError("Error PreCondition: commandPlayer1 doesn't exist in Command");

		checkInvariant();
		super.setCommandPlayer1(commandPlayer1);
		checkInvariant();

		//post: getCommandPlayer1() == commandPlayer1
		if(getCommandPlayer1()!=commandPlayer1)
			throw new PreConditionError("Error PreCondition: commandPlayer1 doesn't modified");
	}

	@Override
	public void setCommandPlayer2(Command commandPlayer2) {
		//pre: commandplayer2 in Command
		if(!(commandPlayer2==Command.LEFT_PRESSED || commandPlayer2==Command.LEFT_RELEASED || commandPlayer2==Command.RIGHT_PRESSED || commandPlayer2==Command.RIGHT_RELEASED 
				|| commandPlayer2==Command.UP || commandPlayer2==Command.DOWN_PRESSED || commandPlayer2==Command.DOWN_RELEASED
				|| commandPlayer2==Command.BLOCK_PRESSED || commandPlayer2==Command.BLOCK_RELEASED || commandPlayer2==Command.PUNCH || commandPlayer2==Command.KICK
				|| commandPlayer2==Command.NEUTRAL
				))
			throw new PreConditionError("Error PreCondition: commandPlayer2 doesn't exist in Command");

		checkInvariant();
		super.setCommandPlayer2(commandPlayer2);
		checkInvariant();

		//post: getCommandPlayer2() == commandPlayer2
		if(getCommandPlayer2()!=commandPlayer2)
			throw new PreConditionError("Error PreCondition: commandPlayer2 doesn't modified");
	}

	@Override
	public Command getCommandPlayer1() { return super.getCommandPlayer1();}
	@Override
	public Command getCommandPlayer2() { return super.getCommandPlayer2();}
	@Override
	public int getHeight() { return super.getHeight(); }
	@Override
	public int getWidth() { return super.getWidth();}
	@Override
	public PlayerService getPlayer(int i) { return super.getPlayer(i); }
	@Override
	public boolean isGameOver() { return super.isGameOver();}



}
