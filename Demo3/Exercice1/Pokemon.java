package Demo3.Exercice1;

public class Pokemon extends Personnage {

    Boolean captured = false;
    
    public Pokemon(String name) {
        super(
            name,
            "pokemon",
            "pokeball",
            50
        );
    }

    public void capture() {
        this.captured = true;
    }

    public void unlease() {
        this.captured = false;
    }
}
