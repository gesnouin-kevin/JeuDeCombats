package main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Animation;

public class Window extends StateBasedGame {
	


	private GameContainer gc;
	private Game game;
	private int windowWidth;
	private int windowHeight;

	private SpriteSheet cursorSelectCharacter;
	private SpriteSheet iconCharacter;
	private SpriteSheet selectionCharacter;
	
	private int numeroCharacterPlayer1;
	private int numeroCharacterPlayer2;
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
		addState(new Menu(this));
	    addState(new SelectionCharacter(this));
	    addState(new Fighting(this));
	}

	public SpriteSheet getCursorSelectCharacter() {
		return cursorSelectCharacter;
	}

	public SpriteSheet getIconCharacter() {
		return iconCharacter;
	}
	public SpriteSheet getSelectionCharacter() {
		return selectionCharacter;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public int getNumeroCharacterPlayer1() {
		return numeroCharacterPlayer1;
	}

	public void setNumeroCharacterPlayer1(int numeroCharacterPlayer1) {
		this.numeroCharacterPlayer1 = numeroCharacterPlayer1;
	}

	public int getNumeroCharacterPlayer2() {
		return numeroCharacterPlayer2;
	}

	public void setNumeroCharacterPlayer2(int numeroCharacterPlayer2) {
		this.numeroCharacterPlayer2 = numeroCharacterPlayer2;
	}

	public int getCurrentBackground() {
		return currentBackground;
	}

	public void setCurrentBackground(int currentBackground) {
		this.currentBackground = currentBackground;
	}
}
