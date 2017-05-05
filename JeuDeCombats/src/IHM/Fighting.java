package IHM;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
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
	private boolean quit = false;
	private long lastMs;

	private Window window;
	private Animation[] animationsBackground;
	private SpriteSheet iconCharacter;
	private SpriteSheet iconKO;

	private boolean modeDebug;
	private int inputPlayer1[];  //0 rien , 1 appuyé, 2 released
	private int inputPlayer2[];

	public Fighting(Window window) {
		this.window = window;
		this.inputPlayer1 = new int[7];
		this.inputPlayer2 = new int[7];
		this.animationsBackground = new Animation[NB_BACKGROUND];
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game){
		gc.getInput().enableKeyRepeat();
		this.window.getGame().getEngine().getPlayer(0).setAnimationPlayer(new IHM.Animation(this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter()));
		this.window.getGame().getEngine().getPlayer(1).setAnimationPlayer(new IHM.Animation(this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter()));

		this.modeDebug = false;
		for(int i=0;i<this.inputPlayer1.length;i++)
		{
			this.inputPlayer1[i]=0;
			this.inputPlayer2[i]=0;
		}

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

			// load music and start it
			Music music = new Music("ressources/music.ogg");
			gc.setMusicVolume(0.1f);
			music.loop();

		} catch (SlickException e) {} 

	}

	@Override
	public void render(GameContainer gc, StateBasedGame window, Graphics g) throws SlickException {
		this.animationsBackground[this.window.getCurrentBackground()].draw(0,0, 1366, 768);

		float scaleX =  (gc.getWidth()/700f);
		float scaleY = (gc.getHeight()/500f);

		//draw time
		g.setColor(new Color(255,255,255));
		g.drawString("Time : " + time/1000, gc.getWidth()-100, gc.getHeight()-20);

		// draw head player1
		this.iconCharacter.draw(5*scaleX, 0, 8*scaleX+61*scaleX, 14*scaleY+97*scaleY, this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter()*61, 0, this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter()*61+61, 97);
		// draw head player2
		this.iconCharacter.draw(gc.getWidth()-61*scaleX, 0 , gc.getWidth(), 97*scaleY, this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter()*61, 97, this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter()*61+61, 194);

		this.iconKO.draw(gc.getWidth()/2-(40/2)*scaleX, 5*scaleY, gc.getWidth()/2+(40/2)*scaleX, 5*scaleY+20*scaleY, 0, 0, 40, 31);

		//left bar life
		g.setColor(new Color(255, 255, 255)); // white
		g.fillRect(gc.getWidth()/2-(40/2)*scaleX-502, 10*scaleY-2, 502, 13*scaleY);
		g.setColor(new Color(255, 0, 0)); // red
		g.fillRect(gc.getWidth()/2-(40/2)*scaleX-500, 10*scaleY, 502, 10*scaleY);
		g.setColor(new Color(255, 255, 0)); // yellow
		int vieMaxPersoP1 = InformationsCharacter.getLife(this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter());
		int viePersoP1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getLife();
		if(viePersoP1<0)
			viePersoP1 = 0;
		int widthLifeBar = (502*viePersoP1)/vieMaxPersoP1;
		
		
		g.fillRect(gc.getWidth()/2-(40/2)*scaleX-500+(502-widthLifeBar), 10*scaleY, widthLifeBar, 10*scaleY);

		//right bar life
		g.setColor(new Color(255, 255, 255));
		g.fillRect(gc.getWidth()/2+(40/2)*scaleX, 10*scaleY-2, 502, 13*scaleY);
		g.setColor(new Color(255, 0, 0));
		g.fillRect(gc.getWidth()/2+(40/2)*scaleX, 10*scaleY, 502, 10*scaleY);
		g.setColor(new Color(255, 255, 0));
		int vieMaxPersoP2 = InformationsCharacter.getLife(this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter());
		int viePersoP2 = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getLife();
		if(viePersoP2<0)
			viePersoP2 = 0;
		g.fillRect(gc.getWidth()/2+(40/2)*scaleX, 10*scaleY, (502*viePersoP2)/vieMaxPersoP2, 10*scaleY);

		int posXp1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getPositionX();
		int posYp1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getPositionY();
		int posXp2 = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getPositionX();
		int posYp2 = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getPositionY();
		
		int posXp1hitbox = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getRectangleHitbox().getPositionX();
		int posYp1hitbox = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getRectangleHitbox().getPositionY();
		int widthHitboxP1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getRectangleHitbox().getWidth();
		int heightHitboxP1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getRectangleHitbox().getHeight();

		int posXp2hitbox = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getRectangleHitbox().getPositionX();
		int posYp2hitbox = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getRectangleHitbox().getPositionY();
		int widthHitboxP2 = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getRectangleHitbox().getWidth();	
		int heightHitboxP2 = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getRectangleHitbox().getHeight();


		int posXp1Coupbox = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getCoupBox().getPositionX();
		int posYp1Coupbox = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getCoupBox().getPositionY();
		int widthCoupboxP1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getCoupBox().getWidth();
		int heightCoupboxP1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getCoupBox().getHeight();

		int posXp2Coupbox = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getCoupBox().getPositionX();
		int posYp2Coupbox = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getCoupBox().getPositionY();
		int widthCoupboxP2 = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getCoupBox().getWidth();	
		int heightCoupboxP2 = this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getCoupBox().getHeight();

		if(this.modeDebug)
		{	
			g.drawString("Vie j1: "+this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getLife(), 0, gc.getHeight()-40);
			g.drawString("Vie j2: "+this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getLife(), 0, gc.getHeight()-20);
			g.drawString("Position j1: X: "+posXp1+" Y: "+posYp1, 0, gc.getHeight()-80);
			g.drawString("Position j2: X: "+posXp2+" Y: "+posYp2, 0, gc.getHeight()-60);
			g.drawString("Position coup hitbox j1: X: "+posXp1Coupbox+" Y: "+posYp1Coupbox+" Width: "+widthCoupboxP1+" Height: "+heightCoupboxP1, 0, gc.getHeight()-100);
			
			// draw boudingbox player 1
			g.setColor(new Color(0,255,0,60));
			g.fillRect(posXp1hitbox, gc.getHeight()-posYp1hitbox-GROUND-heightHitboxP1, widthHitboxP1, heightHitboxP1);
			g.setColor(new Color(0,255,0,200));
			g.fillRect(posXp1Coupbox, gc.getHeight()-posYp1Coupbox-GROUND-heightCoupboxP1, widthCoupboxP1, heightCoupboxP1);

			// draw boudingbox player 2
			g.setColor(new Color(255,0,0,60));
			g.fillRect(posXp2hitbox, gc.getHeight()-posYp2hitbox-GROUND-heightHitboxP2, widthHitboxP2, heightHitboxP2);
			g.setColor(new Color(255,0,0,200));
			g.fillRect(posXp2Coupbox, gc.getHeight()-posYp2Coupbox-GROUND-heightCoupboxP2, widthCoupboxP2, heightCoupboxP2);
		}

		// draw player1
		int heightPlayer1 = this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation());

		if(this.window.getGame().getEngine().getPlayer(0).getFightCharacter().isFaceRight())
			this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getSpriteSheet().draw(posXp1, gc.getHeight()-(posYp1+heightPlayer1+GROUND));
		else{
			if(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation()==6)
				posXp1 = posXp1 + InformationsCharacter.getWidthSpritePersoIdle(this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter())
				- InformationsCharacter.getWidthSpritePersoKick(this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter());
			else if(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation()==5)
				posXp1 = posXp1 + InformationsCharacter.getWidthSpritePersoIdle(this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter())
				- InformationsCharacter.getWidthSpritePersoPunch(this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getNumeroCharacter());

			this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getSpriteSheet().draw(posXp1, gc.getHeight()-(posYp1+heightPlayer1+GROUND) 
					,this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getWidthAnimations(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation()),0
					,0,this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().getCurrentAnimation()));
		}
		// draw player2
		int heightPlayer2 = this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation());

		if(this.window.getGame().getEngine().getPlayer(1).getFightCharacter().isFaceRight())
			this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getSpriteSheet().draw(posXp2, gc.getHeight()-(posYp2+heightPlayer2+GROUND));
		else{
			if(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation()==6)
				posXp2 = posXp2 + InformationsCharacter.getWidthSpritePersoIdle(this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter())
				- InformationsCharacter.getWidthSpritePersoKick(this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter());
			else if(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation()==5)
				posXp2 = posXp2 + InformationsCharacter.getWidthSpritePersoIdle(this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter())
				- InformationsCharacter.getWidthSpritePersoPunch(this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getNumeroCharacter());

			this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getSpriteSheet().draw(posXp2, gc.getHeight()-(posYp2+heightPlayer2+GROUND) 
					,this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getWidthAnimations(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation()),0
					,0,this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getHeightAnimations(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().getCurrentAnimation()));
		}
	}

	@Override
	public void keyPressed(int key, char c) {

		// For debug in game
		if(key == Input.KEY_P) this.modeDebug = !this.modeDebug;

		//player 1
		else if(key== Input.KEY_Q) this.inputPlayer1[1] = 1;
		else if (key == Input.KEY_D) this.inputPlayer1[3] = 1;
		else if(key== Input.KEY_S) this.inputPlayer1[2] = 1;
		else if( key == Input.KEY_Z) this.inputPlayer1[0] = 1;
		else if(key==Input.KEY_A) this.inputPlayer1[4] = 1;
		else if(key==Input.KEY_E) this.inputPlayer1[5] = 1;
		else if(key==Input.KEY_R) this.inputPlayer1[6] = 1;


		//Player 2
		else if(key== Input.KEY_LEFT) this.inputPlayer2[1] = 1;
		else if (key == Input.KEY_RIGHT) this.inputPlayer2[3] = 1;
		else if(key== Input.KEY_DOWN) this.inputPlayer2[2] = 1;
		else if( key == Input.KEY_UP) this.inputPlayer2[0] = 1;
		else if(key==Input.KEY_K) this.inputPlayer2[4] = 1;
		else if(key==Input.KEY_L) this.inputPlayer2[5] = 1;
		else if(key==Input.KEY_M) this.inputPlayer2[6] = 1;	
	}

	@Override
	public void keyReleased(int key, char c) {

		if(key== Input.KEY_LEFT)this.inputPlayer2[1] = 2;

		//player 1
		else if(key== Input.KEY_Q)this.inputPlayer1[1] = 2;
		else if (key == Input.KEY_D)this.inputPlayer1[3] = 2;
		else if(key== Input.KEY_S)this.inputPlayer1[2] = 2;
		else if( key == Input.KEY_Z)this.inputPlayer1[0] = 2;
		else if(key==Input.KEY_A)this.inputPlayer1[4] = 2;
		else if(key==Input.KEY_E)this.inputPlayer1[5] = 2;
		else if(key==Input.KEY_R)this.inputPlayer1[6] = 2;

		//player 2
		else if (key == Input.KEY_RIGHT) this.inputPlayer2[3] = 2;
		else if(key== Input.KEY_DOWN) this.inputPlayer2[2] = 2;
		else if( key == Input.KEY_UP) this.inputPlayer2[0] = 2;
		else if(key==Input.KEY_K)this.inputPlayer2[4] = 2;
		else if(key==Input.KEY_L)this.inputPlayer2[5] = 2;
		else if(key==Input.KEY_M)this.inputPlayer2[6] = 2;

	}

	@Override
	public void update(GameContainer gc, StateBasedGame window, int delta) throws SlickException {
		this.window.getGame().getEngine().updateFace();
		updateCommand();
		this.window.getGame().getEngine().step();
		time+=delta;

		this.window.getGame().getEngine().getPlayer(0).getFightCharacter().updateY();
		this.window.getGame().getEngine().getPlayer(1).getFightCharacter().updateY();

		if(System.currentTimeMillis()-lastMs>500) // limite frame rate -> frame de 500 ms ?
		{
			if(this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer() != null){
				this.window.getGame().getEngine().getPlayer(0).getAnimationPlayer().nextFrame();
				this.window.getGame().getEngine().getPlayer(0).getFightCharacter().nextFrameTech();
				this.window.getGame().getEngine().getPlayer(0).getFightCharacter().updateDurationStunned();
			}
			if(this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer() != null){
				this.window.getGame().getEngine().getPlayer(1).getAnimationPlayer().nextFrame();
				this.window.getGame().getEngine().getPlayer(1).getFightCharacter().nextFrameTech();
				this.window.getGame().getEngine().getPlayer(1).getFightCharacter().updateDurationStunned();
			}
			lastMs = System.currentTimeMillis();

		}
		
		if(this.window.getGame().getEngine().isGameOver())
		{
			if(!this.quit){
				time = 0;
				this.quit = true;
			}
			
			if(time/1000>5){
				gc.exit();
			}
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	public void updateCommand()
	{
		for(int i=0; i<this.inputPlayer1.length;i++)
		{
			if(this.inputPlayer1[i]==1)
			{
				if(i==0) this.window.getGame().getEngine().setCommandPlayer1(Command.UP);
				if(i==1) this.window.getGame().getEngine().setCommandPlayer1(Command.LEFT_PRESSED);
				if(i==2) this.window.getGame().getEngine().setCommandPlayer1(Command.DOWN_PRESSED);
				if(i==3) this.window.getGame().getEngine().setCommandPlayer1(Command.RIGHT_PRESSED);
				if(i==4) this.window.getGame().getEngine().setCommandPlayer1(Command.PUNCH);
				if(i==5) this.window.getGame().getEngine().setCommandPlayer1(Command.BLOCK_PRESSED);
				if(i==6) this.window.getGame().getEngine().setCommandPlayer1(Command.KICK);

			}
			else if(this.inputPlayer1[i]==2)
			{
				if(i==1) this.window.getGame().getEngine().setCommandPlayer1(Command.LEFT_RELEASED);
				if(i==2) this.window.getGame().getEngine().setCommandPlayer1(Command.DOWN_RELEASED);
				if(i==3) this.window.getGame().getEngine().setCommandPlayer1(Command.RIGHT_RELEASED);
				if(i==5) this.window.getGame().getEngine().setCommandPlayer1(Command.BLOCK_RELEASED);
				this.inputPlayer1[i]=0;

			}

			
			if(this.inputPlayer2[i]==1)
			{
				if(i==0) this.window.getGame().getEngine().setCommandPlayer2(Command.UP);
				if(i==1) this.window.getGame().getEngine().setCommandPlayer2(Command.LEFT_PRESSED);
				if(i==2) this.window.getGame().getEngine().setCommandPlayer2(Command.DOWN_PRESSED);
				if(i==3) this.window.getGame().getEngine().setCommandPlayer2(Command.RIGHT_PRESSED);
				if(i==4) this.window.getGame().getEngine().setCommandPlayer2(Command.PUNCH);
				if(i==5) this.window.getGame().getEngine().setCommandPlayer2(Command.BLOCK_PRESSED);
				if(i==6) this.window.getGame().getEngine().setCommandPlayer2(Command.KICK);
			}
			else if(this.inputPlayer2[i]==2)
			{
				if(i==1) this.window.getGame().getEngine().setCommandPlayer2(Command.LEFT_RELEASED);
				if(i==2) this.window.getGame().getEngine().setCommandPlayer2(Command.DOWN_RELEASED);
				if(i==3) this.window.getGame().getEngine().setCommandPlayer2(Command.RIGHT_RELEASED);
				if(i==5) this.window.getGame().getEngine().setCommandPlayer2(Command.BLOCK_RELEASED);

				this.inputPlayer2[i]=0;
			}
		}
	}

}