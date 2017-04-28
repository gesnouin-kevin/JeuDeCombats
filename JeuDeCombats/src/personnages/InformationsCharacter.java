package personnages;

public abstract class InformationsCharacter {

	private static int life[]={60,80,80,60,60,40,100,40,100,100,60,40,60,40,80,60};
	private static int speed[]={8,4,8,6,8,8,2,2,4,4,8,10,6,10,6,8};
	private static int damage[]={8,10,6,8,6,4,10,6,8,8,8,6,8,6,10,10};
	
	private static int widthSpritePersoIdle[]={182,0,0,0,0,207};
	private static int heightSpritePersoIdle[]={345,0,0,0,0,350};
	private static int nbSpritePersoIdle[]={4,0,0,0,0,4};
	
	private static int widthSpritePersoWalking[]={182,0,0,0,0,230};
	private static int heightSpritePersoWalking[]={345,0,0,0,0,357};
	private static int nbSpritePersoWalking[]={4,0,0,0,0,8};
	
	private static int widthSpritePersoJump[]={182,0,0,0,0,205};
	private static int heightSpritePersoJump[]={345,0,0,0,0,426};
	private static int nbSpritePersoJump[]={4,0,0,0,0,4};
	
	private static int widthSpritePersoCrouch[]={182,0,0,0,0,205};
	private static int heightSpritePersoCrouch[]={345,0,0,0,0,266};
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
	
	private static int nbSpritePersoRun[]={5,0,0,0,0,5};

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
	
	public static int[] getWidthSpritePersoIdle() {
		return widthSpritePersoIdle;
	}

	public static void setWidthSpritePersoIdle(int[] widthSpritePersoIdle) {
		InformationsCharacter.widthSpritePersoIdle = widthSpritePersoIdle;
	}

	public static int[] getHeightSpritePersoIdle() {
		return heightSpritePersoIdle;
	}

	public static void setHeightSpritePersoIdle(int[] heightSpritePersoIdle) {
		InformationsCharacter.heightSpritePersoIdle = heightSpritePersoIdle;
	}

	public static int[] getNbSpritePersoIdle() {
		return nbSpritePersoIdle;
	}

	public static void setNbSpritePersoIdle(int[] nbSpritePersoIdle) {
		InformationsCharacter.nbSpritePersoIdle = nbSpritePersoIdle;
	}

	public static int[] getWidthSpritePersoWalking() {
		return widthSpritePersoWalking;
	}

	public static void setWidthSpritePersoWalking(int[] widthSpritePersoWalking) {
		InformationsCharacter.widthSpritePersoWalking = widthSpritePersoWalking;
	}

	public static int[] getHeightSpritePersoWalking() {
		return heightSpritePersoWalking;
	}

	public static void setHeightSpritePersoWalking(int[] heightSpritePersoWalking) {
		InformationsCharacter.heightSpritePersoWalking = heightSpritePersoWalking;
	}

	public static int[] getNbSpritePersoWalking() {
		return nbSpritePersoWalking;
	}

	public static void setNbSpritePersoWalking(int[] nbSpritePersoWalking) {
		InformationsCharacter.nbSpritePersoWalking = nbSpritePersoWalking;
	}

	public static int[] getWidthSpritePersoJump() {
		return widthSpritePersoJump;
	}

	public static void setWidthSpritePersoJump(int[] widthSpritePersoJump) {
		InformationsCharacter.widthSpritePersoJump = widthSpritePersoJump;
	}

	public static int[] getHeightSpritePersoJump() {
		return heightSpritePersoJump;
	}

	public static void setHeightSpritePersoJump(int[] heightSpritePersoJump) {
		InformationsCharacter.heightSpritePersoJump = heightSpritePersoJump;
	}

	public static int[] getNbSpritePersoJump() {
		return nbSpritePersoJump;
	}

	public static void setNbSpritePersoJump(int[] nbSpritePersoJump) {
		InformationsCharacter.nbSpritePersoJump = nbSpritePersoJump;
	}

	public static int[] getWidthSpritePersoCrouch() {
		return widthSpritePersoCrouch;
	}

	public static void setWidthSpritePersoCrouch(int[] widthSpritePersoCrouch) {
		InformationsCharacter.widthSpritePersoCrouch = widthSpritePersoCrouch;
	}

	public static int[] getHeightSpritePersoCrouch() {
		return heightSpritePersoCrouch;
	}

	public static void setHeightSpritePersoCrouch(int[] heightSpritePersoCrouch) {
		InformationsCharacter.heightSpritePersoCrouch = heightSpritePersoCrouch;
	}

	public static int[] getNbSpritePersoCrouch() {
		return nbSpritePersoCrouch;
	}

	public static void setNbSpritePersoCrouch(int[] nbSpritePersoCrouch) {
		InformationsCharacter.nbSpritePersoCrouch = nbSpritePersoCrouch;
	}

	public static int[] getWidthSpritePersoBlocking() {
		return widthSpritePersoBlocking;
	}

	public static void setWidthSpritePersoBlocking(int[] widthSpritePersoBlocking) {
		InformationsCharacter.widthSpritePersoBlocking = widthSpritePersoBlocking;
	}

	public static int[] getHeightSpritePersoBlocking() {
		return heightSpritePersoBlocking;
	}

	public static void setHeightSpritePersoBlocking(int[] heightSpritePersoBlocking) {
		InformationsCharacter.heightSpritePersoBlocking = heightSpritePersoBlocking;
	}

	public static int[] getNbSpritePersoBlocking() {
		return nbSpritePersoBlocking;
	}

	public static void setNbSpritePersoBlocking(int[] nbSpritePersoBlocking) {
		InformationsCharacter.nbSpritePersoBlocking = nbSpritePersoBlocking;
	}

	public static int[] getWidthSpritePersoPunch() {
		return widthSpritePersoPunch;
	}

	public static void setWidthSpritePersoPunch(int[] widthSpritePersoPunch) {
		InformationsCharacter.widthSpritePersoPunch = widthSpritePersoPunch;
	}

	public static int[] getHeightSpritePersoPunch() {
		return heightSpritePersoPunch;
	}

	public static void setHeightSpritePersoPunch(int[] heightSpritePersoPunch) {
		InformationsCharacter.heightSpritePersoPunch = heightSpritePersoPunch;
	}

	public static int[] getNbSpritePersoPunch() {
		return nbSpritePersoPunch;
	}

	public static void setNbSpritePersoPunch(int[] nbSpritePersoPunch) {
		InformationsCharacter.nbSpritePersoPunch = nbSpritePersoPunch;
	}

	public static int[] getWidthSpritePersoKick() {
		return widthSpritePersoKick;
	}

	public static void setWidthSpritePersoKick(int[] widthSpritePersoKick) {
		InformationsCharacter.widthSpritePersoKick = widthSpritePersoKick;
	}

	public static int[] getHeightSpritePersoKick() {
		return heightSpritePersoKick;
	}

	public static void setHeightSpritePersoKick(int[] heightSpritePersoKick) {
		InformationsCharacter.heightSpritePersoKick = heightSpritePersoKick;
	}

	public static int[] getNbSpritePersoKick() {
		return nbSpritePersoKick;
	}

	public static void setNbSpritePersoKick(int[] nbSpritePersoKick) {
		InformationsCharacter.nbSpritePersoKick = nbSpritePersoKick;
	}

	public static int[] getWidthSpritePersoHit() {
		return widthSpritePersoHit;
	}

	public static void setWidthSpritePersoHit(int[] widthSpritePersoHit) {
		InformationsCharacter.widthSpritePersoHit = widthSpritePersoHit;
	}

	public static int[] getHeightSpritePersoHit() {
		return heightSpritePersoHit;
	}

	public static void setHeightSpritePersoHit(int[] heightSpritePersoHit) {
		InformationsCharacter.heightSpritePersoHit = heightSpritePersoHit;
	}

	public static int[] getNbSpritePersoHit() {
		return nbSpritePersoHit;
	}

	public static void setNbSpritePersoHit(int[] nbSpritePersoHit) {
		InformationsCharacter.nbSpritePersoHit = nbSpritePersoHit;
	}

	public static int[] getWidthSpritePersoCrouchHit() {
		return widthSpritePersoCrouchHit;
	}

	public static void setWidthSpritePersoCrouchHit(int[] widthSpritePersoCrouchHit) {
		InformationsCharacter.widthSpritePersoCrouchHit = widthSpritePersoCrouchHit;
	}

	public static int[] getHeightSpritePersoCrouchHit() {
		return heightSpritePersoCrouchHit;
	}

	public static void setHeightSpritePersoCrouchHit(int[] heightSpritePersoCrouchHit) {
		InformationsCharacter.heightSpritePersoCrouchHit = heightSpritePersoCrouchHit;
	}

	public static int[] getNbSpritePersoCrouchHit() {
		return nbSpritePersoCrouchHit;
	}

	public static void setNbSpritePersoCrouchHit(int[] nbSpritePersoCrouchHit) {
		InformationsCharacter.nbSpritePersoCrouchHit = nbSpritePersoCrouchHit;
	}

	public static int[] getWidthSpritePersoKo() {
		return widthSpritePersoKo;
	}

	public static void setWidthSpritePersoKo(int[] widthSpritePersoKo) {
		InformationsCharacter.widthSpritePersoKo = widthSpritePersoKo;
	}

	public static int[] getHeightSpritePersoKo() {
		return heightSpritePersoKo;
	}

	public static void setHeightSpritePersoKo(int[] heightSpritePersoKo) {
		InformationsCharacter.heightSpritePersoKo = heightSpritePersoKo;
	}

	public static int[] getNbSpritePersoKo() {
		return nbSpritePersoKo;
	}

	public static void setNbSpritePersoKo(int[] nbSpritePersoKo) {
		InformationsCharacter.nbSpritePersoKo = nbSpritePersoKo;
	}

	public static int[] getWidthSpritePersoVictory() {
		return widthSpritePersoVictory;
	}

	public static void setWidthSpritePersoVictory(int[] widthSpritePersoVictory) {
		InformationsCharacter.widthSpritePersoVictory = widthSpritePersoVictory;
	}

	public static int[] getHeightSpritePersoVictory() {
		return heightSpritePersoVictory;
	}

	public static void setHeightSpritePersoVictory(int[] heightSpritePersoVictory) {
		InformationsCharacter.heightSpritePersoVictory = heightSpritePersoVictory;
	}

	public static int[] getNbSpritePersoVictory() {
		return nbSpritePersoVictory;
	}

	public static void setNbSpritePersoVictory(int[] nbSpritePersoVictory) {
		InformationsCharacter.nbSpritePersoVictory = nbSpritePersoVictory;
	}

	public static int[] getNbSpritePersoRun() {
		return nbSpritePersoRun;
	}

	public static void setNbSpritePersoRun(int[] nbSpritePersoRun) {
		InformationsCharacter.nbSpritePersoRun = nbSpritePersoRun;
	}

	public static int getNbSpritePersoRun(int numeroPerso)
	{
		return InformationsCharacter.nbSpritePersoRun[numeroPerso];
	}

}
