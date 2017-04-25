package main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Fighting extends BasicGameState {

	public static final int ID = 3;
	public static int NB_BACKGROUND = 5;
	public static int NB_FRAMES_BACKGROUND = 8;

	private StateBasedGame game;
	private Window window;
	private Animation[] animationsBackground;

	public Fighting(Window window) {
		this.window = window;

		this.animationsBackground = new Animation[NB_BACKGROUND];
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		this.game = game;
		
		//load background images
		for(int j=0; j<NB_BACKGROUND; j++){
			 Animation animation = new Animation();
			 int nbFrames = NB_BACKGROUND;
			 if(j==3)
				 nbFrames = 24;
			 for(int i=0; i<nbFrames;i++){
				    animation.addFrame(new SpriteSheet("ressources/background/background"+(j+1)+"frame"+i+".png", 800, 336), 100); 
			 }
			 this.animationsBackground[j] = animation;
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame window, Graphics g) throws SlickException {
		this.animationsBackground[this.window.getCurrentBackground()].draw(0,0, 1366, 768);
	}

	@Override
	public void keyReleased(int key, char c) {
	}

	@Override
	public void update(GameContainer gc, StateBasedGame window, int arg2) throws SlickException {
	}

	@Override
	public int getID() {
		return ID;
	}

}