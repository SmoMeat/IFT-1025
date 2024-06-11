package Exercice3;

public class Deck {
    private Card[] cards = new Card[52];

    public Deck() {
        // remplie cards de l'as de coeur à roi de pique
    }

    public void shuffle() {

    }

    public Card getNext() {
        return new Card('s', 0);
    } // renvoie la première carte et la retire du deck


}
