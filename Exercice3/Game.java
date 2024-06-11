package Exercice3;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private BlackjackPlayer[] players;
    public static void main(String[] args) {
        int nombreDeJoueurs = 6;
        Deck deck = new Deck();

        this.players = new BlackjackPlayer[nombreDeJoueurs];

        for (int i=0; i<=6; i++) {
            players[i] = new Player(deck.getNext(), deck.getNext(), 1000);
        }

        Computer computer = new Computer(deck.getNext(), deck.getNext());

        Scanner scanner = new Scanner(System.in);

        for (BlackjackPlayer blackjackPlayer : players) {
            Player player = (Player) blackjackPlayer;
            while (player.isPlaying() && player.getPoints() < 21) {
                String playerOutput = scanner.nextLine();

                if (playerOutput == "stand") {
                    player.stand();
                } else if (playerOutput == "hit") {
                    player.ajouterCarte(deck.getNext());
                } else if (playerOutput == "double") {
                    player.doublerMise();
                    player.ajouterCarte(deck.getNext());
                    player.stand();
                } else if (playerOutput == "surrender") {
                    player.surrender();
                }
            }
        }



        
        
    }

    public void computerPlay() {
        while (computer.getPoints() < 17) {
            computer.ajouterCarte(deck.getNext());
        }
    }

    public void afficherResultat() {
        // amountGained() sur tous les jouers et print le résultat...
    }
}
