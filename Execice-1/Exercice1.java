/**
 * @author Mathieu Ducharme
 * @email mathieu.ducharme@umontreal.ca
 * @matricule 20297456 
 * 
 * L'exercice 1 consiste à écrire un petit programme qui lit des mots sur
 * la ligne de commande jusqu'à ce que l'utilisateur entre "stop", qui
 * trie ces mots et qui retire les doublons entrés.
 */

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
        } 
        
        scanner.close();

        wordsList = trier(wordsList);
        return retirerDoublons(wordsList);
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
        int i = 1;
        String[] uniqueStrings = { mots[0] };

        while (i < mots.length) {
            if (mots[i].equals(mots[i-1])) {
                continue;
            }

            uniqueStrings = agrandirTab(uniqueStrings);
            uniqueStrings[i] = mots[i];
            i++;
        }

        return uniqueStrings;
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
