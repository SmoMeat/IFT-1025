

import java.util.Iterator;
import java.util.Optional;

class ListeChainee implements Iterable<ListeChainee.Node>{
    private Node node;
    public void add(Object data){
        if(!Optional.ofNullable(node).isPresent()){
            node = new Node();
            node.setData(data);
        }else{
            Node node = new Node();
            node.setData(data);
            Node lastNode = getLastNode(this.node);
            lastNode.setNext(node);
        }
    }

    private Node getLastNode(Node node){
        if(node.getNext()==null){
            return node;
        }else{
            return getLastNode(node.getNext());
        }
    } 

    class Node{
        private Object data;
        private Node next;
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    public Iterator<Node> iterator() {
        return new NodeIterator();
    }

    class NodeIterator implements Iterator<Node>{
        private Node current;

        public boolean hasNext() {
            if(current == null){
                current = node;
                return Optional.ofNullable(current).isPresent();
            }else{
                current = current.next;
                return Optional.ofNullable(current).isPresent();
            }
        }

        public Node next() {
            return current;
        }
    }
}

public class LinkedListImpl {
    public static void main(String[] args) {
        ListeChainee linkedList = new ListeChainee();
        linkedList.add("data1");
        linkedList.add("data2");
        linkedList.add("data3");
        for(ListeChainee.Node node : linkedList){
            System.out.println(node.getData());
        }
    }
}