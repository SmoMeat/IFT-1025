package Exercice3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playBlackjack();
    }

    public static CasinoPlayer[] casinoPlayers = {
        new CasinoPlayer("Martin", "Matte", "martinmatte@email.com", "password123", "martii", 3500, "fbf3f2aa-d2bc-4de9-971c-ddd9acad43dc"),
        new CasinoPlayer("Lise", "Dion", "lisedion@email.com", "password123", "lise55", 5000, "c1260899-e53b-499d-b104-78a239771cd6")
    };

    public static void playBlackjack() {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        while (play) {
            Game game = new Game(casinoPlayers);

            setResults(game.getResults());

            System.out.println("Voullez-vous rejouer (y/n)?");
            play = scanner.nextLine().equals("y") ? true : false;
        }
    }

    public static void setResults(HashMap<String, Double> results) {
        for (CasinoPlayer casinoPlayer : casinoPlayers) {
            for (Map.Entry<String, Double> result : results.entrySet()) {
                if (casinoPlayer.getUuid().equals(result.getKey())) {
                    casinoPlayer.addMoney(result.getValue());
                }
            }
            System.out.println(casinoPlayer.getMoney());
        }
    }
}
