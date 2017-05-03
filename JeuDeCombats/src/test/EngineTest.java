package test;

import implementation.EngineImpl;

public class EngineTest extends AbstractEngineTest{

	@Override
	public void beforeTests() {
		EngineImpl engine = new EngineImpl();
		this.setEngine(engine);
	}

}
