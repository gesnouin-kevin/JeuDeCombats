package IHMBug;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import personnages.InformationsCharacter;

public class SelectionCharacterBug extends BasicGameState {

	public static final int ID = 2;
	public static int NB_BACKGROUND = 5;
	private StateBasedGame game;
	private WindowBug window;
	private SpriteSheet cursorSelectCharacter;
	private SpriteSheet iconCharacter;
	private SpriteSheet selectionCharacter;
	private SpriteSheet[] background;
	private int currentBackground = 1;


	// numero of character 0 -> 17  -warning- 0 and 5 place for 1P and 2P
	private int cursorPlayer1 = 1;
	private int cursorPlayer2 = 4;

	private  boolean character1Select = false;
	private  boolean character2Select = false;

	public SelectionCharacterBug(WindowBug window) {
		this.window = window;
		this.background = new SpriteSheet[NB_BACKGROUND];
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		this.game = game;
		gc.getInput().enableKeyRepeat();
		this.cursorSelectCharacter = new SpriteSheet("ressources/menu/cursorSelectCharacter.png", 42, 64);
		this.iconCharacter = new SpriteSheet("ressources/menu/iconCharacter2.png", 976, 194);
		this.selectionCharacter = new SpriteSheet("ressources/menu/selectionCharacter.png", 256, 193);
		for(int i=0; i<NB_BACKGROUND;i++)
			this.background[i] = new SpriteSheet("ressources/background/background"+(i+1)+"frame0.png", 800, 336);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame window, Graphics g) throws SlickException {

		this.selectionCharacter.draw(0, 0, gc.getWidth(), gc.getHeight());
		// more character coming soon
		g.setColor(new Color(0,0,0,200));
		g.fillRect(346, 210, 675, 255);

		float scaleX =  (gc.getWidth()/256f);
		float scaleY = (gc.getHeight()/193f);

		float widthSelector  = (42f/2)*scaleX;
		float heightSelector  = (64f/2)*scaleY;

		// draw cursor player1
		int linePlayer1 = (this.cursorPlayer1/6);
		int columnPlayer1 = (this.cursorPlayer1)%6;
		float x1Player1 = 64*scaleX+widthSelector*(columnPlayer1);
		float x2Player1 = x1Player1 + widthSelector;
		float y1Player1 = 20*scaleY+heightSelector*(linePlayer1);
		float y2Player1 = y1Player1 + heightSelector;
		if(!this.character1Select)
			this.cursorSelectCharacter.draw(x1Player1, y1Player1, x2Player1, y2Player1, 0, 0, 42/2, 64/2);
		else
			this.cursorSelectCharacter.draw(x1Player1, y1Player1, x2Player1, y2Player1, 42/2, 0, 42, 64/2);

		// draw cursor player 2
		int linePlayer2 = (this.cursorPlayer2/6);
		int columnPlayer2 = (this.cursorPlayer2)%6;
		float x1Player2 = 64*scaleX+widthSelector*(columnPlayer2);
		float x2Player2 = x1Player2 + widthSelector;
		float y1Player2 = 20*scaleY+heightSelector*(linePlayer2);
		float y2Player2 = y1Player2 + heightSelector;

		if(!this.character2Select)
			this.cursorSelectCharacter.draw(x1Player2, y1Player2, x2Player2, y2Player2, 0, 64/2, 42/2, 64);
		else
			this.cursorSelectCharacter.draw(x1Player2, y1Player2, x2Player2, y2Player2, 42/2, 64/2, 42, 64);

		int cursor1=1;
		int cursor2=1;
		// 2 empty case in table
		if(this.cursorPlayer1<=4)
			cursor1 = this.cursorPlayer1-1;
		else
			cursor1 = this.cursorPlayer1-2;

		if(this.cursorPlayer2<=4)
			cursor2 = this.cursorPlayer2-1;
		else
			cursor2 = this.cursorPlayer2-2;

		// draw head player1
		this.iconCharacter.draw(8*scaleX, 14*scaleY , 8*scaleX+61*scaleX, 14*scaleY+97*scaleY, cursor1*61, 0, cursor1*61+61, 97);

		// draw head player2
		this.iconCharacter.draw(192*scaleX, 14*scaleY , 192*scaleX+61*scaleX, 14*scaleY+97*scaleY, cursor2*61, 97, cursor2*61+61, 194);


		// draw map choice
		this.background[this.currentBackground].draw(gc.getWidth()/2-(80/2)*scaleX, 135*scaleY, gc.getWidth()/2+(80/2)*scaleX, 135*scaleY+40*scaleY, 0, 0, 800, 336);

		//draw keys help
		g.setColor(new Color(255,255,255));
		g.drawString("-- Player 1 --", 130, gc.getHeight()-300);
		g.drawString("Q, Z, S and D for move cursor  --> E for lock", 20, gc.getHeight()-280);
		g.drawString("-- Player 2 --", gc.getWidth()-320, gc.getHeight()-300);
		g.drawString("Arrow keys for move cursor  --> Enter for lock", gc.getWidth() -450, gc.getHeight()-280);

		g.drawString("-- U and I for switch Arena --", gc.getWidth()/2-100, gc.getHeight()-50);

	}

	@Override
	public void keyPressed(int key, char c) {

		if(key == Input.KEY_U)
		{
			if(this.currentBackground-1>=0)
				this.currentBackground--;
			else
				this.currentBackground = 4;
		}
		if(key == Input.KEY_I)
		{
			if(this.currentBackground+1<=4)
				this.currentBackground++;
			else
				this.currentBackground = 0;
		}

		if(!this.character2Select){
			if (key == Input.KEY_RIGHT){
				if((this.cursorPlayer2%6)+1<=5)
					this.cursorPlayer2 ++;
				else
					this.cursorPlayer2 -=5;

				if(this.cursorPlayer2 == 5)
					this.cursorPlayer2 = 1;
			}
			if(key== Input.KEY_LEFT){ 
				if((this.cursorPlayer2%6-1)>=0)
					this.cursorPlayer2 --;
				else
					this.cursorPlayer2 +=5;

				if(this.cursorPlayer2 == 0)
					this.cursorPlayer2 = 4;
			}
/*
			if(key== Input.KEY_DOWN){ 
				if(this.cursorPlayer2+6<=17)
					this.cursorPlayer2 +=6;
				else
					this.cursorPlayer2 %= 6;

				if(this.cursorPlayer2 == 0)
					this.cursorPlayer2 = 6;
				else if(this.cursorPlayer2 == 5)
					this.cursorPlayer2 = 11;
			}

			if( key == Input.KEY_UP){ 
				if(this.cursorPlayer2-6>=0)
					this.cursorPlayer2 -=6;
				else
					this.cursorPlayer2 = 17 - (5-this.cursorPlayer2);

				if(this.cursorPlayer2 == 0)
					this.cursorPlayer2 = 12;
				else if(this.cursorPlayer2 == 5)
					this.cursorPlayer2 = 17;
			}
*/
			if(key==Input.KEY_ENTER){
				this.character2Select = true;
				int cursor2;
				// 2 empty case in table
				if(this.cursorPlayer2<=4)
					cursor2 = this.cursorPlayer2-1;
				else
					cursor2 = this.cursorPlayer2-2;
				this.window.getGame().getEngine().getPlayer(1).getFightCharacter().setNumeroCharacter(cursor2);
			}
		}

		if(!this.character1Select){
			if(key == Input.KEY_D) {
				if((this.cursorPlayer1%6)+1<=5)
					this.cursorPlayer1 ++;
				else
					this.cursorPlayer1 -=5;

				if(this.cursorPlayer1 == 5)
					this.cursorPlayer1 = 1;
			}

			if(key == Input.KEY_Q){ 
				if((this.cursorPlayer1%6-1)>=0)
					this.cursorPlayer1 --;
				else
					this.cursorPlayer1 +=5;

				if(this.cursorPlayer1 == 0)
					this.cursorPlayer1 = 4;
			}
/*
			if(key == Input.KEY_S){ 
				if(this.cursorPlayer1+6<=17)
					this.cursorPlayer1 +=6;
				else
					this.cursorPlayer1 %= 6;

				if(this.cursorPlayer1 == 0)
					this.cursorPlayer1 = 6;
				else if(this.cursorPlayer1 == 5)
					this.cursorPlayer1 = 11;
			}

			if(key == Input.KEY_Z){
				if(this.cursorPlayer1-6>=0)
					this.cursorPlayer1 -=6;
				else
					this.cursorPlayer1 = 17 - (5-this.cursorPlayer1);

				if(this.cursorPlayer1 == 0)
					this.cursorPlayer1 = 12;
				else if(this.cursorPlayer1 == 5)
					this.cursorPlayer1 = 17;
			}
*/
			if(key == Input.KEY_E){
				this.character1Select = true;
				int cursor1;
				// 2 empty case in table
				if(this.cursorPlayer1<=4)
					cursor1 = this.cursorPlayer1-1;
				else
					cursor1 = this.cursorPlayer1-2;
				this.window.getGame().getEngine().getPlayer(0).getFightCharacter().setNumeroCharacter(cursor1);
			}
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		if(this.character1Select && this.character2Select){
			int cursor1;
			if(this.cursorPlayer1<=4)
				cursor1 = this.cursorPlayer1-1;
			else
				cursor1 = this.cursorPlayer1-2;
			int cursor2;
			if(this.cursorPlayer2<=4)
				cursor2 = this.cursorPlayer2-1;
			else
				cursor2 = this.cursorPlayer2-2;

			this.window.setCurrentBackground(this.currentBackground);
			this.window.getGame().getEngine().getPlayer(0).getFightCharacter().init(InformationsCharacter.getLife(cursor1), 
					InformationsCharacter.getSpeed(cursor1), true, 0);
			this.window.getGame().getEngine().getPlayer(1).getFightCharacter().init(InformationsCharacter.getLife(cursor2), 
					InformationsCharacter.getSpeed(cursor2), false, 1);


			this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getRectangleHitbox().setWidthHeight(
					InformationsCharacter.getWidthSpritePersoIdle(cursor1),
					InformationsCharacter.getHeightSpritePersoIdle(cursor1));

			this.window.getGame().getEngine().getPlayer(1).getFightCharacter().getRectangleHitbox().setWidthHeight(
					InformationsCharacter.getWidthSpritePersoIdle(cursor2),
					InformationsCharacter.getHeightSpritePersoIdle(cursor2));

			// décaler p1 sur les x pour centrer
			int posXp1 = this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getPositionX();
			int widthp1 = InformationsCharacter.getWidthSpritePersoIdle(cursor1);

			this.window.getGame().getEngine().getPlayer(0).getFightCharacter().setPositionX(posXp1-widthp1);
			this.window.getGame().getEngine().getPlayer(0).getFightCharacter().getRectangleHitbox().setPosX(posXp1-widthp1);

			this.window.getState(FightingBug.ID).init(gc, game);
			this.game.enterState(FightingBug.ID);
		}

	}

	@Override
	public int getID() {
		return ID;
	}
}