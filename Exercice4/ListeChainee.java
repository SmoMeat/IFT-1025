package Exercice4;

import java.text.DecimalFormat;

public class ListeChainee {

    private Node firstNode;

    private class Node {
        public double coefficient;
        public int exponent;
        public Node next;

        public Node(double coefficient, int exposant, Node next) {
            this.coefficient = coefficient;
            this.exponent = exposant;
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        @Override
        public String toString() {
            DecimalFormat formatter = new DecimalFormat("0.#");
            if (exponent == 0) {
                return formatter.format(coefficient);
                //return String.valueOf(coefficient);
            } else if (exponent == 1) {
                return formatter.format(coefficient) + "x";
            }
            return formatter.format(coefficient) + "x^" + exponent;
        }
    }

    // public ListeChainee() {
    //     this.firstNode = new Node(0, 0, null);
    // }

    @Override
    public String toString() {
        Node node = this.firstNode;
        String str = node.toString();
        while ((node = node.getNext()) != null) {
            str += " + " + node.toString();
        }
        return str;
    }

    // /**
    //  * Retrouve le idx-ème nœud de la chaîne
    //  *
    //  * @param idx indice du nœud
    //  * @return nœud sélectionné
    //  */
    // private Node getNode(int idx) {
    //     Node node = this.firstNode;

    //     for(int i=0; i<idx; i++) {
    //         node = node.getNext();
    //     }

    //     return node;
    // }

    // /**
    //  * Accède au idx-ème élément
    //  *
    //  * @param idx indice du nœud
    //  * @return valeur du nœud
    //  */
    // public int get(int idx) {
    //     return getNode(idx).coefficient;
    // }


    public double getCoeffByExponent(int exponent) {
        Node node = this.firstNode;
        while (node.exponent != exponent) {
            node = node.getNext();
        }
        return node.coefficient;
    }

    // /**
    //  * Modifie le idx-ème élément
    //  *
    //  * @param idx indice du nœud
    //  * @param valeur valeur du nœud
    //  */
    public void add(double coeff, int exponent) {
        if (this.firstNode == null) {
            this.firstNode = new Node(coeff, exponent, null);
            return;
        }

        Node node = this.firstNode;

        while (node.exponent > exponent) {
            node = node.getNext();
        }

        node.next = (node.exponent != exponent)
                        ? new Node(node.coefficient, node.exponent, node.getNext())
                        : node.getNext();
        node.coefficient = coeff;
        node.exponent = exponent;
    }

    /**
     * Calcule la taille de la liste chaînée
     *
     * @return taille de la liste
     */
    public int size() {
        int size = 0;

        Node n = this.firstNode;

        while(n != null) {
            size++;
            n = n.next;
        }

        return size;
    }

    // /**
    //  * Ajoute un élément au début de la liste
    //  *
    //  * @param valeur valeur du nœud
    //  */
    // public void addFirst(int valeur) {
    //     this.firstNode = new Node(valeur, this.firstNode);
    // }

    // /**
    //  * Ajoute un élément à la fin de la liste
    //  *
    //  * @param valeur valeur du nœud
    //  */
    // public void addLast(int valeur) {
    //     if(this.firstNode == null) { // Cas 1 : rien dans la liste
    //         this.firstNode = new Node(valeur, null);
    //     } else { // Cas 2 : trouver le nœud final
    //         Node fin = this.firstNode;
    //         Node n = this.firstNode.next;

    //         while(n != null) {
    //             fin = n;
    //             n = n.next;
    //         }

    //         // Ajoute un nœud après la fin de la liste
    //         fin.next = new Node(valeur, null);
    //     }
    // }
}
