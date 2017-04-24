package decorator;

import service.RectangleHitboxService;

public abstract class RectangleHitboxDecorator extends HitboxDecorator implements RectangleHitboxService {
	
	public RectangleHitboxDecorator(RectangleHitboxDecorator rhd) {
		super(rhd);
	}

	@Override
	protected RectangleHitboxService getDelegate() {
		return (RectangleHitboxService) super.getDelegate();
	}
	
	@Override
	public int getWidth() {
		return getDelegate().getWidth();
	}

	@Override
	public int getHeight() {
		return getDelegate().getHeight();
	}

	@Override
	public boolean isCollidesWith(RectangleHitboxService rhs) {
		return getDelegate().isCollidesWith(rhs);
	}

	@Override
	public boolean isEqualsTo(RectangleHitboxService rhs) {
		return getDelegate().isEqualsTo(rhs);
	}

	@Override
	public void init(int x, int y, int w, int h) {
		getDelegate().init(x, y, w, h);		
	}
	
}