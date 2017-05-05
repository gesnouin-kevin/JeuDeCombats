package test.abstracts;

import static org.junit.Assert.*;

import org.junit.*;

import contract.RectangleHitboxContract;
import implementation.EngineImpl;
import implementation.FightCharImpl;
import implementation.PlayerImpl;
import implementation.RectangleHitboxImpl;
import personnages.InformationsCharacter;
import service.FightCharService;

public abstract class AbstractFightCharTest {

	private FightCharService fightchar;

	public AbstractFightCharTest(){
		this.fightchar=null;
	}
	
	public FightCharService getFightchar() {
		return fightchar;
	}

	public void setFightchar(FightCharService fightchar) {
		this.fightchar = fightchar;
	}
	
	@Before
	public abstract void beforeTests(); 

	@After
	public final void afterTests() {
		fightchar=null;
	}
	
	@Test
	public void testInit(){
		fightchar = new FightCharImpl();
		
		fightchar.init(100,5, true, 2);
		
		assertEquals("vie du character : 100",100,fightchar.getLife());
		assertEquals("vitesse de 5",5,fightchar.getSpeed());
		assertEquals("face right true",true,fightchar.isFaceRight());
	}
	
	@Test
	public void testPunch(){
		fightchar = new FightCharImpl();
		
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		
		engine.getPlayer(0).getFightCharacter().init(100, 5, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(100);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		engine.getPlayer(0).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		
		engine.getPlayer(1).getFightCharacter().punch();
		
		assertEquals("height de coupbox",InformationsCharacter.getHeightSpritePersoArm(0),engine.getPlayer(1).getFightCharacter().getCoupBox().getHeight());
		assertEquals("width de coupbox",InformationsCharacter.getWidthSpritePersoArm(0),engine.getPlayer(1).getFightCharacter().getCoupBox().getWidth());
		assertEquals("posX de coupbox",engine.getPlayer(1).getFightCharacter().getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(0)-InformationsCharacter.getPosXSpritePersoArm(0)-InformationsCharacter.getWidthSpritePersoArm(0),
				engine.getPlayer(1).getFightCharacter().getCoupBox().getPosX());
		
		assertEquals("posY de coupbox",engine.getPlayer(1).getFightCharacter().getPositionY()+InformationsCharacter.getPosYSpritePersoArm(0)-InformationsCharacter.getHeightSpritePersoArm(0),
				engine.getPlayer(1).getFightCharacter().getCoupBox().getPosY());
		
		assertEquals("vie du character : 100",100,engine.getPlayer(1).getFightCharacter().getLife());
		assertEquals("vitesse de 5",5,engine.getPlayer(1).getFightCharacter().getSpeed());
		assertEquals("face right false",false,engine.getPlayer(1).getFightCharacter().isFaceRight());
	}
	
	@Test
	public void testKick(){
		fightchar = new FightCharImpl();
		
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		
		engine.getPlayer(0).getFightCharacter().init(100, 5, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(100);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		engine.getPlayer(0).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		
		engine.getPlayer(1).getFightCharacter().kick();		
		
		assertEquals("height de coupbox",InformationsCharacter.getHeightSpritePersoFoot(0),engine.getPlayer(1).getFightCharacter().getCoupBox().getHeight());
		assertEquals("width de coupbox",InformationsCharacter.getWidthSpritePersoFoot(0),engine.getPlayer(1).getFightCharacter().getCoupBox().getWidth());
		assertEquals("posX de coupbox",engine.getPlayer(1).getFightCharacter().getPositionX()+InformationsCharacter.getWidthSpritePersoIdle(0)-InformationsCharacter.getPosXSpritePersoFoot(0)-InformationsCharacter.getWidthSpritePersoFoot(0),
				engine.getPlayer(1).getFightCharacter().getCoupBox().getPosX());
		
		assertEquals("posY de coupbox",engine.getPlayer(1).getFightCharacter().getPositionY()+InformationsCharacter.getPosYSpritePersoFoot(0)-InformationsCharacter.getHeightSpritePersoFoot(0),
				engine.getPlayer(1).getFightCharacter().getCoupBox().getPosY());
		
		assertEquals("vie du character : 100",100,engine.getPlayer(1).getFightCharacter().getLife());
		assertEquals("vitesse de 5",5,engine.getPlayer(1).getFightCharacter().getSpeed());
		assertEquals("face right false",false,engine.getPlayer(1).getFightCharacter().isFaceRight());

	}
	
	@Test
	public void testBlock(){
		fightchar = new FightCharImpl();
		
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		
		engine.getPlayer(0).getFightCharacter().init(100, 5, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(100);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		engine.getPlayer(0).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		
		engine.getPlayer(1).getFightCharacter().block();
		
		/*Après le block la position revient par défaut*/
		
		assertEquals("height rectanglehitbox",200,engine.getPlayer(1).getFightCharacter().getCoupBox().getHeight());
		assertEquals("width rectanglehitbox",100,engine.getPlayer(1).getFightCharacter().getCoupBox().getWidth());
		
		assertEquals("vie du character : 100",100,engine.getPlayer(1).getFightCharacter().getLife());
		assertEquals("vitesse de 5",5,engine.getPlayer(1).getFightCharacter().getSpeed());
		assertEquals("face right false",false,engine.getPlayer(1).getFightCharacter().isFaceRight());

	}
	
	@Test
	public void testDead(){
		fightchar = new FightCharImpl();
		
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		
		engine.getPlayer(0).getFightCharacter().init(100, 5, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(100);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		engine.getPlayer(0).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getCoupBox().init(5, 0, 100, 200);
		

		engine.getPlayer(1).getFightCharacter().dead();
		
		assertEquals("vie du character : 100",100,engine.getPlayer(1).getFightCharacter().getLife());
		assertEquals("vitesse de 5",5,engine.getPlayer(1).getFightCharacter().getSpeed());
		assertEquals("face right false",false,engine.getPlayer(1).getFightCharacter().isFaceRight());

	}
}
