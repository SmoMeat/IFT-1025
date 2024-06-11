package Exercice3;

public class Card {
    private char symbole;
    private int numero;
    private String image;

    public Card(char symbole, int numero) {
        this.symbole = symbole;
        this.numero = numero;
    }

    public String toString() {
        return this.symbole + " " + this.numero;
    }

    public void afficher() {
        // affiche graphiquement l'image de la carte
    }
}
