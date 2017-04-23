package main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;

public class Window extends BasicGame  {
	
	public static int NB_BACKGROUND = 5;
	public static int NB_FRAMES_BACKGROUND = 8;

	private GameContainer gc;
	private Game game;
	
	private Animation[] animationsBackground;
	
	public Window(Game game)
	{
		super("GameWindow");
		this.game = game;
		this.animationsBackground = new Animation[NB_BACKGROUND];
	}
	
	public void loadImage() throws SlickException
	{
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
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		this.animationsBackground[this.game.getCurrentBackground()].draw(0,0, 1366, 768);
		/*g.setColor(new Color(255, 0, 0, 65));
		g.fillRect(5, 5, 1000, 1000);
		g.setColor(new Color(0, 255, 0, 65));
		g.fillRect(500, 500, 1000, 1000);*/
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		this.gc = gc;
		loadImage();
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		
	}

}
