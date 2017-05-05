package test.abstracts;

import static org.junit.Assert.*;

import org.junit.*;

import implementation.EngineImpl;
import implementation.PlayerImpl;
import service.PlayerService;

public abstract class AbstractPlayerTest {

	private PlayerService player1;
	private PlayerService player2;
	
	public AbstractPlayerTest(){
		player1=null;
		player2=null;
	}
	
	protected PlayerService getPlayer() {
		return player1;
	}

	protected void setPlayer(PlayerService player1, PlayerService player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	@Before
	public abstract void beforeTests(); 

	@After
	public final void afterTests() {
		player1=null;
		player2=null;
	}

	
	@Test
	public void testInit(){
		player1 = new PlayerImpl();
		player2 = new PlayerImpl();
		EngineImpl engine = new EngineImpl();
		engine.init(800, 400, 300, player1, player2);
		
		player1.init(engine, 0);
		player2.init(engine, 1);
		
		assertEquals("numero du joueur est 0",0,player1.getNumeroPlayer());
		assertEquals("numero du joueur est 1",1,player2.getNumeroPlayer());
		
	}
	
	@Test
	public void testSetAnimationPlayer(){
		player1 = new PlayerImpl();
		player2 = new PlayerImpl();
		EngineImpl engine = new EngineImpl();
		engine.init(800, 400, 300, player1, player2);
		
		player1.init(engine, 0);
		player2.init(engine, 1);
		
		assertEquals("numero du joueur est 0",0,player1.getNumeroPlayer());
		assertEquals("numero du joueur est 1",1,player2.getNumeroPlayer());
	}
}
