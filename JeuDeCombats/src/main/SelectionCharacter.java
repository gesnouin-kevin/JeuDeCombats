package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SelectionCharacter extends BasicGameState {

	public static final int ID = 2;
	private StateBasedGame game;
	private Window window;
	private SpriteSheet cursorSelectCharacter;
	private SpriteSheet iconCharacter;
	private SpriteSheet selectionCharacter;

	// numero of character 0 -> 17  -warning- 0 and 5 place for 1P and 2P
	private int cursorPlayer1 = 1;
	private int cursorPlayer2 = 4;

	private  boolean character1Select = false;
	private  boolean character2Select = false;

	public SelectionCharacter(Window window) {
		this.window = window;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		this.game = game;
		this.cursorSelectCharacter = new SpriteSheet("ressources/menu/cursorSelectCharacter.png", 42, 64);
		this.iconCharacter = new SpriteSheet("ressources/menu/iconCharacter2.png", 976, 194);
		this.selectionCharacter = new SpriteSheet("ressources/menu/selectionCharacter.png", 256, 193);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame window, Graphics g) throws SlickException {



		this.selectionCharacter.draw(0, 0, gc.getWidth(), gc.getHeight());

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
		this.iconCharacter.draw(192*scaleX, 14*scaleY , 192*scaleX+61*scaleX, 14*scaleY+97*scaleY, (15-cursor2)*61, 97, (15-cursor2)*61+61, 194);
	}

	@Override
	public void keyPressed(int key, char c) {
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

			if(key==Input.KEY_ENTER){
				this.character2Select = true;
				int cursor2;
				// 2 empty case in table
				if(this.cursorPlayer2<=4)
					cursor2 = this.cursorPlayer2-1;
				else
					cursor2 = this.cursorPlayer2-2;
				this.window.setNumeroCharacterPlayer2(cursor2);
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

			if(key == Input.KEY_E){
				this.character1Select = true;
				int cursor1;
				// 2 empty case in table
				if(this.cursorPlayer1<=4)
					cursor1 = this.cursorPlayer1-1;
				else
					cursor1 = this.cursorPlayer1-2;
				this.window.setNumeroCharacterPlayer1(cursor1);
			}
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame window, int delta) throws SlickException {
		if(this.character1Select && this.character2Select)
			game.enterState(Fighting.ID);

	}

	@Override
	public int getID() {
		return ID;
	}
}