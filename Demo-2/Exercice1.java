import java.util.Random;

public class Exercice1 {
    public static void main(String[] args) {
        System.out.println(de(6));
        
    }

    public static int de(int numFaces) {
        Random rand = new Random();
        return rand.nextInt(numFaces) + 1;
    }
}
