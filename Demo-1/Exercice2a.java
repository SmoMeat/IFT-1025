import java.util.Arrays;

public class Exercice2a {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(renverser(tab)));
    }

    public static int[] renverser(int[] tab) {
        int[] toReturn = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            toReturn[tab.length - i - 1] = tab[i];
        }
        return toReturn;
    }    
}
