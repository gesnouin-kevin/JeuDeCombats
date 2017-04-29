package IHM;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Window extends StateBasedGame {
	


	private GameContainer gc;
	private Game game;
	private int windowWidth;
	private int windowHeight;

	private int currentBackground = 3;
	
	public Window(Game game, int windowWidth, int windowHeight)
	{
		super("GameWindow");
		this.game = game;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu());
	    addState(new SelectionCharacter(this));
	    addState(new Fighting(this));
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
	
	public Game getGame() {
		return this.game;
	}
}
