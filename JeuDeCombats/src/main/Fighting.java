package main;

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

	private Game game;
	private Window window;
	private Animation[] animationsBackground;
	private SpriteSheet iconCharacter;
	private SpriteSheet iconKO;

	private ArrayList<Animation> animationsPlayer1;
	private ArrayList<Animation> animationsPlayer2;

	private boolean modeDebug;

	public Fighting(Window window) {
		this.window = window;

		this.animationsBackground = new Animation[NB_BACKGROUND];
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		gc.getInput().enableKeyRepeat();
		this.animationsPlayer1 = new ArrayList<Animation>();
		this.animationsPlayer2 = new ArrayList<Animation>();
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

		// load icon and image KO
		this.iconKO = new SpriteSheet("ressources/fight/iconKO.png", 40, 31);
		this.iconCharacter = new SpriteSheet("ressources/menu/iconCharacter2.png", 976, 194);

		// load animations characters
		loadAnimationsPlayers(0);
		loadAnimationsPlayers(1);


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
		int animPlayer1 =0;
		int heightPlayer1 =InformationsCharacter.getHeightSpritePersoIdle(this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter());
		if(this.window.getGame().getEngine().getPlayer(0).getCharacter().isRunning()){
			animPlayer1 = 2;
			heightPlayer1 = InformationsCharacter.getHeightSpritePersoWalking(this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter());
		}
		else if(this.window.getGame().getEngine().getPlayer(0).getCharacter().isCrouching()){
			animPlayer1 = 6;
			heightPlayer1 = InformationsCharacter.getHeightSpritePersoCrouch(this.window.getGame().getEngine().getPlayer(0).getCharacter().getNumeroCharacter());
		}

		if(!this.window.getGame().getEngine().getPlayer(0).getCharacter().isFaceRight())
			animPlayer1 += 1;
		
		System.out.println("size1"+this.animationsPlayer1.size());
		System.out.println("size2"+this.animationsPlayer2.size());
		
		g.drawAnimation(this.animationsPlayer1.get(animPlayer1), posXp1, gc.getHeight()-(posYp1+heightPlayer1-GROUND));

		// draw player2
		int animPlayer2 =0;
		int heightPlayer2=InformationsCharacter.getHeightSpritePersoIdle(this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter());
		if(this.window.getGame().getEngine().getPlayer(1).getCharacter().isRunning())
		{
			animPlayer2 = 2;
			heightPlayer2 = InformationsCharacter.getHeightSpritePersoWalking(this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter());
		}
		else if(this.window.getGame().getEngine().getPlayer(1).getCharacter().isCrouching())
		{
			animPlayer2 = 6;
			heightPlayer2 = InformationsCharacter.getHeightSpritePersoWalking(this.window.getGame().getEngine().getPlayer(1).getCharacter().getNumeroCharacter());
		}
		if(!this.window.getGame().getEngine().getPlayer(1).getCharacter().isFaceRight())
			animPlayer2 += 1;
		g.drawAnimation(this.animationsPlayer2.get(animPlayer2), posXp2, gc.getHeight()-(posYp2+heightPlayer2-GROUND));
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
	}

	@Override
	public int getID() {
		return ID;
	}

	public void loadAnimationsPlayers(int player) throws SlickException
	{
		if(player==0)
			this.animationsPlayer1 = new ArrayList<Animation>();
		else
			this.animationsPlayer2 = new ArrayList<Animation>();

		int numPlayer = this.window.getGame().getEngine().getPlayer(player).getCharacter().getNumeroCharacter();
		SpriteSheet s = new SpriteSheet("ressources/fight/"+numPlayer+".png", 1413, 2096);

		int heightSrc = 0;

		for(int i=0; i<NB_MAX_ANIMATION;  i++)
		{
			Animation anim = new Animation();
			int currentXsrc;

			if(i%2==0)//i est pair
			{
				currentXsrc = 0;
				for(int j=0;j<getNbAnimations(i, numPlayer);j++)
				{
					anim.addFrame(s.getSubImage(getWidthAnimations(i, numPlayer)*j, heightSrc, getWidthAnimations(i, numPlayer), getHeightAnimations(i, numPlayer)), 100);

					currentXsrc+=getWidthAnimations(i, numPlayer);
				}
			}
			else
			{
				currentXsrc = (getNbAnimations(i, numPlayer)-1) * getWidthAnimations(i, numPlayer);
				for(int j=getNbAnimations(i, numPlayer)-1;j>=0;j--)
				{
					anim.addFrame(s.getSubImage(getWidthAnimations(i, numPlayer)*j, heightSrc, getWidthAnimations(i, numPlayer), getHeightAnimations(i, numPlayer)), 100);

					currentXsrc-=getWidthAnimations(i, numPlayer);
				}
			}

			if(player==0){
				this.animationsPlayer1.add(anim);
			}
			else
				this.animationsPlayer2.add(anim);

			heightSrc += getHeightAnimations(i, numPlayer);
		}
	}

	public int getNbAnimations(int animation, int numPlayer)
	{
		if(animation == 0 || animation ==1) return InformationsCharacter.getNbSpritePersoIdle(numPlayer);
		if(animation == 2 || animation ==3) return InformationsCharacter.getNbSpritePersoWalking(numPlayer);
		if(animation == 4 || animation ==5) return InformationsCharacter.getNbSpritePersoJump(numPlayer);
		if(animation == 6 || animation ==7) return InformationsCharacter.getNbSpritePersoCrouch(numPlayer);

		return 0;
	}

	public int getWidthAnimations(int animation, int numPlayer)
	{
		if(animation == 0 || animation ==1) return InformationsCharacter.getWidthSpritePersoIdle(numPlayer);
		if(animation == 2 || animation ==3) return InformationsCharacter.getWidthSpritePersoWalking(numPlayer);
		if(animation == 4 || animation ==5) return InformationsCharacter.getWidthSpritePersoJump(numPlayer);
		if(animation == 6 || animation ==7) return InformationsCharacter.getWidthSpritePersoCrouch(numPlayer);

		return 0;
	}

	public int getHeightAnimations(int animation, int numPlayer)
	{
		if(animation == 0 || animation ==1) return InformationsCharacter.getHeightSpritePersoIdle(numPlayer);
		if(animation == 2 || animation ==3) return InformationsCharacter.getHeightSpritePersoWalking(numPlayer);
		if(animation == 4 || animation ==5) return InformationsCharacter.getHeightSpritePersoJump(numPlayer);
		if(animation == 6 || animation ==7) return InformationsCharacter.getHeightSpritePersoCrouch(numPlayer);

		return 0;
	}

}