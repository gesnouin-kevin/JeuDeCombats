package personnages;

import java.util.HashMap;

public class Personnage {

	private HashMap<Integer, int[]> infosPerso;

	public Personnage()
	{
		infosPerso = new HashMap<Integer, int[]>();
		
		// RYU
		infosPerso.put(0, new int[]{60,3,8});
		// HONDA
		infosPerso.put(1, new int[]{80, 2, 10});
		// BLANKA
		infosPerso.put(2, new int[]{80, 4, 6});
		// GUILE
		infosPerso.put(3, new int[]{60, 3, 8});
		// KEN
		infosPerso.put(4, new int[]{60, 4, 6});
		// CHUNLI
		infosPerso.put(5, new int[]{40, 4, 4});
		// ZANGIEF
		infosPerso.put(6, new int[]{100, 1, 10});
		// DHALSIM
		infosPerso.put(7, new int[]{40, 1, 6});
		// HAWK
		infosPerso.put(8, new int[]{100, 3, 8});
		// FEILONG
		infosPerso.put(9, new int[]{100, 3, 8});
		// DEEJAY
		infosPerso.put(10, new int[]{60, 4, 8});
		// CAMMY
		infosPerso.put(11, new int[]{40, 5, 6});
		// BALROG
		infosPerso.put(12, new int[]{60, 3, 8});
		// VEGA
		infosPerso.put(13, new int[]{40, 5, 6});
		// SAGAT
		infosPerso.put(14, new int[]{80, 3, 10});
		// BISON
		infosPerso.put(15, new int[]{60, 4, 10});


	}

	public HashMap<Integer, int[]> getInfosPerso() {
		return infosPerso;
	}
	public void setInfosPerso(HashMap<Integer, int[]> infosPerso) {
		this.infosPerso = infosPerso;
	}
	
	public int getLife(int numeroPerso)
	{
		return this.infosPerso.get(numeroPerso)[0];
	}

	public int getSpeed(int numeroPerso)
	{
		return this.infosPerso.get(numeroPerso)[1];
	}
	
	public int getDamage(int numeroPerso)
	{
		return this.infosPerso.get(numeroPerso)[2];
	}

}
