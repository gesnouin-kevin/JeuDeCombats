package personnages;

public abstract class InformationsCharacter {

	private static int life[]={60,80,80,60,60,40,100,40,100,100,60,40,60,40,80,60};
	private static int speed[]={8,4,8,6,8,8,2,2,4,4,8,10,6,10,6,8};
	private static int damage[]={8,10,6,8,6,4,10,6,8,8,8,6,8,6,10,10};
	
	private static int widthSpritePersoIdle[]={182,299,234,205,0,207};
	private static int heightSpritePersoIdle[]={345,366,321,349,0,350};
	private static int nbSpritePersoIdle[]={4,4,4,3,0,4};
	
	private static int widthSpritePersoWalking[]={182,326,233,200,0,230};
	private static int heightSpritePersoWalking[]={345,353,262,358,0,360};
	private static int nbSpritePersoWalking[]={5,4,8,5,0,8};
	
	private static int widthSpritePersoJump[]={182,277,216,187,0,205};
	private static int heightSpritePersoJump[]={380,357,383,400,0,428};
	private static int nbSpritePersoJump[]={4,4,4,6,0,4};
	
	private static int widthSpritePersoCrouch[]={182,277,217,187,0,205};
	private static int heightSpritePersoCrouch[]={228,272,233,251,0,266};
	private static int nbSpritePersoCrouch[]={1,1,2,1,0,1};
	
	private static int widthSpritePersoBlocking[]={182,295,210,217,0,219};
	private static int heightSpritePersoBlocking[]={350,411,304,308,0,340};
	private static int nbSpritePersoBlocking[]={1,1,1,1,0,2};
	
	private static int widthSpritePersoPunch[]={241,379,319,285,0,384};
	private static int heightSpritePersoPunch[]={341,353,317,348,0,340};
	private static int nbSpritePersoPunch[]={3,3,2,3,0,3};
	
	private static int widthSpritePersoKick[]={283,402,325,340,0,366};
	private static int heightSpritePersoKick[]={357,361,300,357,0,388};
	private static int nbSpritePersoKick[]={3,3,3,3,0,5};
	
	private static int widthSpritePersoHit[]={182,299,245,182,0,290};
	private static int heightSpritePersoHit[]={287,343,318,319,0,306};
	private static int nbSpritePersoHit[]={4,3,2,1,0,2};
	
	private static int widthSpritePersoCrouchHit[]={182,299,227,217,0,237};
	private static int heightSpritePersoCrouchHit[]={241,295,277,243,0,248};
	private static int nbSpritePersoCrouchHit[]={1,1,3,1,0,1};
	
	private static int widthSpritePersoKo[]={182,388,378,352,0,357};
	private static int heightSpritePersoKo[]={312,384,266,280,0,283};
	private static int nbSpritePersoKo[]={3,5,5,3,0,4};
	
	private static int widthSpritePersoVictory[]={180,299,240,182,0,203};
	private static int heightSpritePersoVictory[]={460,536,486,453,0,384};
	private static int nbSpritePersoVictory[]={3,2,4,5,0,3};

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
	
	public static int getWidthSpritePersoBlocking(int numeroPerso){return InformationsCharacter.widthSpritePersoBlocking[numeroPerso];}
	public static int getHeightSpritePersoBlocking(int numeroPerso){return InformationsCharacter.heightSpritePersoBlocking[numeroPerso];}
	public static int getNbSpritePersoBlocking(int numeroPerso){return InformationsCharacter.nbSpritePersoBlocking[numeroPerso];}
	
	public static int getWidthSpritePersoPunch(int numeroPerso){return InformationsCharacter.widthSpritePersoPunch[numeroPerso];}
	public static int getHeightSpritePersoPunch(int numeroPerso){return InformationsCharacter.heightSpritePersoPunch[numeroPerso];}
	public static int getNbSpritePersoPunch(int numeroPerso){return InformationsCharacter.nbSpritePersoPunch[numeroPerso];}

	public static int getWidthSpritePersoKick(int numeroPerso){return InformationsCharacter.widthSpritePersoKick[numeroPerso];}
	public static int getHeightSpritePersoKick(int numeroPerso){return InformationsCharacter.heightSpritePersoKick[numeroPerso];}
	public static int getNbSpritePersoKick(int numeroPerso){return InformationsCharacter.nbSpritePersoKick[numeroPerso];}
	
	public static int getWidthSpritePersoHit(int numeroPerso){return InformationsCharacter.widthSpritePersoHit[numeroPerso];}
	public static int getHeightSpritePersoHit(int numeroPerso){return InformationsCharacter.heightSpritePersoHit[numeroPerso];}
	public static int getNbSpritePersoHit(int numeroPerso){return InformationsCharacter.nbSpritePersoHit[numeroPerso];}
	
	public static int getWidthSpritePersoCrouchHit(int numeroPerso){return InformationsCharacter.widthSpritePersoCrouchHit[numeroPerso];}
	public static int getHeightSpritePersoCrouchHit(int numeroPerso){return InformationsCharacter.heightSpritePersoCrouchHit[numeroPerso];}
	public static int getNbSpritePersoCrouchHit(int numeroPerso){return InformationsCharacter.nbSpritePersoCrouchHit[numeroPerso];}
	
	public static int getWidthSpritePersoKo(int numeroPerso){return InformationsCharacter.widthSpritePersoKo[numeroPerso];}
	public static int getHeightSpritePersoKo(int numeroPerso){return InformationsCharacter.heightSpritePersoKo[numeroPerso];}
	public static int getNbSpritePersoKo(int numeroPerso){return InformationsCharacter.nbSpritePersoKo[numeroPerso];}
	
	public static int getWidthSpritePersoVictory(int numeroPerso){return InformationsCharacter.widthSpritePersoVictory[numeroPerso];}
	public static int getHeightSpritePersoVictory(int numeroPerso){return InformationsCharacter.heightSpritePersoVictory[numeroPerso];}
	public static int getNbSpritePersoVictory(int numeroPerso){return InformationsCharacter.nbSpritePersoVictory[numeroPerso];}
}
