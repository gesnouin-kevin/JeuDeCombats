package personnages;

public abstract class InformationsCharacter {

	private static int life[]={60,80,80,60,60,40,100,40,100,100,60,40,60,40,80,60};
	private static int speed[]={3,2,4,3,4,4,1,1,3,3,4,5,3,5,3,4};
	private static int damage[]={8,10,6,8,6,4,10,6,8,8,8,6,8,6,10,10};
	
	private static int widthSpritePersoIdle[]={183};
	private static int heightSpritePersoIdle[]={349};
	private static int nbSpritePersoIdle[]={4};

	public static int getLife(int numeroPerso)
	{
		return InformationsCharacter.life[numeroPerso];
	}

	public static int getSpeed(int numeroPerso)
	{
		return InformationsCharacter.speed[numeroPerso];
	}
	
	public static int getDamage(int numeroPerso)
	{
		return InformationsCharacter.damage[numeroPerso];
	}
	
	public static int getWidthSpritePersoIdle(int numeroPerso)
	{
		return InformationsCharacter.widthSpritePersoIdle[numeroPerso];
	}
	
	public static int getHeightSpritePersoIdle(int numeroPerso)
	{
		return InformationsCharacter.heightSpritePersoIdle[numeroPerso];
	}
	
	public static int getNbSpritePersoIdle(int numeroPerso)
	{
		return InformationsCharacter.nbSpritePersoIdle[numeroPerso];
	}

}
