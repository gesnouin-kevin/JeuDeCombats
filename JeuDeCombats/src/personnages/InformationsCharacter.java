package personnages;

public abstract class InformationsCharacter {

	private static int life[]={60,80,80,60,60,40,100,40,100,100,60,40,60,40,80,60};
	private static int speed[]={8,4,8,6,8,8,2,2,4,4,8,10,6,10,6,8};
	private static int damage[]={8,10,6,8,6,4,10,6,8,8,8,6,8,6,10,10};
	
	private static int widthSpritePersoIdle[]={182,0,0,0,0,207};
	private static int heightSpritePersoIdle[]={345,0,0,0,0,350};
	private static int nbSpritePersoIdle[]={4,0,0,0,0,4};
	
	private static int widthSpritePersoWalking[]={182,0,0,0,0,230};
	private static int heightSpritePersoWalking[]={345,0,0,0,0,360};
	private static int nbSpritePersoWalking[]={5,0,0,0,0,8};
	
	private static int widthSpritePersoJump[]={182,0,0,0,0,205};
	private static int heightSpritePersoJump[]={380,0,0,0,0,428};
	private static int nbSpritePersoJump[]={4,0,0,0,0,4};
	
	private static int widthSpritePersoCrouch[]={182,0,0,0,0,205};
	private static int heightSpritePersoCrouch[]={228,0,0,0,0,266};
	private static int nbSpritePersoCrouch[]={1,0,0,0,0,1};
	
	private static int widthSpritePersoBlocking[]={182,0,0,0,0,219};
	private static int heightSpritePersoBlocking[]={345,0,0,0,0,340};
	private static int nbSpritePersoBlocking[]={4,0,0,0,0,2};
	
	private static int widthSpritePersoPunch[]={182,0,0,0,0,384};
	private static int heightSpritePersoPunch[]={345,0,0,0,0,340};
	private static int nbSpritePersoPunch[]={4,0,0,0,0,3};
	
	private static int widthSpritePersoKick[]={182,0,0,0,0,366};
	private static int heightSpritePersoKick[]={345,0,0,0,0,388};
	private static int nbSpritePersoKick[]={4,0,0,0,0,5};
	
	private static int widthSpritePersoHit[]={182,0,0,0,0,290};
	private static int heightSpritePersoHit[]={345,0,0,0,0,306};
	private static int nbSpritePersoHit[]={4,0,0,0,0,2};
	
	private static int widthSpritePersoCrouchHit[]={182,0,0,0,0,237};
	private static int heightSpritePersoCrouchHit[]={345,0,0,0,0,248};
	private static int nbSpritePersoCrouchHit[]={4,0,0,0,0,1};
	
	private static int widthSpritePersoKo[]={182,0,0,0,0,357};
	private static int heightSpritePersoKo[]={345,0,0,0,0,283};
	private static int nbSpritePersoKo[]={4,0,0,0,0,4};
	
	private static int widthSpritePersoVictory[]={182,0,0,0,0,203};
	private static int heightSpritePersoVictory[]={345,0,0,0,0,384};
	private static int nbSpritePersoVictory[]={4,0,0,0,0,3};

	public static int getLife(int numeroPerso){return InformationsCharacter.life[numeroPerso];}
	public static int getSpeed(int numeroPerso){return InformationsCharacter.speed[numeroPerso];}
	public static int getDamage(int numeroPerso){return InformationsCharacter.damage[numeroPerso];}
	
	public static int getWidthSpritePersoIdle(int numeroPerso){return InformationsCharacter.widthSpritePersoIdle[numeroPerso];}
	public static int getHeightSpritePersoIdle(int numeroPerso){return InformationsCharacter.heightSpritePersoIdle[numeroPerso];}
	public static int getNbSpritePersoIdle(int numeroPerso){return InformationsCharacter.nbSpritePersoIdle[numeroPerso];}
	
	public static int getWidthSpritePersoWalking(int numeroPerso){return InformationsCharacter.widthSpritePersoWalking[numeroPerso];}
	public static int getHeightSpritePersoWalking(int numeroPerso){return InformationsCharacter.heightSpritePersoWalking[numeroPerso];}
	public static int getNbSpritePersoWalking(int numeroPerso){return InformationsCharacter.nbSpritePersoWalking[numeroPerso];}
	
	public static int getWidthSpritePersoJump(int numeroPerso){return InformationsCharacter.widthSpritePersoJump[numeroPerso];}
	public static int getHeightSpritePersoJump(int numeroPerso){return InformationsCharacter.heightSpritePersoJump[numeroPerso];}
	public static int getNbSpritePersoJump(int numeroPerso){return InformationsCharacter.nbSpritePersoJump[numeroPerso];}
	
	public static int getWidthSpritePersoCrouch(int numeroPerso){return InformationsCharacter.widthSpritePersoCrouch[numeroPerso];}
	public static int getHeightSpritePersoCrouch(int numeroPerso){return InformationsCharacter.heightSpritePersoCrouch[numeroPerso];}
	public static int getNbSpritePersoCrouch(int numeroPerso){return InformationsCharacter.nbSpritePersoCrouch[numeroPerso];}

}
