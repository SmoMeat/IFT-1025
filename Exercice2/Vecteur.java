/**
 * @author Mathieu Ducharme
 * @email mathieu.ducharme@umontreal.ca
 * @matricule 20297456 
 * 
 * Cette classe permet d'instancier des vecteurs de longueur n
 * grace à une liste de double et d'effectuer des opérations
 * élémentaires d'algèbre linéaire.
 */

package Exercice2;

import java.util.Arrays;

public class Vecteur {
    
    private double[] vecteur;
    private int length;

    /**
     * Constructeur
     * @param elements liste double dans le vecteur 
     */
    public Vecteur(double[] elements) {
        this.vecteur = elements;
        this.length = elements.length;
    }

    /**
     * Modifie la valeur à un index donné
     * @param index position à laquelle on veut modifie l'élément
     * @param valeur valeur qui sera mis à la place
     */
    public void setElement(int index, double valeur) {
        this.vecteur[index] = valeur;
    }

    /**
     * Permet d'accéder à un certain élément du vecteur
     * @param index position dont on veut avoir l'élément
     * @return la valeur placée à l'index donné
     */
    public double getElement(int index) {
        return this.vecteur[index];
    }


    /**
     * Calcule le produit scalaire de deux vecteurs
     * @param v vecteur avec lequel on veut faire le produit scalaire
     * @return la valeur (double) du produit scalaire
     */
    public double dotProduct(Vecteur v) {
        if (this.vecteur.length != v.getLength()) {
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }
        double toReturn = 0.0;

        for (int i=0; i<this.vecteur.length; i++) {
            toReturn += this.getElement(i) * v.getElement(i);
        }

        return toReturn;
    }

    /**
     * Affiche à la console le vecteur entre accolades. Le format
     * ressemble à {1.0, 2.0, 3.0}
     */
    public void afficher() {
        System.out.println(Arrays.toString(this.vecteur)
                                 .replace("[", "{")
                                 .replace("]", "}"));
    }  

    /**
     * Permet de connaitre la taille du vecteur
     * @return le nombre d'éléments du vecteur
     */
    public int getLength() {
        return this.length;
    }
}
