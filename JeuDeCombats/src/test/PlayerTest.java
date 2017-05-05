package test;

import implementation.PlayerImpl;
import test.abstracts.AbstractPlayerTest;

public class PlayerTest extends AbstractPlayerTest{

	@Override
	public void beforeTests() {
		PlayerImpl player1 = new PlayerImpl();
		PlayerImpl player2 = new PlayerImpl();
		this.setPlayer(player1,player2);
	}

	
}
