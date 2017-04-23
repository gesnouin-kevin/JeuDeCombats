package main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;

public class Game extends BasicGame {
	
	public static int NB_BACKGROUND = 3;

	private GameContainer gc;
	private Animation[] animationsBackground;
	private int currentBackground = 2;

	public Game(){
		super( "GameWindow" );
		this.animationsBackground = new Animation[NB_BACKGROUND];
	}

	//charger et initialiser les ressources
	@Override
	public void init( GameContainer gc ) throws SlickException{
		this.gc = gc;
	    
	    Animation animation = new Animation();
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame0.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame1.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame2.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame3.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame4.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame5.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame6.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background1frame7.png", 800, 336), 100);
	    this.animationsBackground[0] = animation;
	    
	    animation = new Animation();
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame0.png", 100, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame1.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame2.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame3.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame4.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame5.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame6.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background2frame7.png", 800, 336), 100);
	    this.animationsBackground[1] = animation;
	    
	    animation = new Animation();
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame0.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame1.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame2.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame3.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame4.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame5.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame6.png", 800, 336), 100);
	    animation.addFrame(new SpriteSheet("ressources/background/background3frame7.png", 800, 336), 100);
	    this.animationsBackground[2] = animation;
	}

	//dessiner � l��cran
	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException{
		this.animationsBackground[currentBackground].draw(0,0, 1366, 768);
		/*g.setColor(new Color(255, 0, 0, 65));
		g.fillRect(5, 5, 1000, 1000);
		g.setColor(new Color(0, 255, 0, 65));
		g.fillRect(500, 500, 1000, 1000);*/
		
		
	}

	//mettre � jour le jeu en fonction des entr�es utilisateurs ou autre
	@Override
	public void update( GameContainer gc, int delta ) throws SlickException{
	}

}
