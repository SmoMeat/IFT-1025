package Exercice3;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private HashMap<String, Double> results = new HashMap<>();
    private Player[] players;
    private Deck deck;
    private Computer computer;
    private Scanner scanner;

    public Game(CasinoPlayer[] casinoPlayers) {
        this.scanner = new Scanner(System.in);
        this.deck = new Deck();

        // Création des joueurs
        this.players = new Player[casinoPlayers.length];
        for (int i=0; i<casinoPlayers.length; i++) {
            double betAmount = 100;
            players[i] = new Player(deck.getNCards(2), casinoPlayers[i].getPseudo(), betAmount, casinoPlayers[i].getUuid());
            casinoPlayers[i].removeMoney(betAmount);
        }

        // Création du croupier
        this.computer = new Computer(deck.getNCards(2));
        
        runGame();
    }

    public void runGame() {
        computer.printHiddenHands();

        makePlayersPlay();
        
        computer.play(this.deck);
        computer.printHands();

        calculateWinners();
    }

    public void makePlayersPlay() {
        for (Player player : players) {
            player.printHands();

            String userInput = "";
            while (userInput.isBlank() || player.isPlaying()) {
                userInput = scanner.nextLine();

                if (userInput.equals("stand")) {
                    player.stand();
                } else if (userInput.equals("hit")) {
                    player.hit(deck.getNext());
                } else if (userInput.equals("double") && player.getCards().size() == 2) {
                    player.doubleDown(deck.getNext());
                } else if (userInput.equals("surrender") && player.getCards().size() == 2) {
                    player.surrender();
                } else {
                    userInput = "";
                }
                player.printHands();
            }
        }
    }

    public HashMap<String, Double> calculateWinners() {
        for (Player player : players) {
            boolean playerBlackjack = (player.getCards().size() == 2 && player.getPoints() == 21);
            boolean computerBlackjack = (computer.getCards().size() == 2 && computer.getPoints() == 21);


            if (player.isSurrended()) {
                System.out.println(player.getName() + " surrended ("+ player.getBetAmount() +"$)");
            } else if (player.getPoints() > 21) {
                player.multiplyBetAmount(0);
                System.out.println(player.getName() + " lost ("+ player.getBetAmount() +"$)");
            } else if (playerBlackjack || computerBlackjack) {
                System.out.println(player.getName() + " tied ("+ player.getBetAmount() +"$)");
            } else if (computer.getPoints() > 21) {
                player.multiplyBetAmount(2);
                System.out.println(player.getName() + " won ("+ player.getBetAmount() +"$)");
            } else if (player.getPoints() < computer.getPoints()) {
                player.multiplyBetAmount(0);
                System.out.println(player.getName() + " lost ("+ player.getBetAmount() +"$)");
            } else if (player.getPoints() == computer.getPoints()) {
                System.out.println(player.getName() + " tied ("+ player.getBetAmount() +"$)");
            } else if (player.getPoints() > computer.getPoints()) {
                player.multiplyBetAmount(2);
                System.out.println(player.getName() + " won ("+ player.getBetAmount() +"$)");
            } else {
                System.err.println("Situation de victoire indéterminée, joueur=" + player.getPoints() + " croupier=" + computer.getPoints());
            }

            this.results.put(player.getUuid(), player.getBetAmount());
        }

        return this.results;
    }

    public HashMap<String, Double> getResults() {
        return this.results;
    }
}
