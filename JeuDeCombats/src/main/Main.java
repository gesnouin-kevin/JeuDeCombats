package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	static private AppGameContainer app;

	public static void main( String[] args ) throws SlickException
	{
		app = new AppGameContainer( new Game() );
		app.setTargetFrameRate(60);
		app.setDisplayMode( 1366, 768, false );
		app.start();
	}
}
