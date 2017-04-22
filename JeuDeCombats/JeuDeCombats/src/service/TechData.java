package service;

public interface TechData {

	
	/** A COMPLETER */
	
	
	/** Observators */
	public int getDamage();
	public int getHstun();
	public int getBstun();
	public int getSframe();
	public int getHframe();
	public int getRFrame();
	public HitboxService getHitbox(int x, int y);
}
