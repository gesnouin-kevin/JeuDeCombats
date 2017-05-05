package test;

import implementation.EngineImpl;
import test.abstracts.AbstractEngineTest;

public class EngineTest extends AbstractEngineTest{

	@Override
	public void beforeTests() {
		EngineImpl engine = new EngineImpl();
		this.setEngine(engine);
	}

}
