package IHMBug;

import org.newdawn.slick.AppGameContainer;
import contract.EngineContract;
import implementationBug.EngineImplBug;
import implementationBug.PlayerImplBug;
import IHM.*;

public class GameBug{


	static private int WINDOW_WIDTH = 1366;
	static private int WINDOW_HEIGHT = 768;
	static private AppGameContainer app;
	private WindowBug window;
	private EngineContract ec;


	public GameBug() {
		this.ec = new EngineContract(new EngineImplBug());
		this.ec.init(WINDOW_HEIGHT, WINDOW_WIDTH, 600, new PlayerImplBug(), new PlayerImplBug());
		this.window = new WindowBug(this, WINDOW_WIDTH, WINDOW_HEIGHT);

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
