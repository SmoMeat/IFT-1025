// package jeupokemon;

public class Humain extends Personnage {
	
	public Humain(String nom) {
		super(nom);
	}
	
	

	@Override
	public void afficher() {
		
		if (super.getPv() == 0) {
			
			System.out.println(	"       -----\n"
					+ 			"      ( x.x )\n"
					+ "       -----\n"
					+ "         |\n"
					+ "      <--|-->\n"
					+ "        / \\\n"
					+ "       /   \\");
			
		}
		else 
		{
			System.out.println(	"       -----\n"
					+ 			"      ( o.o )\n"
					+ 			"       -----\n"
					+ 			"         |\n"
					+ 			"      <--|-->\n"
					+ 			"        / \\\n"
					+ 			"       /   \\");
		}
		
	}

}
