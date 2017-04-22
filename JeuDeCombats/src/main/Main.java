package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	static private AppGameContainer app;

	public static void main( String[] args ) throws SlickException
	{
		app = new AppGameContainer( new Game() );
		app.setDisplayMode( 1920, 1080, false );
		app.start();
	}
}
