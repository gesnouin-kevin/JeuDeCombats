package IHM;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import personnages.InformationsCharacter;

public class Animation {
	
	public static int NB_MAX_ANIMATION = 11;

	private int currentFrame;
	private int currentAnimation;

	private ArrayList<ArrayList<SpriteSheet>> images;
	private int numPlayer;
	private Game game;
	private boolean repeatAnimation;

	public Animation(int numPlayer, Game game){
		this.currentFrame=0;
		this.currentAnimation=0;
		this.numPlayer = numPlayer;
		this.game = game;
		this.images=new ArrayList<ArrayList<SpriteSheet>>();
		this.repeatAnimation = true;
		
		try {
			loadSprite();
		} catch (SlickException e) {}
		
	}


	public void nextFrame()
	{
		if(this.currentFrame<getNbAnimations(this.currentAnimation)-1) // nextFrame
			this.currentFrame++;
		else if(this.repeatAnimation) // repeat animation
			this.currentFrame = 0;
		else	// animation end
		{
			this.currentFrame = 0;
			this.currentAnimation = 0;
			this.repeatAnimation = true;
		}
			
	}
	
	public SpriteSheet getSpriteSheet()
	{
		return this.images.get(currentAnimation).get(currentFrame);
	}
	
	public void loadSprite() throws SlickException
	{
		for(int i=0;i<NB_MAX_ANIMATION;i++)
		{
			this.images.add(new ArrayList<SpriteSheet>());
			SpriteSheet s = new SpriteSheet("ressources/fight/"+this.numPlayer+"/"+i+".png", getWidthAnimations(i)*getNbAnimations(i), getHeightAnimations(i));
			
			for(int j=0;j<getNbAnimations(i);j++)
			{
				Image image = s.getSubImage(j*getWidthAnimations(i), 0, getWidthAnimations(i), getHeightAnimations(i));
				SpriteSheet frame = new SpriteSheet( image, getWidthAnimations(i), getHeightAnimations(i));
				this.images.get(i).add(frame);
			}
		}
	}
	
	public int getNbAnimations(int animation)
	{
		if(animation == 0) return InformationsCharacter.getNbSpritePersoIdle(numPlayer);
		if(animation == 1) return InformationsCharacter.getNbSpritePersoWalking(numPlayer);
		if(animation == 2) return InformationsCharacter.getNbSpritePersoJump(numPlayer);
		if(animation == 3) return InformationsCharacter.getNbSpritePersoCrouch(numPlayer);

		return 0;
	}

	public int getWidthAnimations(int animation)
	{
		if(animation == 0) return InformationsCharacter.getWidthSpritePersoIdle(numPlayer);
		if(animation == 1) return InformationsCharacter.getWidthSpritePersoWalking(numPlayer);
		if(animation == 2) return InformationsCharacter.getWidthSpritePersoJump(numPlayer);
		if(animation == 3) return InformationsCharacter.getWidthSpritePersoCrouch(numPlayer);

		return 0;
	}

	public int getHeightAnimations(int animation)
	{
		if(animation == 0) return InformationsCharacter.getHeightSpritePersoIdle(numPlayer);
		if(animation == 1) return InformationsCharacter.getHeightSpritePersoWalking(numPlayer);
		if(animation == 2) return InformationsCharacter.getHeightSpritePersoJump(numPlayer);
		if(animation == 3) return InformationsCharacter.getHeightSpritePersoCrouch(numPlayer);

		return 0;
	}
	
	public void setRepeatAnimation(boolean repeatAnimation) {
		this.repeatAnimation = repeatAnimation;
	}
	
	public int getCurrentAnimation() {
		return currentAnimation;
	}


	public void setCurrentAnimation(int currentAnimation) {
		if(this.currentAnimation != currentAnimation)
			this.currentFrame = 0;
		this.currentAnimation = currentAnimation;
	}

}