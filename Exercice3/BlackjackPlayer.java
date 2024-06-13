package Exercice3;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BlackjackPlayer {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int points;
    private String name;

    public BlackjackPlayer(ArrayList<Card> cards, String name) {
        this.name = name;
        this.cards.addAll(cards);
        this.calculatePoints();
    }

    public int getPoints() {
        return this.points;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public int calculatePoints() {
        int sum = 0;
        int nbrAs = 0;
        for (Card card : cards) {
            if (card.getValue() == 11) {
                nbrAs += 1;
            }
            sum += card.getValue();
        }
        while (nbrAs > 0 && sum > 21) {
            nbrAs -= 1;
            sum -= 10;
        }
        points = sum;
        return sum;
    }

    public void ajouterCarte(Card card) {
        cards.add(card);
        this.calculatePoints();
    }

    public void printHands() {
        System.out.println( name + " (" + points + " points) :");
        System.out.println( Arrays.toString(cards.toArray()) );
    }

    public String getName() {
        return this.name;
    }
}
