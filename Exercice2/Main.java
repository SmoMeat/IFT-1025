package Exercice2;

public class Main {

    public static void main(String[] args) {
        Matrice matrice = new Matrice(3, 3);
        matrice.additionnerScalaire(5.0);
        matrice.afficher();
        matrice.multiplierScalaire(2.0);
        matrice.afficher();

        Matrice m2 = new Matrice(3, 3);
        m2.additionnerScalaire(1.0);

        matrice.dotProduct(m2).afficher();

        double[] x1 = new double[] {3.0, 1.0, 4.5};
        double[] x2 = new double[] {1,2,3};
        Vecteur v1 = new Vecteur(x1);
        Vecteur v2 = new Vecteur(x2);
        System.out.println(v1.dotProduct(v2));
        v1.afficher();
        
    }

    // public static void main(String[] args) {

    //     double[] elements = new double[] { 1, 2, 3 };
    //     Vecteur v1 = new Vecteur(elements);
    //     Vecteur v2 = new Vecteur(elements);
    //     v2.setElement(0, 10);

    //     System.out.println("--- Vecteurs ---");
    //     v1.afficher();
    //     v2.afficher();

    //     System.out.println("--- Matrices ---");
    //     Matrice m1 = Matrice.identite(2);
    //     m1.multiplierScalaire(3);
    //     m1.setCell(0, 1, 5);
    //     m1.setCell(1, 0, -2);
    //     System.out.println("Matrice 1 :");
    //     m1.afficher();

    //     Matrice m2 = new Matrice(2, 1);
    //     m2.additionnerScalaire(10);
    //     System.out.println("Matrice 2 :");
    //     m2.afficher();

    //     Matrice m3 = m1.dotProduct(m2);
    //     System.out.println("Matrice 3 :");
    //     m3.afficher();

    //     // ...
    // }
}
