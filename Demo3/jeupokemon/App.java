// package jeupokemon;

public class App {
	
	public static void main(String[] args) {
		
		Personnage[] ennemis = new Personnage[2];

		ennemis[0] = new Humain("Jimmy Whooper");
		ennemis[1] = new Pokemon("Squirtle");


		Pokemon pokemon = new Pokemon("Pikachu");

		pokemon.attaquer(ennemis[0]);
		pokemon.attaquer(ennemis[1]);
		
		System.out.println(ennemis[0].toString());
		
		System.out.println(ennemis[1].toString());
		
		
		
	}

}
