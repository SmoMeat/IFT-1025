package Exercice3;

import java.util.Scanner;

public class Player extends BlackjackPlayer {
    private double mise;
    private boolean isPlaying = true;
    private boolean surrendered = false;

    public Player(Card firstCard, Card secondCard, int mise) {
        super(firstCard, secondCard); // à confirmer

        this.mise = mise;

    }

    public void stand() {
        this.isPlaying = false;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void doublerMise() {
        this.mise *= 2;
    }

    public void surrender() {
        this.surrendered = true;
    }

    public double amountGained(int computerPoints) {
        if (this.surrendered) {
            return -0.5 * this.mise;
        } else if (this.getPoints() > 21) {
            return -1 * this.mise;
        } else if (computerPoints > 21) {
            return this.mise;
        } else if (this.getPoints())......
    }


}
