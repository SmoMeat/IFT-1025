package Exercice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>(52);

    public Deck() {
        this.buildDeck();
        this.shuffle();
    }

    public void buildDeck() {
        String[] values = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        char[] suits = {'D', 'H', 'S', 'C'};

        for (char suit : suits) {
            for (String value : values) {
                this.deck.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();

        for (int i=0; i<deck.size(); i++) {
            int j = random.nextInt(deck.size());

            Card card1 = deck.get(i);
            Card card2 = deck.get(j);

            deck.set(i, card2);
            deck.set(j, card1);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(deck.toArray());
    }

    public Card getNext() {
        return this.deck.removeFirst();
    } // renvoie la première carte et la retire du deck

    public ArrayList<Card> getNCards(int n) {
        ArrayList<Card> toReturn = new ArrayList<>();
        for (int i=0; i<n; i++) {
            toReturn.add(getNext());
        }
        return toReturn;
    }

}
