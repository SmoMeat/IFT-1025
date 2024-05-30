
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class RandomList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = getRandomArrayList();
        LinkedList<Integer> linkedList = getRandomLinkedList();
    }

    public static ArrayList<Integer> getRandomArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Random random = new Random();

        for (int i=0; i<=5000; i++) {
            list.add(random.nextInt());
        }
    }

    public static LinkedList<Integer> getRandomLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();

        Random random = new Random();

        for (int i=0; i<=5000; i++) {
            list.add(random.nextInt());
        }
    }
}
