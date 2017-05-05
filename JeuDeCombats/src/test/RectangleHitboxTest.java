package test;

import implementation.RectangleHitboxImpl;
import test.abstracts.AbstractRectangleHitboxTest;

public class RectangleHitboxTest extends AbstractRectangleHitboxTest{

	@Override
	public void beforeTests() {
		RectangleHitboxImpl rectangleHitbox = new RectangleHitboxImpl();
		this.setRectangleHitbox(rectangleHitbox);
	}

}
