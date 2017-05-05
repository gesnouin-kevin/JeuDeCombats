package test.abstracts;

import static org.junit.Assert.*;

import org.junit.*;

import implementation.HitboxImpl;
import service.HitboxService;

public abstract class AbstractHitboxTest {

	private HitboxService hitbox;

	protected AbstractHitboxTest(){
		this.hitbox=null;
	}
	
	public HitboxService getHitbox() {
		return hitbox;
	}

	public void setHitbox(HitboxService hitbox) {
		this.hitbox = hitbox;
	}
	
	@Before
	public abstract void beforeTests(); 

	@After
	public final void afterTests() {
		hitbox=null;
	}
	
	@Test
	public void testInit(){
		hitbox = new HitboxImpl();
		hitbox.init(10, 10);
		
		assertEquals("position x: 10",10,hitbox.getPositionX());
		assertEquals("position y : 10",10,hitbox.getPositionY());
	}
	
	@Test
	public void testMoveTo(){
		hitbox = new HitboxImpl();
		hitbox.init(10, 10);
		
		hitbox.moveTo(100, 100);
		
		assertEquals("position x: 100",100,hitbox.getPositionX());
		assertEquals("position y : 100",100,hitbox.getPositionY());
	}
	
	@Test
	public void testSetPosX(){
		hitbox = new HitboxImpl();
		hitbox.init(10, 10);
		
		hitbox.setPosX(42);
		
		assertEquals("position x: 42",42,hitbox.getPositionX());
	}
	
	@Test
	public void testSetPosY(){
		hitbox = new HitboxImpl();
		hitbox.init(10, 10);
		
		hitbox.setPosY(42);
		
		assertEquals("position y: 42",42,hitbox.getPositionY());
	}
	
}
