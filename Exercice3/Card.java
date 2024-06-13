package Exercice3;

public class Card {
    private String value;
    private char suit;

    private String image;

    public Card(String value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.suit + "-" + this.value;
    }

    public void afficher() {
        // affiche graphiquement l'image de la carte
    }

    public int getValue() {
        if (value.equals("J") || value.equals("Q") || value.equals("K")) {
            return 10;
        } else if (value.equals("A")) {
            return 11;
        }
        return Integer.parseInt(value); //2-10
    }

    
}
