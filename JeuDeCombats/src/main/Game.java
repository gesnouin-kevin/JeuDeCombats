package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;

public class Game{



	static private AppGameContainer app;
	private Window window;

	private int currentBackground = 2;

	public Game() {
		this.window = new Window(this);

		try{
			app = new AppGameContainer(this.window);
			app.setTargetFrameRate(60);
			app.setDisplayMode( 1366, 768, false );
			app.start();
		}
		catch(Exception e){System.out.println(e);}
	}
	
	public int getCurrentBackground(){return this.currentBackground;}
}
