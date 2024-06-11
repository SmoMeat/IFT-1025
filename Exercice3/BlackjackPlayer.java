package Exercice3;

import java.util.ArrayList;

public abstract class BlackjackPlayer {
    private ArrayList<Card> carteEnMain = new ArrayList<Card>();
    private int points;

    public BlackjackPlayer(Card firstCard, Card secondCard) {
        this.carteEnMain.add(firstCard);
        this.carteEnMain.add(secondCard);

        this.points = this.calculatePoints();
    }

    public int getPoints() {
        return this.points;
    }

    public int calculatePoints() {
        // calcule le nombre de points et le met dans this.points
        return 0;
    }

    public void ajouterCarte(Card card) {
        this.points = this.calculatePoints();
        carteEnMain.add(card);
        // 
    }
}
