// package jeupokemon;

public class Pokemon extends Personnage {
	
	public boolean capture;
	
	public Pokemon(String nom) {
		super(nom);
		this.capture = false;
		
	}

	
	
	//@Override
	public void afficher() {
		
		if (capture) {
			System.out.println(	"    -------\n"
					+ 			"  -/       \\-\n"
					+ " /           \\\n"
					+ " +-----O-----+\n"
					+ " \\.........../\n"
					+ "  -\\......./-\n"
					+ "    -------");
		}
		else
		{
			System.out.println(	"   ___\n"
					+ 	"  (ô.ô)\n"
					+ 	"   -v-\n"
			+ 			" <(   )>\n"
			+ 			"  (___)\n"
			+ 			"   m m");
		}
		
		
	}
	
	public void setPv(int pv) {
		if (pv == 0)
		{
			this.capture = true;
		}
		this.pv = pv;
	}

	public void attaquer(Pokemon autre) {
		System.out.println("pika pika pika pika !!");
	}


	@Override
	public String toString() {
		return super.toString() + (this.capture ? "(capturé)" : "");
	}
	
	
	

}
