package test;

import implementation.FightCharImpl;
import test.abstracts.AbstractFightCharTest;

public class FightCharTest extends AbstractFightCharTest{

	@Override
	public void beforeTests() {
		FightCharImpl fightChar = new FightCharImpl();
		this.setFightchar(fightChar);
	}

}
