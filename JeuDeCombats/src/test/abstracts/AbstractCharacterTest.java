package test.abstracts;

import static org.junit.Assert.*;

import org.junit.*;

import contract.RectangleHitboxContract;
import implementation.CharacterImpl;
import implementation.EngineImpl;
import implementation.PlayerImpl;
import implementation.RectangleHitboxImpl;
import service.CharacterService;
import service.Command;

public abstract class AbstractCharacterTest {

	private CharacterService character;
	
	public AbstractCharacterTest(){
		this.character=null;
	}

	public CharacterService getCharacter() {
		return character;
	}

	public void setCharacter(CharacterService character) {
		this.character = character;
	}
	
	@Before
	public abstract void beforeTests(); 

	@After
	public final void afterTests() {
		character=null;
	}
	
	@Test
	public void testInit(){
		character= new CharacterImpl();
		character.init(100, 5, true, 0);
		
		assertEquals("vie du character : 100",100,character.getLife());
		assertEquals("vitesse de 5",5,character.getSpeed());
		assertEquals("face right true",true,character.isFaceRight());
		
	}
	
	@Test
	public void testMoveLeft(){
		character= new CharacterImpl();
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		engine.getPlayer(0).getFightCharacter().init(100, 5, true, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(5);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		int positionY_atPre = engine.getPlayer(0).getFightCharacter().getPositionY();
		int speed_atPre = engine.getPlayer(0).getFightCharacter().getSpeed();
		int life_atPre = engine.getPlayer(0).getFightCharacter().getLife();
		boolean faceRight_atPre = engine.getPlayer(0).getFightCharacter().isFaceRight();
		
		
		engine.getPlayer(0).getFightCharacter().moveLeft();
		
		assertEquals("vie du character : 100",life_atPre,engine.getPlayer(0).getFightCharacter().getLife());
		assertEquals("vitesse de 5",speed_atPre,engine.getPlayer(0).getFightCharacter().getSpeed());
		assertEquals("face right true",faceRight_atPre,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("position y 0",positionY_atPre,engine.getPlayer(0).getFightCharacter().getPositionY());
		assertEquals("positon x : 0",0,engine.getPlayer(0).getFightCharacter().getPositionX());
		
		assertEquals("position x>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionX()>=0);
		assertEquals("position y>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionY()>=0);
		assertEquals("position x<Engine::width",0<400,engine.getPlayer(0).getFightCharacter().getPositionX()<engine.getWidth());
		assertEquals("position y<Engine::height",0<400,engine.getPlayer(0).getFightCharacter().getPositionY()<engine.getHeight());
		
	}
	
	@Test
	public void testMoveRight(){
		character= new CharacterImpl();
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		engine.getPlayer(0).getFightCharacter().init(100, 6, false, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(6);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		int positionX_atPre = engine.getPlayer(0).getFightCharacter().getPositionX();
		int positionY_atPre = engine.getPlayer(0).getFightCharacter().getPositionY();
		int speed_atPre = engine.getPlayer(0).getFightCharacter().getSpeed();
		int life_atPre = engine.getPlayer(0).getFightCharacter().getLife();
		boolean faceRight_atPre = engine.getPlayer(0).getFightCharacter().isFaceRight();
		
		
		engine.getPlayer(0).getFightCharacter().moveRight();
		
		assertEquals("vie du character : 100",life_atPre,engine.getPlayer(0).getFightCharacter().getLife());
		assertEquals("vitesse de 6",speed_atPre,engine.getPlayer(0).getFightCharacter().getSpeed());
		assertEquals("face right true",faceRight_atPre,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("position y 0",positionY_atPre,engine.getPlayer(0).getFightCharacter().getPositionY());
		assertEquals("positon x : 12",12,engine.getPlayer(0).getFightCharacter().getPositionX());
		
		assertEquals("position x>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionX()>=0);
		assertEquals("position y>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionY()>=0);
		assertEquals("position x<Engine::width",0<400,engine.getPlayer(0).getFightCharacter().getPositionX()<engine.getWidth());
		assertEquals("position y<Engine::height",0<400,engine.getPlayer(0).getFightCharacter().getPositionY()<engine.getHeight());
	}
	
	@Test
	public void testMoveUp(){
		character= new CharacterImpl();
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		engine.getPlayer(0).getFightCharacter().init(100, 6, false, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(6);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		int positionX_atPre = engine.getPlayer(0).getFightCharacter().getPositionX();
		int positionY_atPre = engine.getPlayer(0).getFightCharacter().getPositionY();
		int speed_atPre = engine.getPlayer(0).getFightCharacter().getSpeed();
		int life_atPre = engine.getPlayer(0).getFightCharacter().getLife();
		boolean faceRight_atPre = engine.getPlayer(0).getFightCharacter().isFaceRight();
		
		
		engine.getPlayer(0).getFightCharacter().moveUp();
		
		assertEquals("vie du character : 100",life_atPre,engine.getPlayer(0).getFightCharacter().getLife());
		assertEquals("vitesse de 6",speed_atPre,engine.getPlayer(0).getFightCharacter().getSpeed());
		assertEquals("face right true",faceRight_atPre,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("position y 0",positionY_atPre,engine.getPlayer(0).getFightCharacter().getPositionY());
		assertEquals("positon x : 6",positionX_atPre,engine.getPlayer(0).getFightCharacter().getPositionX());
		
		assertEquals("position x>=0",6>=0,engine.getPlayer(0).getFightCharacter().getPositionX()>=0);
		assertEquals("position y>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionY()>=0);
		assertEquals("position x<Engine::width",0<400,engine.getPlayer(0).getFightCharacter().getPositionX()<engine.getWidth());
		assertEquals("position y<Engine::height",0<400,engine.getPlayer(0).getFightCharacter().getPositionY()<engine.getHeight());
	}
	
	@Test
	public void testMoveDown(){
		character= new CharacterImpl();
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		engine.getPlayer(0).getFightCharacter().init(100, 6, false, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(6);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		int positionX_atPre = engine.getPlayer(0).getFightCharacter().getPositionX();
		int positionY_atPre = engine.getPlayer(0).getFightCharacter().getPositionY();
		int speed_atPre = engine.getPlayer(0).getFightCharacter().getSpeed();
		int life_atPre = engine.getPlayer(0).getFightCharacter().getLife();
		boolean faceRight_atPre = engine.getPlayer(0).getFightCharacter().isFaceRight();
		
		engine.getPlayer(0).getFightCharacter().moveDown();
		
		assertEquals("vie du character : 100",life_atPre,engine.getPlayer(0).getFightCharacter().getLife());
		assertEquals("vitesse de 6",speed_atPre,engine.getPlayer(0).getFightCharacter().getSpeed());
		assertEquals("face right true",faceRight_atPre,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("position y 0",positionY_atPre,engine.getPlayer(0).getFightCharacter().getPositionY());
		assertEquals("positon x : 6",positionX_atPre,engine.getPlayer(0).getFightCharacter().getPositionX());
		
		assertEquals("position x>=0",6>=0,engine.getPlayer(0).getFightCharacter().getPositionX()>=0);
		assertEquals("position y>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionY()>=0);
		assertEquals("position x<Engine::width",0<400,engine.getPlayer(0).getFightCharacter().getPositionX()<engine.getWidth());
		assertEquals("position y<Engine::height",0<400,engine.getPlayer(0).getFightCharacter().getPositionY()<engine.getHeight());
	}
	
	@Test
	public void testCrouch(){
		character= new CharacterImpl();
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		engine.getPlayer(0).getFightCharacter().init(100, 6, false, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(6);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		int positionX_atPre = engine.getPlayer(0).getFightCharacter().getPositionX();
		int positionY_atPre = engine.getPlayer(0).getFightCharacter().getPositionY();
		int speed_atPre = engine.getPlayer(0).getFightCharacter().getSpeed();
		int life_atPre = engine.getPlayer(0).getFightCharacter().getLife();
		boolean faceRight_atPre = engine.getPlayer(0).getFightCharacter().isFaceRight();
		
		engine.getPlayer(0).getFightCharacter().crouch();
		
		assertEquals("vie du character : 100",life_atPre,engine.getPlayer(0).getFightCharacter().getLife());
		assertEquals("vitesse de 6",speed_atPre,engine.getPlayer(0).getFightCharacter().getSpeed());
		assertEquals("face right true",faceRight_atPre,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("position y 0",positionY_atPre,engine.getPlayer(0).getFightCharacter().getPositionY());
		assertEquals("positon x : 6",positionX_atPre,engine.getPlayer(0).getFightCharacter().getPositionX());
		
		assertEquals("position x>=0",6>=0,engine.getPlayer(0).getFightCharacter().getPositionX()>=0);
		assertEquals("position y>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionY()>=0);
		assertEquals("position x<Engine::width",0<400,engine.getPlayer(0).getFightCharacter().getPositionX()<engine.getWidth());
		assertEquals("position y<Engine::height",0<400,engine.getPlayer(0).getFightCharacter().getPositionY()<engine.getHeight());
	}
	
	@Test
	public void testStepNeutral(){
		character= new CharacterImpl();
		EngineImpl engine = new EngineImpl();
		PlayerImpl p1 = new PlayerImpl();
		PlayerImpl p2 = new PlayerImpl();
		
		engine.init(800, 400, 200, p1, p2);
		engine.getPlayer(0).init(engine, 0);
		engine.getPlayer(1).init(engine, 1);
		engine.getPlayer(0).getFightCharacter().init(100, 6, false, 0);
		engine.getPlayer(1).getFightCharacter().init(100, 5, false, 1);
		engine.getPlayer(0).getFightCharacter().setPositionX(6);
		engine.getPlayer(1).getFightCharacter().setPositionX(300);
		engine.getPlayer(0).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(1).getFightCharacter().setRectangleHitboxService(new RectangleHitboxContract(new RectangleHitboxImpl()));
		engine.getPlayer(0).getFightCharacter().getRectangleHitbox().init(100, 0, 100, 200);
		engine.getPlayer(1).getFightCharacter().getRectangleHitbox().init(300, 0, 100, 200);
		
		int positionX_atPre = engine.getPlayer(0).getFightCharacter().getPositionX();
		int positionY_atPre = engine.getPlayer(0).getFightCharacter().getPositionY();
		int speed_atPre = engine.getPlayer(0).getFightCharacter().getSpeed();
		int life_atPre = engine.getPlayer(0).getFightCharacter().getLife();
		boolean faceRight_atPre = engine.getPlayer(0).getFightCharacter().isFaceRight();
		
		engine.getPlayer(0).getFightCharacter().step(Command.NEUTRAL);
		
		assertEquals("vie du character : 100",life_atPre,engine.getPlayer(0).getFightCharacter().getLife());
		assertEquals("vitesse de 6",speed_atPre,engine.getPlayer(0).getFightCharacter().getSpeed());
		assertEquals("face right true",faceRight_atPre,engine.getPlayer(0).getFightCharacter().isFaceRight());
		assertEquals("position y 0",positionY_atPre,engine.getPlayer(0).getFightCharacter().getPositionY());
		assertEquals("positon x : 6",positionX_atPre,engine.getPlayer(0).getFightCharacter().getPositionX());
		
		assertEquals("position x>=0",6>=0,engine.getPlayer(0).getFightCharacter().getPositionX()>=0);
		assertEquals("position y>=0",0>=0,engine.getPlayer(0).getFightCharacter().getPositionY()>=0);
		assertEquals("position x<Engine::width",0<400,engine.getPlayer(0).getFightCharacter().getPositionX()<engine.getWidth());
		assertEquals("position y<Engine::height",0<400,engine.getPlayer(0).getFightCharacter().getPositionY()<engine.getHeight());
	}
}
