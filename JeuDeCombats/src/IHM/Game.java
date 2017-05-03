package IHM;

import org.newdawn.slick.AppGameContainer;
import contract.EngineContract;
import implementation.EngineImpl;
import implementation.PlayerImpl;

public class Game{


	static private int WINDOW_WIDTH = 1366;
	static private int WINDOW_HEIGHT = 768;
	static private AppGameContainer app;
	private Window window;
	private EngineContract ec;


	public Game() {
		this.ec = new EngineContract(new EngineImpl());
		this.ec.init(WINDOW_HEIGHT, WINDOW_WIDTH, 600, new PlayerImpl(), new PlayerImpl());
		this.window = new Window(this, WINDOW_WIDTH, WINDOW_HEIGHT);

		try{
			app = new AppGameContainer(this.window);
			app.setTargetFrameRate(60);
			app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
			app.setShowFPS(false);
			app.start();
		}
		catch(Exception e){System.out.println(e);}
	}
	
	public EngineContract getEngine()
	{
		return this.ec;
	}
}
