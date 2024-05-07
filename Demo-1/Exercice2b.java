import java.util.Arrays;

public class Exercice2b {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(renverser(tab)));
    }

    public static int[] renverser(int[] tab) {
        for (int i=0; i < tab.length/2; i++) {
            int temp = tab[i];
            tab[i] = tab[tab.length-1-i];
            tab[tab.length-1-i] = temp;
        }
        return tab;
    }    
}
