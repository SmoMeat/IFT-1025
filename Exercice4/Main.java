package Exercice4;

public class Main {
    public static void main(String[] args) {
        Polynome p1 = new Polynome();
        Polynome p2 = new Polynome();

        p1.ajouter(3, 0);
        p1.ajouter(-2, 1);
        p1.ajouter(1,3);

        p2.ajouter(7, 0);
        p2.ajouter(4, 2);
        p2.ajouter(3, 3);

        System.out.println(p1);
        System.out.println(p2);

        Polynome p3 = p1.additionner(p2);
        System.out.println(p3);

        Polynome p4 = p3.multiplier(2);
        System.out.println(p4);
        
        Polynome p5 = p1.multiplier(p2);
        System.out.println(p5);
        
        Polynome p6 = p5.derivee();
        System.out.println(p6);

        Polynome p7 = new Polynome();
        p7.ajouter(10, 0);
        Polynome p8 = p7.derivee();
        System.out.println(p8);


        // System.out.println(liste);
        // System.out.println(liste.size());



        // ListeChainee x0 = new ListeChainee();
        // x0.add(-10.0);
        // x0.add(0.0);

        // ListeChainee x1 = new ListeChainee();
        // x1.add(3.0);
        // x1.add(2.0);

        // ListeChainee x2 = new ListeChainee();
        // x2.add(4.0);
        // x2.add(2.0);

        // ListeChainee x7 = new ListeChainee();
        // x7.add(9.0);
        // x7.add(7.0);

        // ListeChainee x9 = new ListeChainee();
        // x9.add(5.5);
        // x9.add(9.0);

        // ListeChainee l1 = new ListeChainee();
        // l1.add(x0);
        // l1.add(x7);
        // l1.add(x9);

        // ListeChainee l2 = new ListeChainee();
        // l2.add(x1);
        // l2.add(x2);

        // Polynome p1 = new Polynome(l1);
        // Polynome p2 = new Polynome(l1);



    }
}
