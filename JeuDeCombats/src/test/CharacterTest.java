package test;

import implementation.CharacterImpl;
import test.abstracts.AbstractCharacterTest;

public class CharacterTest extends AbstractCharacterTest{

	@Override
	public void beforeTests() {
		CharacterImpl character = new CharacterImpl();
		this.setCharacter(character);
	}

}
