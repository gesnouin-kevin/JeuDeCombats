package IHMBug;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuBug extends BasicGameState {

	public static final int ID = 1;

	private StateBasedGame game;
	private SpriteSheet titleMenu;

	public MenuBug() {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		this.game = game;
		this.titleMenu = new SpriteSheet("ressources/menu/title.png", 234, 150);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame window, Graphics g) throws SlickException {
		this.titleMenu.draw(gc.getWidth()/2-gc.getWidth()/4, gc.getHeight()/4, gc.getWidth()/2, gc.getHeight()/2);
		g.drawString("--- PRESS ANY KEY TO START ---", gc.getWidth()/2-125, gc.getHeight()/2+ 225);
	}

	@Override
	public void keyReleased(int key, char c) {
		game.enterState(SelectionCharacterBug.ID);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame window, int arg2) throws SlickException {
	}

	@Override
	public int getID() {
		return ID;
	}

}