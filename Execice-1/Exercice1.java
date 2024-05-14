import java.util.Arrays;
import java.util.Scanner;

public class Exercice1 {

    /**
     * Cette fonction prend un tableau de Strings en paramètre et retourne un
     * nouveau tableau contenant les mêmes éléments, avec une case disponible de
     * plus.
     */
    public static String[] agrandirTab(String[] tab) {
        String[] newList = new String[tab.length + 1];

        for (int i=0; i < tab.length; i++) {
            newList[i] = tab[i];
        }

        return newList;
    }

    
    /**
     * Cette fonction lit des mots sur la ligne de commande et les retourne dans
     * un tableau de Strings. Chaque "mot" est définit comme une ligne complète,
     * du début de la ligne entrée jusqu'au prochain \n.
     */
    public static String[] lireMots() {
        Scanner scanner = new Scanner(System.in);
        boolean listen = true;
        
        String[] wordsList = new String[0];

        while (listen) {
            String userInput = scanner.nextLine();
            if (userInput.equals("stop")) {
                break;
            }
            if (userInput.isBlank()) {
                continue;
            }
            
            wordsList = agrandirTab(wordsList);
            wordsList[wordsList.length - 1] = userInput;
            wordsList = trier(wordsList);
            wordsList = retirerDoublons(wordsList);
            // System.out.println(Arrays.toString(wordsList));
        } 
        

        scanner.close();
        return wordsList;
    }


    /**
     * Cette fonction prend en paramètre un tableau de mots et retourne un
     * nouveau tableau contenant ces mots triés en ordre croissant.
     */
    public static String[] trier(String[] mots) {
        for (int i=0; i < mots.length; i++) {
            for (int j=0; j < mots.length - 1; j++) {
                if (mots[j].compareTo(mots[j+1]) > 0) {
                    String temp = mots[j];
                    mots[j] = mots[j+1];
                    mots[j+1] = temp;
                }
            }
        }
        return mots;
    }


    /**
     * Cette fonction prend en paramètre un tableau de mots trié et retourne un
     * nouveau tableau où chaque mot est unique (tous les doublons sont
     * retirés).
     */
    public static String[] retirerDoublons(String[] mots) {
        int wordsRemoved = 0;
        for (int i = 0; i < mots.length-1; i++) {
            if (mots[i].compareTo(mots[i+1]) == 0) {
                mots[i] = "stop";
                wordsRemoved += 1;
            }
        }

        String[] newList = new String[mots.length - wordsRemoved];
        int j = 0;
        for (int i = 0; i < mots.length; i++) {
            if (mots[i].compareTo("stop") == 0) {
                continue;
            }
            newList[j] = mots[i];
            j += 1;
        }

        return newList;
    }


    /**
     * Fonction principale du programme (utilisée pour tester le code).
     */
    public static void main(String[] args) {
        System.out.println("# Entrée au clavier :");

        String[] words = lireMots();

        System.out.println("# Affichage du programme :");

        for (String word : words) {
            System.out.println(word);
        }
    }
}
