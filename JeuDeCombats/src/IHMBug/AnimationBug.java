package IHMBug;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import personnages.InformationsCharacter;

public class AnimationBug {
	
	public static int NB_MAX_ANIMATION = 11;

	private int currentFrame;
	private int currentAnimation;
	private boolean repeatAnimation;
	private int numPlayer;
	
	private ArrayList<ArrayList<SpriteSheet>> images;

	public AnimationBug(int numPlayer){
		this.currentFrame=0;
		this.currentAnimation=0;
		this.numPlayer = numPlayer;
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
		
		else if(this.currentAnimation!=9)	// animation end
		{
			this.setCurrentAnimation(0);
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
		if(animation == 4) return InformationsCharacter.getNbSpritePersoBlocking(numPlayer);
		if(animation == 5) return InformationsCharacter.getNbSpritePersoPunch(numPlayer);
		if(animation == 6) return InformationsCharacter.getNbSpritePersoKick(numPlayer);
		if(animation == 7) return InformationsCharacter.getNbSpritePersoHit(numPlayer);
		if(animation == 8) return InformationsCharacter.getNbSpritePersoCrouchHit(numPlayer);
		if(animation == 9) return InformationsCharacter.getNbSpritePersoKo(numPlayer);
		if(animation == 10) return InformationsCharacter.getNbSpritePersoVictory(numPlayer);

		return 0;
	}

	public int getWidthAnimations(int animation)
	{
		if(animation == 0) return InformationsCharacter.getWidthSpritePersoIdle(numPlayer);
		if(animation == 1) return InformationsCharacter.getWidthSpritePersoWalking(numPlayer);
		if(animation == 2) return InformationsCharacter.getWidthSpritePersoJump(numPlayer);
		if(animation == 3) return InformationsCharacter.getWidthSpritePersoCrouch(numPlayer);
		if(animation == 4) return InformationsCharacter.getWidthSpritePersoBlocking(numPlayer);
		if(animation == 5) return InformationsCharacter.getWidthSpritePersoPunch(numPlayer);
		if(animation == 6) return InformationsCharacter.getWidthSpritePersoKick(numPlayer);
		if(animation == 7) return InformationsCharacter.getWidthSpritePersoHit(numPlayer);
		if(animation == 8) return InformationsCharacter.getWidthSpritePersoCrouchHit(numPlayer);
		if(animation == 9) return InformationsCharacter.getWidthSpritePersoKo(numPlayer);
		if(animation == 10) return InformationsCharacter.getWidthSpritePersoVictory(numPlayer);

		return 0;
	}

	public int getHeightAnimations(int animation)
	{
		if(animation == 0) return InformationsCharacter.getHeightSpritePersoIdle(numPlayer);
		if(animation == 1) return InformationsCharacter.getHeightSpritePersoWalking(numPlayer);
		if(animation == 2) return InformationsCharacter.getHeightSpritePersoJump(numPlayer);
		if(animation == 3) return InformationsCharacter.getHeightSpritePersoCrouch(numPlayer);
		if(animation == 4) return InformationsCharacter.getHeightSpritePersoBlocking(numPlayer);
		if(animation == 5) return InformationsCharacter.getHeightSpritePersoPunch(numPlayer);
		if(animation == 6) return InformationsCharacter.getHeightSpritePersoKick(numPlayer);
		if(animation == 7) return InformationsCharacter.getHeightSpritePersoHit(numPlayer);
		if(animation == 8) return InformationsCharacter.getHeightSpritePersoCrouchHit(numPlayer);
		if(animation == 9) return InformationsCharacter.getHeightSpritePersoKo(numPlayer);
		if(animation == 10) return InformationsCharacter.getHeightSpritePersoVictory(numPlayer);

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
		{
			this.currentFrame = 0;
			if(currentAnimation==0 || currentAnimation==1 || currentAnimation == 3 || currentAnimation == 4 || currentAnimation==10)
				this.repeatAnimation = true;
			else
				this.repeatAnimation = false;
		}
		this.currentAnimation = currentAnimation;
	}
	
	public int getCurrentFrame()
	{
		return this.currentFrame;
	}

}