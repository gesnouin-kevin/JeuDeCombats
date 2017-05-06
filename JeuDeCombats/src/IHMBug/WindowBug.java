package IHMBug;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class WindowBug extends StateBasedGame {
	


	private GameContainer gc;
	private GameBug game;
	private int windowWidth;
	private int windowHeight;

	private int currentBackground = 3;
	
	public WindowBug(GameBug game, int windowWidth, int windowHeight)
	{
		super("GameWindow");
		this.game = game;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new MenuBug());
	    addState(new SelectionCharacterBug(this));
	    addState(new FightingBug(this));
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public int getCurrentBackground() {
		return currentBackground;
	}

	public void setCurrentBackground(int currentBackground) {
		this.currentBackground = currentBackground;
	}
	
	public GameBug getGame() {
		return this.game;
	}
}
