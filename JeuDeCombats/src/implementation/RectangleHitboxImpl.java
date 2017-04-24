package implementation;

import service.RectangleHitboxService;

public class RectangleHitboxImpl extends HitboxImpl implements RectangleHitboxService {

	private int width;
	private int height;
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean isCollidesWith(RectangleHitboxService rhs) {
		return getPositionX() < rhs.getPositionX() + rhs.getWidth() 
				&& getPositionX() + getWidth() > rhs.getPositionX() 
				&& getPositionY() < rhs.getPositionY() + rhs.getHeight()
				&& getPositionY() + getHeight() > rhs.getPositionY();
	}

	@Override
	public boolean isEqualsTo(RectangleHitboxService rhs) {
		return rhs.getPositionX() == getPositionX() && rhs.getPositionY() == getPositionY() && rhs.getHeight() == height && rhs.getWidth() == width;
	}

	@Override
	public void init(int x, int y, int w, int h) {
		super.init(x, y);
		this.height=h;
		this.width=w;
		
	}

	@Override
	public boolean isBelongsTo(int x, int y) {
		return y >= getPositionY() && y <= getPositionY() + height && x >= getPositionX() - width / 2 && x <= getPositionX() + width / 2;
	}
	
	
	

}
