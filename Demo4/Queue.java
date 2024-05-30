package Demo4;

import java.util.Stack;

public class Queue {
    
    private Stack<Integer> firstStack = new Stack<Integer>();
    private Stack<Integer> secondStack = new Stack<Integer>();

    Queue(Integer[] integers) {
        for (Integer integer : integers) {
            this.firstStack.push(integer);
        }
    }

    public void empiler(Integer interger) {
        this.firstStack.push(interger);
    }

    public Integer depiler(Integer interger) {
        Stack<Integer> secondStack = new Stack<Integer>();
        for (int i=0; i<firstStack.size(); i++) {
            secondStack.push(this.firstStack.pop());
        }
        return secondStack.pop();
    }

    
}
