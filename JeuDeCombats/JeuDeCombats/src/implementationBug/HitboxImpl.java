package implementationBug;

import service.HitboxService;

public class HitboxImpl implements HitboxService {

	private int positionX;
	private int positionY;
	
	
	@Override
	public int getPositionX() {
		return this.positionX;
	}

	@Override
	public int getPositionY() {
		return this.positionY;
	}

	@Override
	public boolean isBelongsTo(int x, int y) {
		return this.positionX == x && this.positionY == y;
	}

	@Override
	public boolean isCollidesWith(HitboxService hs) {
		return isBelongsTo(hs.getPositionX(), hs.getPositionY());
	}

	@Override
	public boolean isEqualsTo(HitboxService hs) {
		return isBelongsTo(hs.getPositionX(), hs.getPositionY());
	}

	@Override
	public void init(int x, int y) {
		this.positionX=x;
		this.positionY=y;
		
	}

	@Override
	public void moveTo(int x, int y) {
		this.positionX+=x;
		this.positionY+=y;
	}

}
