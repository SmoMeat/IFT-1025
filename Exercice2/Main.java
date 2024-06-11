/**
 * @author Mathieu Ducharme
 * @email mathieu.ducharme@umontreal.ca
 * @matricule 20297456 
 * 
 * L'exercice 2 consiste à concevoir deux classes mathématiques (vecteur
 * et matrice). Ces classes inclues certaines opérations de bases de
 * l'algèbre linéaire. Pour exécuter le programme, à l'extérieur du répertoire
 * Exercice2 executez la commande 'javac .\Exercice2\Main.java' puis entrez
 * 'java Exercice2.Main' pour lancer les tests.
 */

package Exercice2;

public class Main {

    public static void main(String[] args) {

        double[] elements1 = new double[] { 1, 2, 3 };
        Vecteur v1 = new Vecteur(elements1);
        double[] elements2 = new double[] { 7, 5, 8};
        Vecteur v2 = new Vecteur(elements2);
        double[] elements3 = new double[] { 5, 5, 5};
        Vecteur v3 = new Vecteur(elements3);
        double[] elements4 = new double[] { 0, 0, 0};
        Vecteur v4 = new Vecteur(elements4);

        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        System.out.print("v1 = "); v1.afficher();
        System.out.print("v2 = "); v2.afficher();
        System.out.print("v3 = "); v3.afficher();
        System.out.print("v4 = "); v4.afficher();

        System.out.println("v1 * v2 = " + v1.dotProduct(v2));
        System.out.println("v2 * v3 = " + v2.dotProduct(v3));
        System.out.println("v1 * v4 = " + v1.dotProduct(v4));

        v2.setElement(0, 1);
        v2.setElement(1, 2);
        v2.setElement(2, 3);

        System.out.println("Le premier élément de v2 est " + v2.getElement(0));
        System.out.println("Le deuxième élément de v3 est " + v3.getElement(1));
        System.out.println("Le troisième élément de v4 est " + v4.getElement(2));



        System.out.println("--- Matrices ---");
        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0, 1, 5);
        m1.setCell(1, 0, -2);
        System.out.println("Matrice 1 :");
        m1.afficher();

        Matrice m2 = new Matrice(2, 1);
        m2.additionnerScalaire(10);
        System.out.println("Matrice 2 :");
        m2.afficher();

        
        Matrice m3 = m1.dotProduct(m2);
        System.out.println("Matrice 3 (m1 x m2):");
        m3.afficher();

        System.out.println("La transposée de m1 :");
        m1.transpose().afficher();

        System.out.println("La matrice identité :");
        Matrice m4 = Matrice.identite(3);
        m4.afficher();

        System.out.println("La matrice 2 * I :");
        m4.multiplierScalaire(2);
        m4.afficher();

        System.out.println("La matrice 2 * I + 0.5 :");
        m4.additionnerScalaire(0.5);
        m4.afficher();

        System.out.println("Cette dernière matrice X m3 :");
        m4.dotProduct(m3);

        System.out.print("La première ligne de m1 est : ");
        m1.getLine(0).afficher();

        System.out.print("La deuxième colonne de m1 est : ");
        m1.getCol(1).afficher();

        System.out.println("L'élément à la position (1, 0) de m1 est : " + m1.getCell(1, 0));
        m1.setCell(1, 0, 10);
        System.out.println("L'élément à la position (1, 0) de m1 est maintenant : " + m1.getCell(1, 0));

    }
}
