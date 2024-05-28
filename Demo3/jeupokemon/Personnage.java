// package jeupokemon;

import java.util.Random;

public abstract class Personnage {
	
	public String nom;
	public int pv;
	
	public Personnage(String nom) {
		this.nom = nom;
		this.pv = 100;
	}
	
	public void attaquer(Personnage autre) {
		
		Random myrandom = new Random();
		
		int degats = myrandom.nextInt(80);
		
		int autrepv = autre.pv;
		
		int nouveaupv = autrepv - degats;
		
		if (nouveaupv < 0 )
		{
			nouveaupv = 0;
			
		}
		
		autre.setPv(nouveaupv);
		
	}
	
	public abstract void afficher();

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the pv
	 */
	public int getPv() {
		return pv;
	}

	/**
	 * @param pv the pv to set
	 */
	public void setPv(int pv) {
		this.pv = pv;
	}

	@Override
	public String toString() {
		return "nom : " + nom + ", pv : " + pv;
	}
	
	
	

}
