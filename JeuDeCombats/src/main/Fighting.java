package main;

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
	public static int GROUND = 50;

	private StateBasedGame game;
	private Window window;
	private Animation[] animationsBackground;
	private SpriteSheet iconCharacter;
	private SpriteSheet iconKO;
	private Animation animationPlayer1IdleRight;
	private Animation animationPlayer1IdleLeft;
	private Animation animationPlayer2IdleRight;
	private Animation animationPlayer2IdleLeft;

	private boolean modeDebug;

	public Fighting(Window window) {
		this.window = window;

		this.animationsBackground = new Animation[NB_BACKGROUND];
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		this.game = game;
		this.modeDebug = false;

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
		this.iconKO = new SpriteSheet("ressources/fight/iconKO.png", 40, 31);
		this.iconCharacter = new SpriteSheet("ressources/menu/iconCharacter2.png", 976, 194);


		this.animationPlayer1IdleLeft = new Animation();
		this.animationPlayer2IdleLeft = new Animation();

		this.animationPlayer1IdleRight = new Animation();
		this.animationPlayer2IdleRight = new Animation();
		
		int numPlayer1 = this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter();
		int numPlayer2 = this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter();
		
		SpriteSheet s1 = new SpriteSheet("ressources/fight/"+numPlayer1+".png", 1413, 2096);
		SpriteSheet s2 = new SpriteSheet("ressources/fight/"+numPlayer2+".png", 1413, 2096);
		
		for(int i=0; i<InformationsCharacter.getNbSpritePersoIdle(numPlayer1);i++){
			animationPlayer1IdleRight.addFrame(s1.getSubImage(InformationsCharacter.getWidthSpritePersoIdle(numPlayer1)*i, 0, InformationsCharacter.getWidthSpritePersoIdle(numPlayer1), InformationsCharacter.getHeightSpritePersoIdle(numPlayer1)), 500);
			animationPlayer1IdleLeft.addFrame(s1.getSubImage(InformationsCharacter.getWidthSpritePersoIdle(numPlayer1)*i, InformationsCharacter.getHeightSpritePersoIdle(numPlayer1), InformationsCharacter.getWidthSpritePersoIdle(numPlayer1), InformationsCharacter.getHeightSpritePersoIdle(numPlayer1)), 500);

		}
		for(int i=0; i<InformationsCharacter.getNbSpritePersoIdle(numPlayer2);i++){
			animationPlayer2IdleRight.addFrame(s2.getSubImage(InformationsCharacter.getWidthSpritePersoIdle(numPlayer2)*i, 0, InformationsCharacter.getWidthSpritePersoIdle(numPlayer2), InformationsCharacter.getHeightSpritePersoIdle(numPlayer2)), 500);
			animationPlayer2IdleLeft.addFrame(s2.getSubImage(InformationsCharacter.getWidthSpritePersoIdle(numPlayer2)*i, InformationsCharacter.getHeightSpritePersoIdle(numPlayer2), InformationsCharacter.getWidthSpritePersoIdle(numPlayer2), InformationsCharacter.getHeightSpritePersoIdle(numPlayer2)), 500);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame window, Graphics g) throws SlickException {
		this.animationsBackground[this.window.getCurrentBackground()].draw(0,0, 1366, 768);

		float scaleX =  (gc.getWidth()/700f);
		float scaleY = (gc.getHeight()/500f);

		// draw head player1
		this.iconCharacter.draw(5*scaleX, 0, 8*scaleX+61*scaleX, 14*scaleY+97*scaleY, this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter()*61, 0, this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter()*61+61, 97);
		// draw head player2
		this.iconCharacter.draw(gc.getWidth()-61*scaleX, 0 , gc.getWidth(), 97*scaleY, this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter()*61, 97, this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter()*61+61, 194);

		System.out.println(this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter());

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
		if(this.window.getGame().getEngine().getPlayer(0).getCharacter().isFaceRight())
			g.drawAnimation(this.animationPlayer1IdleRight, posXp1, gc.getHeight()-posYp1-InformationsCharacter.getHeightSpritePersoIdle(this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter())-GROUND);
		else
			g.drawAnimation(this.animationPlayer1IdleLeft, posXp1, gc.getHeight()-posYp1-InformationsCharacter.getHeightSpritePersoIdle(this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter())-GROUND);

		// draw player2
		if(this.window.getGame().getEngine().getPlayer(1).getCharacter().isFaceRight())
			g.drawAnimation(this.animationPlayer2IdleRight, posXp2, gc.getHeight()-posYp1-InformationsCharacter.getHeightSpritePersoIdle(this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter())-GROUND);
		else
			g.drawAnimation(this.animationPlayer2IdleLeft, posXp2, gc.getHeight()-posYp1-InformationsCharacter.getHeightSpritePersoIdle(this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter())-GROUND);
	}

	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_P)
			this.modeDebug = !this.modeDebug;

		//Player 2
		if (key == Input.KEY_RIGHT && key == Input.KEY_UP){
			this.window.getGame().getEngine().step(Command.NEUTRAL, Command.UPRIGHT);

		}
		if (key == Input.KEY_LEFT && key == Input.KEY_UP){
			this.window.getGame().getEngine().step(Command.NEUTRAL, Command.UPLEFT);

		}
		if(key== Input.KEY_LEFT){ 
			this.window.getGame().getEngine().step(Command.NEUTRAL, Command.LEFT);
		}
		if (key == Input.KEY_RIGHT){
			this.window.getGame().getEngine().step(Command.NEUTRAL, Command.RIGHT);
		}

		if(key== Input.KEY_DOWN){ 

		}

		if( key == Input.KEY_UP){ 

		}

		if(key==Input.KEY_4){

		}

		if(key==Input.KEY_5){

		}
		if(key==Input.KEY_6){

		}

		//player 1

		if(key == Input.KEY_D) {

		}

		if(key == Input.KEY_Q){ 

		}

		if(key == Input.KEY_S){ 

		}

		if(key == Input.KEY_Z){

		}
		
		if(key == Input.KEY_A){

		}

		if(key == Input.KEY_E){

		}
		
		if(key == Input.KEY_R){

		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame window, int arg2) throws SlickException {
	}

	@Override
	public int getID() {
		return ID;
	}

}