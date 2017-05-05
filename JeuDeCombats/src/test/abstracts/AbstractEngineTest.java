package test.abstracts;

import static org.junit.Assert.*;

import org.junit.*;

import contract.RectangleHitboxContract;
import implementation.EngineImpl;
import implementation.PlayerImpl;
import implementation.RectangleHitboxImpl;
import service.Command;
import service.EngineService;

public abstract class AbstractEngineTest {

	private EngineService engine;

	protected AbstractEngineTest(){
		this.engine=null;
	}

	protected EngineService getEngine() {
		return engine;
	}

	protected void setEngine(EngineService engine) {
		this.engine = engine;
	}


	@Before
	public abstract void beforeTests(); 

	@After
	public final void afterTests() {
		engine=null;
	}

	@Test
	public void testInitTrans(){
		engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		engine.getPlayer(0).getFightCharacter().init(100, 200, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 200, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(100);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);

		//Post-Condition
		assertEquals("height de 800",800, engine.getHeight());
		assertEquals("width de 400",400, engine.getWidth());

		assertEquals("pos x j1",100, engine.getPlayer(0).getFightCharacter().getPositionX());
		assertEquals("pos x j2",300, engine.getPlayer(1).getFightCharacter().getPositionX());
		assertEquals("pos y j1",0,engine.getPlayer(0).getFightCharacter().getPositionY());
		assertEquals("pos y j2",0,engine.getPlayer(1).getFightCharacter().getPositionY());
		assertEquals("face right j1",true,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("face right j2",false,engine.getPlayer(1).getFightCharacter().isFaceRight());
		assertEquals("pos x box j1",100,engine.getPlayer(0).getFightCharacter().getRectangleHitbox().getPositionX());
		assertEquals("pos x box j2",300,engine.getPlayer(1).getFightCharacter().getRectangleHitbox().getPositionX());
		assertEquals("pos y box j1",0,engine.getPlayer(0).getFightCharacter().getRectangleHitbox().getPositionY());
		assertEquals("pos y box j2",0,engine.getPlayer(1).getFightCharacter().getRectangleHitbox().getPositionY());

		//Post-Invariant
		assertEquals("j1 non dead donc jeu pas fini",engine.isGameOver(),engine.getPlayer(0).getFightCharacter().isDead());
		assertEquals("j2 non dead donc jeu pas fini",engine.isGameOver(),engine.getPlayer(1).getFightCharacter().isDead());
	}

	@Test
	public void testStep(){
		engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();

		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);

		engine.getPlayer(0).getFightCharacter().init(100, 200, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 200, false, 1);

		//PostCondition
		assertEquals("commande neutral",Command.NEUTRAL,engine.getCommandPlayer1());
		assertEquals("commande neutral",Command.NEUTRAL,engine.getCommandPlayer2());
		
		//Post-Invariant
		assertEquals("j1 dead donc jeu fini",engine.isGameOver(),engine.getPlayer(0).getFightCharacter().isDead());
		assertEquals("j2 dead donc jeu fini",engine.isGameOver(),engine.getPlayer(1).getFightCharacter().isDead());
	}

	@Test
	public void updateFace(){
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();

		engine = new EngineImpl();

		engine.init(800, 800, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);

		engine.getPlayer(0).getFightCharacter().init(100, 200, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 200, false, 1);

		engine.getPlayer(0).getFightCharacter().setPositionX(100);
		engine.getPlayer(1).getFightCharacter().setPositionX(400);

		engine.updateFace();

		assertEquals("face right j1 true",true,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("face right j2 false",false,engine.getPlayer(1).getFightCharacter().isFaceRight());

		//Post-Invariant
		assertEquals("j1 dead donc jeu fini",engine.isGameOver(),engine.getPlayer(0).getFightCharacter().isDead());
		assertEquals("j2 dead donc jeu fini",engine.isGameOver(),engine.getPlayer(1).getFightCharacter().isDead());
	}
}
