package Exercice3;

import java.util.ArrayList;
import java.util.Arrays;

public class Computer extends BlackjackPlayer {
    public Computer(ArrayList<Card> cards) {
        super(cards, "Dealer");
    }

    public void play(Deck deck) {
        while (this.getPoints() < 17) {
            this.ajouterCarte(deck.getNext());
        }
    }

    public void printHiddenHands() {
        System.out.println("Dealer (" + getPoints() + " points) :");
        System.out.println( Arrays.toString(getCards().toArray()) );
    }
}
