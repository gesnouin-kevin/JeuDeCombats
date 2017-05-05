package test.abstracts;

import static org.junit.Assert.*;

import org.junit.*;

import implementation.RectangleHitboxImpl;
import service.RectangleHitboxService;

public abstract class AbstractRectangleHitboxTest {

	private RectangleHitboxService rectangleHitbox;

	public AbstractRectangleHitboxTest(){
		this.rectangleHitbox=null;
	}
	
	public RectangleHitboxService getRectangleHitbox() {
		return rectangleHitbox;
	}

	public void setRectangleHitbox(RectangleHitboxService rectangleHitbox) {
		this.rectangleHitbox = rectangleHitbox;
	}

	@Before
	public abstract void beforeTests(); 

	@After
	public final void afterTests() {
		rectangleHitbox=null;
	}
	
	@Test
	public void testInit(){
		rectangleHitbox=new RectangleHitboxImpl();
		
		rectangleHitbox.init(10, 10, 100, 200);
		
		assertEquals("pos x de 10",10,rectangleHitbox.getPositionX());
		assertEquals("pos y de 10",10,rectangleHitbox.getPositionY());
		assertEquals("width de 100",100,rectangleHitbox.getWidth());
		assertEquals("height de 200",200,rectangleHitbox.getHeight());
		
		assertEquals("width >0",100 >0,rectangleHitbox.getWidth()>0);
		assertEquals("height >0",200 >0,rectangleHitbox.getHeight()>0);
	}
	
	@Test
	public void testSetters(){
		rectangleHitbox=new RectangleHitboxImpl();
		
		rectangleHitbox.init(10, 10, 100, 200);
		
		assertEquals("pos x de 10",10,rectangleHitbox.getPositionX());
		assertEquals("pos y de 10",10,rectangleHitbox.getPositionY());
		assertEquals("width de 100",100,rectangleHitbox.getWidth());
		assertEquals("height de 200",200,rectangleHitbox.getHeight());
		
		rectangleHitbox.setPosX(24);
		assertEquals("pos x de 24",24,rectangleHitbox.getPositionX());
		
		rectangleHitbox.setPosY(42);
		assertEquals("pos y de 42",42,rectangleHitbox.getPositionY());
		
		rectangleHitbox.setWidth(450);
		assertEquals("width x de 450",450,rectangleHitbox.getWidth());
		
		rectangleHitbox.setHeight(365);
		assertEquals("height x de 365",365,rectangleHitbox.getHeight());
		
		rectangleHitbox.setWidthHeight(874,456);
		assertEquals("width de 874",874,rectangleHitbox.getWidth());
		assertEquals("height x de 456",456,rectangleHitbox.getHeight());
		
		assertEquals("width >0",100 >0,rectangleHitbox.getWidth()>0);
		assertEquals("height >0",200 >0,rectangleHitbox.getHeight()>0);
	}
	
}
