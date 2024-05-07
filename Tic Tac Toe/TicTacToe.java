import java.util.Scanner;

public class TicTacToe {
    private String[] grid = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String playerPlaying = "x";

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }

    public void start() {

        Scanner input$ = new Scanner(System.in);
        System.out.println(this.tileLeft());
        
        while (!this.checkWinner() && this.tileLeft() > 0) {
            this.playerPlaying = this.playerPlaying=="x" ? "o" : "x";
            
            this.printGrid();
            System.out.printf("Joueur %s, quelle case voulez-vous jouer: ", this.getCurrentPlayer());

            String playerInput = input$.nextLine();

            while (!isNumeric(playerInput)) {
                System.out.print("Entrée invalide, veuillez entrer une case valide: ");
                playerInput = input$.nextLine();
            }

            int position = Integer.valueOf(playerInput);

            while (!isNumeric(this.grid[position - 1])) {
                System.out.printf("Cette case est occupée! Quelle case voulez-vous jouer: ");
                position = Integer.valueOf(input$.nextLine());
            }

            this.grid[position - 1] = this.getCurrentPlayer();
        }

        input$.close();
    }

    private String getCurrentPlayer() {
        String color = this.playerPlaying=="x" ? ConsoleColors.BLUE_BRIGHT : ConsoleColors.RED_BOLD;
        return color + this.playerPlaying + ConsoleColors.RESET;
    }

    private int tileLeft() {
        int tileLeft = 0;
        for (int i=0; i < 9; i++) {
            if (isNumeric(this.grid[i])) {
                tileLeft++;
            }
        }
        return tileLeft;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
      
    private boolean checkWinner() {
        int[][] winningLines = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        for (int i=0; i < winningLines.length; i++) {
            String a = this.grid[winningLines[i][0]];
            String b = this.grid[winningLines[i][1]];
            String c = this.grid[winningLines[i][2]];

            if (a.equals(b) && a.equals(c)) {
                this.printGrid();
                System.out.printf("Félicitation joueur %s vous avez gagné!", this.getCurrentPlayer());
                return true;
            }
        }
        return false;
    }

    private void printGrid() {
        System.out.print("\033\143"); // clear screen
        System.out.println("╔═══╦═══╦═══╗");
        System.out.printf("║ %s ║ %s ║ %s ║\n", grid[0], grid[1], grid[2]);
        System.out.println("╠═══╬═══╬═══╣");
        System.out.printf("║ %s ║ %s ║ %s ║\n", grid[3], grid[4], grid[5]);
        System.out.println("╠═══╬═══╬═══╣");
        System.out.printf("║ %s ║ %s ║ %s ║\n", grid[6], grid[7], grid[8]);
        System.out.println("╚═══╩═══╩═══╝");
    }
}
