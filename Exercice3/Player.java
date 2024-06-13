package Exercice3;

import java.util.ArrayList;

public class Player extends BlackjackPlayer {
    private double betAmount;
    private String uuid;
    private boolean isPlaying = true;
    private boolean surrendered = false;

    public Player(ArrayList<Card> cards, String name, double betAmount, String uuid) {
        super(cards, name);
        this.betAmount = betAmount;
        this.uuid = uuid;
    }

    public void hit(Card card) {
        this.ajouterCarte(card);
    }
    
    public void stand() {
        this.isPlaying = false;
    }

    public void doubleDown(Card card) {
        this.ajouterCarte(card);
        this.betAmount *= 2;
        this.isPlaying = false;
    }

    public void surrender() {
        this.surrendered = true;
        this.isPlaying = false;
        this.betAmount *= 0.5;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public boolean isSurrended() {
        return this.surrendered;
    }

    public void multiplyBetAmount(double multiplier) {
        this.betAmount *= multiplier;
    }

    public double getBetAmount() {
        return this.betAmount;
    }

    public String getUuid() {
        return this.uuid;
    }
}
