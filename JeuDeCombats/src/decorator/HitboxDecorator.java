package decorator;

import service.HitboxService;

public abstract class HitboxDecorator implements HitboxService {

	private HitboxService delegateHitbox;

	public HitboxDecorator(HitboxService hs){
		this.delegateHitbox = hs;
	}
	
	protected HitboxService getDelegate() {
		return delegateHitbox;
	}
	
	@Override
	public int getPositionX() {
		return this.delegateHitbox.getPositionX();
	}

	@Override
	public int getPositionY() {
		return this.delegateHitbox.getPositionY();
	}

	@Override
	public boolean isBelongsTo(int x, int y) {
		return this.delegateHitbox.isBelongsTo(x, y);
	}

	@Override
	public boolean isEqualsTo(HitboxService hs) {
		return this.delegateHitbox.isEqualsTo(hs);
	}

	@Override
	public void init(int x, int y) {
		this.delegateHitbox.init(x, y);
	}

	@Override
	public void moveTo(int x, int y) {
		this.delegateHitbox.moveTo(x, y);
	}

	@Override
	public boolean isCollidesWith(HitboxService hs) {
		return this.delegateHitbox.isCollidesWith(hs);
	}

	public void setPosX(int posX) {
		this.delegateHitbox.setPosX(posX);
		
	}

	public void setPosY(int posY) {
		this.delegateHitbox.setPosY(posY);
	}
}
