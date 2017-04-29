package IHM;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import personnages.InformationsCharacter;
import service.Command;

public class Fighting extends BasicGameState {

	public static final int ID = 3;
	public static int NB_BACKGROUND = 5;
	public static int NB_FRAMES_BACKGROUND = 8;
	public static int NB_MAX_ANIMATION = 22;
	public static int GROUND = 50;
	
	private int time = 0;
	private long lastMs;

	private Window window;
	private Animation[] animationsBackground;
	private SpriteSheet iconCharacter;
	private SpriteSheet iconKO;
	
	private boolean modeDebug;

	public Fighting(Window window) {
		this.window = window;

		this.animationsBackground = new Animation[NB_BACKGROUND];
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game){
		gc.getInput().enableKeyRepeat();
		this.window.getGame().getEngine().getPlayer(0).setAnimationPlayer(new IHM.Animation(this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter(), this.window.getGame()));
		this.window.getGame().getEngine().getPlayer(1).setAnimationPlayer(new IHM.Animation(this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter(), this.window.getGame()));
		
		this.modeDebug = false;

		//load background images
		try{
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

		// load icon and image KO
		this.iconKO = new SpriteSheet("ressources/fight/iconKO.png", 40, 31);
		this.iconCharacter = new SpriteSheet("ressources/menu/iconCharacter2.png", 976, 194);

		// load animations characters
		
		} catch (SlickException e) {} 

	}

	@Override
	public void render(GameContainer gc, StateBasedGame window, Graphics g) throws SlickException {
		this.animationsBackground[this.window.getCurrentBackground()].draw(0,0, 1366, 768);

		float scaleX =  (gc.getWidth()/700f);
		float scaleY = (gc.getHeight()/500f);
		
		//draw time
		g.setColor(new Color(255,255,255));
		g.drawString("Time : " + time/1000, 100, 100);

		// draw head player1
		this.iconCharacter.draw(5*scaleX, 0, 8*scaleX+61*scaleX, 14*scaleY+97*scaleY, this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter()*61, 0, this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter()*61+61, 97);
		// draw head player2
		this.iconCharacter.draw(gc.getWidth()-61*scaleX, 0 , gc.getWidth(), 97*scaleY, this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter()*61, 97, this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter()*61+61, 194);

		this.iconKO.draw(gc.getWidth()/2-(40/2)*scaleX, 5*scaleY, gc.getWidth()/2+(40/2)*scaleX, 5*scaleY+20*scaleY, 0, 0, 40, 31);

		//left bar life
		g.setColor(new Color(255, 255, 255)); // white
		g.fillRect(gc.getWidth()/2-(40/2)*scaleX-502, 10*scaleY-2, 502, 13*scaleY);
		g.setColor(new Color(255, 0, 0)); // red
		g.fillRect(gc.getWidth()/2-(40/2)*scaleX-500, 10*scaleY, 502, 10*scaleY);
		g.setColor(new Color(255, 255, 0)); // yellow
		g.fillRect(gc.getWidth()/2-(40/2)*scaleX-500, 10*scaleY, 502, 10*scaleY);

		//right bar life
		g.setColor(new Color(255, 255, 255));
		g.fillRect(gc.getWidth()/2+(40/2)*scaleX, 10*scaleY-2, 502, 13*scaleY);
		g.setColor(new Color(255, 0, 0));
		g.fillRect(gc.getWidth()/2+(40/2)*scaleX, 10*scaleY, 502, 10*scaleY);
		g.setColor(new Color(255, 255, 0));
		g.fillRect(gc.getWidth()/2+(40/2)*scaleX, 10*scaleY, 502, 10*scaleY);

		int posXp1 = this.window.getGame().getEngine().getPlayer(0).getCharacter().getPositionX();
		int posYp1 = this.window.getGame().getEngine().getPlayer(0).getCharacter().getPositionY();
		int posXp2 = this.window.getGame().getEngine().getPlayer(1).getCharacter().getPositionX();
		int posYp2 = this.window.getGame().getEngine().getPlayer(1).getCharacter().getPositionY();

		int posXp1hitbox = this.window.getGame().getEngine().getPlayer(0).getCharacter().getRectangleHitboxService().getPositionX();
		int posYp1hitbox = this.window.getGame().getEngine().getPlayer(0).getCharacter().getRectangleHitboxService().getPositionY();
		int widthHitboxP1 = this.window.getGame().getEngine().getPlayer(0).getCharacter().getRectangleHitboxService().getWidth();
		int heightHitboxP1 = this.window.getGame().getEngine().getPlayer(0).getCharacter().getRectangleHitboxService().getHeight();

		int posXp2hitbox = this.window.getGame().getEngine().getPlayer(1).getCharacter().getRectangleHitboxService().getPositionX();
		int posYp2hitbox = this.window.getGame().getEngine().getPlayer(1).getCharacter().getRectangleHitboxService().getPositionY();
		int widthHitboxP2 = this.window.getGame().getEngine().getPlayer(1).getCharacter().getRectangleHitboxService().getWidth();	
		int heightHitboxP2 = this.window.getGame().getEngine().getPlayer(1).getCharacter().getRectangleHitboxService().getHeight();

		if(this.modeDebug)
		{	
			g.drawString("Vie j1: "+this.window.getGame().getEngine().getPlayer(0).getCharacter().getLife(), 0, gc.getHeight()-40);
			g.drawString("Vie j2: "+this.window.getGame().getEngine().getPlayer(1).getCharacter().getLife(), 0, gc.getHeight()-20);
			g.drawString("Position j1: X: "+posXp1+" Y: "+posYp1, 0, gc.getHeight()-80);
			g.drawString("Position j2: X: "+posXp2+" Y: "+posYp2, 0, gc.getHeight()-60);
			g.drawString("Position hitbox j1: X: "+posXp1hitbox+" Y: "+posYp1hitbox+" Width: "+widthHitboxP1+" Height: "+heightHitboxP1, 0, gc.getHeight()-120);
			g.drawString("Position hitbox j2: X: "+posXp2hitbox+" Y: "+posYp2hitbox+" Width: "+widthHitboxP2+" Height: "+heightHitboxP2, 0, gc.getHeight()-100);

			// draw boudingbox player 1
			g.setColor(new Color(0,255,0,60));
			g.fillRect(posXp1hitbox, gc.getHeight()-posYp1hitbox-GROUND-heightHitboxP1, widthHitboxP1, heightHitboxP1);

			// draw boudingbox player 2
			g.setColor(new Color(255,0,0,60));
			g.fillRect(posXp2hitbox, gc.getHeight()-posYp2hitbox-GROUND-heightHitboxP2, widthHitboxP2, heightHitboxP2);
		}

		// draw player1
		int heightPlayer1 = this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation());
		
		if(this.window.getGame().getEngine().getPlayer(0).getCharacter().isFaceRight())
			this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getSpriteSheet().draw(posXp1, gc.getHeight()-(posYp1+heightPlayer1+GROUND));
		else
			this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getSpriteSheet().draw(posXp1, gc.getHeight()-(posYp1+heightPlayer1+GROUND) 
				,this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getWidthAnimations(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation()),0
							,0,this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation()));
			
		// draw player2
		int heightPlayer2 = this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation());
		
		if(this.window.getGame().getEngine().getPlayer(1).getCharacter().isFaceRight())
			this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getSpriteSheet().draw(posXp2, gc.getHeight()-(posYp2+heightPlayer2+GROUND));
		else
			this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getSpriteSheet().draw(posXp2, gc.getHeight()-(posYp2+heightPlayer2+GROUND) 
				,this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getWidthAnimations(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation()),0
							,0,this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation()));
			
	}

	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_P)
			this.modeDebug = !this.modeDebug;

		//Player 2
		if (key == Input.KEY_RIGHT && key == Input.KEY_UP){
			this.window.getGame().getEngine().setCommandPlayer2(Command.UPRIGHT);

		}
		else if (key == Input.KEY_LEFT && key == Input.KEY_UP){
			this.window.getGame().getEngine().setCommandPlayer2(Command.UPLEFT);
		}
		else if(key== Input.KEY_LEFT){ 
			this.window.getGame().getEngine().setCommandPlayer2(Command.LEFT);
		}
		else if (key == Input.KEY_RIGHT){
			this.window.getGame().getEngine().setCommandPlayer2(Command.RIGHT);
		}

		else if(key== Input.KEY_DOWN){ 
			this.window.getGame().getEngine().setCommandPlayer2(Command.DOWN);
		}

		else if( key == Input.KEY_UP){ 
			this.window.getGame().getEngine().setCommandPlayer2(Command.UP);
		}

		else if(key==Input.KEY_4){
			this.window.getGame().getEngine().setCommandPlayer2(Command.PUNCH);
		}

		else if(key==Input.KEY_5){
			this.window.getGame().getEngine().setCommandPlayer2(Command.KICK);
		}
		else if(key==Input.KEY_6){
			this.window.getGame().getEngine().setCommandPlayer2(Command.BLOCK);
		}
		//player 1

		if (key == Input.KEY_D && key == Input.KEY_Z){
			this.window.getGame().getEngine().setCommandPlayer1(Command.UPRIGHT);

		}
		else if (key == Input.KEY_Q && key == Input.KEY_Z){
			this.window.getGame().getEngine().setCommandPlayer1(Command.UPLEFT);

		}
		else if(key== Input.KEY_Q){ 
			this.window.getGame().getEngine().setCommandPlayer1(Command.LEFT);
		}
		else if (key == Input.KEY_D){
			this.window.getGame().getEngine().setCommandPlayer1(Command.RIGHT);
		}
		else if(key== Input.KEY_S){ 
			this.window.getGame().getEngine().setCommandPlayer1(Command.DOWN);
		}
		else if( key == Input.KEY_Z){ 
			this.window.getGame().getEngine().setCommandPlayer1(Command.UP);
		}
		else if(key==Input.KEY_A){
			this.window.getGame().getEngine().setCommandPlayer1(Command.PUNCH);
		}
		else if(key==Input.KEY_E){
			this.window.getGame().getEngine().setCommandPlayer1(Command.KICK);
		} 
		else if(key==Input.KEY_R){
			this.window.getGame().getEngine().setCommandPlayer1(Command.BLOCK);
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		if(key==Input.KEY_Z || key==Input.KEY_Q || key==Input.KEY_S || key==Input.KEY_D)
			this.window.getGame().getEngine().setCommandPlayer1(Command.NEUTRAL);
		if(key==Input.KEY_DOWN || key==Input.KEY_UP || key==Input.KEY_LEFT || key==Input.KEY_RIGHT)
			this.window.getGame().getEngine().setCommandPlayer2(Command.NEUTRAL);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame window, int delta) throws SlickException {
		this.window.getGame().getEngine().updateFace();
		this.window.getGame().getEngine().step();
		time+=delta;
		
		if(System.currentTimeMillis()-lastMs>500) // limite frame rate -> frame de 500 ms ?
		{
			if(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer() != null)
				this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().nextFrame();
			if(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer() != null)
				this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().nextFrame();
			lastMs = System.currentTimeMillis();
		
		}
	}

	@Override
	public int getID() {
		return ID;
	}
}