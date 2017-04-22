package main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {

	private GameContainer gc;
	private Image map;

	public Game(){
		super( "GameWindow" );
	}

	//charger et initialiser les ressources
	@Override
	public void init( GameContainer gc ) throws SlickException{
		this.gc = gc;
	    this.map = new Image("ressources/map/gif1.gif");
	}

	//dessiner � l��cran
	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException{
		g.drawImage(this.map,0,0);
		g.setColor(new Color(255, 0, 0, 65));
		g.fillRect(5, 5, 1000, 1000);
		g.setColor(new Color(0, 255, 0, 65));
		g.fillRect(500, 500, 1000, 1000);
		
		
	}

	//mettre � jour le jeu en fonction des entr�es utilisateurs ou autre
	@Override
	public void update( GameContainer gc, int delta ) throws SlickException{
	}

}
