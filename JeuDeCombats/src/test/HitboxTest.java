package test;

import implementation.HitboxImpl;
import test.abstracts.AbstractHitboxTest;

public class HitboxTest extends AbstractHitboxTest{

	@Override
	public void beforeTests() {
		HitboxImpl hitbox = new HitboxImpl();
		this.setHitbox(hitbox);
	}

	
}
