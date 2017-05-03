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

	@Override
	public void setHeight(int height) {
		getDelegate().setHeight(height);
	}

	@Override
	public int getPosX() {
		return getDelegate().getPosX();
	}

	@Override
	public int getPosY() {
		return getDelegate().getPosY();
	}

	@Override
	public void setWidth(int width) {
		getDelegate().setWidth(width);
	}

	@Override
	public void setWidthHeight(int w, int h) {
		getDelegate().setWidthHeight(w, h);
	}
	
	
	
}