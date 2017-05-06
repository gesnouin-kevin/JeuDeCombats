package personnages;

public abstract class InformationsCharacter {

	private static int life[]={60,80,80,60,60,40,100,40,100,100,60,40,60,40,80,60};
	private static int speed[]={8,4,8,6,8,8,4,4,4,4,8,10,6,10,6,8};
	private static int damage[]={8,10,6,8,6,4,10,6,8,8,8,6,8,6,10,10};
	
	private static int widthSpritePersoIdle[]={182,299,234,205,188,206,245,218,194,211,195,198,169,205,176,273};
	private static int heightSpritePersoIdle[]={345,366,321,349,360,353,357,345,350,338,363,355,348,343,357,365};
	private static int nbSpritePersoIdle[]={4,4,4,3,4,4,3,4,4,3,4,5,4,3,4,3};
	
	private static int widthSpritePersoWalking[]={182,326,233,200,209,229,246,209,191,171,228,192,170,204,175,273};
	private static int heightSpritePersoWalking[]={345,353,262,358,360,358,362,356,352,373,366,370,348,353,367,389};
	private static int nbSpritePersoWalking[]={5,4,8,5,5,8,4,8,6,5,5,6,4,4,6,4};
	
	private static int widthSpritePersoJump[]={182,277,216,187,144,156,269,138,191,154,159,146,160,159,131,264};
	private static int heightSpritePersoJump[]={380,357,383,400,394,425,400,407,371,385,429,442,338,361,388,357};
	private static int nbSpritePersoJump[]={4,4,4,6,5,3,3,3,4,5,5,5,5,4,4,4};
	
	private static int widthSpritePersoCrouch[]={182,277,217,187,200,206,211,178,212,197,186,190,161,204,185,274};
	private static int heightSpritePersoCrouch[]={228,272,233,251,246,268,257,229,269,268,236,213,243,195,196,239};
	private static int nbSpritePersoCrouch[]={1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1};
	
	private static int widthSpritePersoBlocking[]={182,295,210,217,188,219,200,199,190,205,181,200,207,205,188,261};
	private static int heightSpritePersoBlocking[]={350,411,304,308,364,340,346,345,349,312,349,344,356,350,364,349};
	private static int nbSpritePersoBlocking[]={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	
	private static int widthSpritePersoPunch[]={241,379,319,285,249,273,289,359,275,263,295,297,275,325,297,299};
	private static int heightSpritePersoPunch[]={341,353,317,348,396,389,392,308,361,325,343,379,347,333,334,340};
	private static int nbSpritePersoPunch[]={3,3,2,3,3,3,3,3,3,3,3,3,3,3,3,3};
	
	private static int widthSpritePersoKick[]={283,402,325,340,294,309,324,352,268,322,292,255,274,325,326,269};
	private static int heightSpritePersoKick[]={367,361,300,357,374,380,373,388,374,359,365,348,329,360,374,261};
	private static int nbSpritePersoKick[]={3,3,3,3,3,3,2,3,3,3,3,3,3,3,3,3};
	
	private static int widthSpritePersoHit[]={207,299,245,182,214,291,249,193,293,230,212,220,167,212,218,261};
	private static int heightSpritePersoHit[]={346,343,318,319,355,304,328,352,351,313,337,379,315,294,331,359};
	private static int nbSpritePersoHit[]={4,3,2,1,4,2,3,3,3,3,3,3,1,3,3,1};
	
	private static int widthSpritePersoCrouchHit[]={182,299,227,217,206,237,200,178,293,230,212,186,182,212,218,261};
	private static int heightSpritePersoCrouchHit[]={241,295,277,243,273,246,317,249,351,313,337,242,248,294,331,359};
	private static int nbSpritePersoCrouchHit[]={1,1,3,1,1,1,1,1,1,3,3,1,1,3,3,1};
	
	private static int widthSpritePersoKo[]={312,388,378,352,329,358,318,328,309,342,370,318,262,279,296,369};
	private static int heightSpritePersoKo[]={232,384,266,280,333,298,240,186,296,283,271,305,297,340,340,232};
	private static int nbSpritePersoKo[]={3,5,5,3,4,4,5,2,5,3,3,3,3,3,3,3};
	
	private static int widthSpritePersoVictory[]={182,299,240,182,188,220,229,245,208,238,240,199,290,205,158,201};
	private static int heightSpritePersoVictory[]={460,536,486,453,477,617,528,380,279,410,445,398,402,501,384,415};
	private static int nbSpritePersoVictory[]={2,2,4,5,2,3,2,2,5,12,10,5,4,2,4,1};
	
	private static int widthSpritePersoArm[]={110,103,91,103,99,64,85,120,108,94,100,102,131,140,65,127};
	private static int heightSpritePersoArm[]={34,98,48,46,40,107,58,55,97,56,67,51,71,41,82,96};
	private static int posXSpritePersoArm[]={131,276,228,183,162, 180,208,223,177,161,207,200,155,186,249,171};
	private static int posYSpritePersoArm[]={282,286,238,305,313,389,304,251,248,293,301,318,305,290,300,312};
	
	private static int widthSpritePersoFoot[]={46,116,120,158,40,79,81,93,102,100,137,126,42,154,110,96};
	private static int heightSpritePersoFoot[]={39,103,101,106,40,46,125,80,87,85,163,91,55,69,130,73};
	private static int posXSpritePersoFoot[]={237,286,205,181,255,239,268,271,187,232,162,133,228,169,225,186};
	private static int posYSpritePersoFoot[]={359,125,227,230,374,342,173,333,234,332,238,308,314,272,240,226};

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
	
	public static int getWidthSpritePersoArm(int numeroPerso){return InformationsCharacter.widthSpritePersoArm[numeroPerso];}
	public static int getHeightSpritePersoArm(int numeroPerso){return InformationsCharacter.heightSpritePersoArm[numeroPerso];}
	public static int getPosXSpritePersoArm(int numeroPerso){return InformationsCharacter.posXSpritePersoArm[numeroPerso];}
	public static int getPosYSpritePersoArm(int numeroPerso){return InformationsCharacter.posYSpritePersoArm[numeroPerso];}
	
	public static int getWidthSpritePersoFoot(int numeroPerso){return InformationsCharacter.widthSpritePersoFoot[numeroPerso];}
	public static int getHeightSpritePersoFoot(int numeroPerso){return InformationsCharacter.heightSpritePersoFoot[numeroPerso];}
	public static int getPosXSpritePersoFoot(int numeroPerso){return InformationsCharacter.posXSpritePersoFoot[numeroPerso];}
	public static int getPosYSpritePersoFoot(int numeroPerso){return InformationsCharacter.posYSpritePersoFoot[numeroPerso];}
	
}
