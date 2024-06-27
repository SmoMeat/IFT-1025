/**
 * Représente une liste chainée de termes d'un polynome. Cette classe
 * permet d'ajouter et de retirer des noeuds (aka les termes du polynome)
 * et d'itérer sur les noeuds de la liste.
 */

package Exercice4;

import java.util.Iterator;
import java.text.DecimalFormat;


public class ListeChainee implements Iterable<ListeChainee.Noeud> {

    private Noeud premierNoeud;

    /**
     * Représente un noeud dans une liste chainée pour un polynome.
     * Chaque noeud contient un coefficient, un exposant et une référence
     * au noeud suivant dans la liste
     */
    public class Noeud {
        private double coeff;
        private int exposant;
        private Noeud suivant;

        /**
         * Constructeur pour créer un nouveau noeud représentant un terme (ex: ax^b)
         *
         * @param coefficient le coefficient du terme (le 'a' dans 'ax^b')
         * @param exposant l'exposant du terme (le 'b' dans 'ax^b')
         * @param suivant le noeud suivant dans la liste chainée
         */
        public Noeud(double coefficient, int exposant, Noeud suivant) {
            this.coeff = coefficient;
            this.exposant = exposant;
            this.suivant = suivant;
        }

        /**
         * Retourne le coefficient du terme (le 'a' dans 'ax^b')
         *
         * @return le coefficient du terme
         */
        public double getCoeff() {
            return this.coeff;
        }

        /**
         * Modifie le coefficient du terme (le 'a' dans 'ax^b')
         *
         * @param coeff le nouveau coefficient du terme
         */
        public void setCoeff(double coeff) {
            this.coeff = coeff;
        }

        /**
         * Retourne l'exposant du terme (le 'b' dans 'ax^b')
         *
         * @return l'exposant du terme
         */
        public int getExposant() {
            return this.exposant;
        }

        /**
         * Modifie l'exposant du terme (le 'b' dans 'ax^b')
         *
         * @param exposant le nouvel exposant du terme
         */
        public void setExposant(int exposant) {
            this.exposant = exposant;
        }

        /**
         * Retourne le noeud suivant dans la liste chainée
         *
         * @return le noeud suivant
         */
        public Noeud getSuivant() {
            return this.suivant;
        }

        /**
         * Modifie  le noeud suivant dans la liste chainée
         *
         * @param suivant le nouveau noeud suivant
         */
        public void setSuivant(Noeud next) {
            this.suivant = next;
        }

        /**
         * Retourne une représenbtation textuelle du noeud (terme du polynome)
         * 
         * @return un string réprésentant le terme
         */
        @Override
        public String toString() {
            DecimalFormat formatter = new DecimalFormat("0.#");
            if (exposant == 0) {
                return formatter.format(coeff);
            } else if (exposant == 1) {
                return formatter.format(coeff) + "x";
            }
            return formatter.format(coeff) + "x^" + exposant;
        }
    }

    /**
     * Retourne une représenbtation textuelle du polynome
     * 
     * @return un string réprésentant le polynome
     */
    @Override
    public String toString() {
        Noeud noeud = this.premierNoeud;
        String str = noeud.toString();
        while ((noeud = noeud.getSuivant()) != null) {
            str += " + " + noeud.toString();
        }
        return str.replaceAll("\\+ -", "- ");
    }

    /**
     * Calcule la taille de la liste chaînée
     *
     * @return taille de la liste
     */
    public int size() {
        int size = 0;

        Noeud n = this.premierNoeud;

        while(n != null) {
            size++;
            n = n.getSuivant();
        }

        return size;
    }

    /**
     * Ajoute un terme avec le coefficient et l'exposant spécifiés à la liste
     * chainée (le polynome). Si un terme de meme exposant existe déja alors les
     * coefficients seront additionnés.
     *
     * @param coeff le coefficient du terme à ajouter (le 'a' de 'ax^b')
     * @param exposant l'exposant du terme à ajouter (le 'b' de 'ax^b')
     */
    public void ajouter(double coeff, int exposant) {
        // Si la liste est vide on l'initialise avec le nouveau terme
        if (this.premierNoeud == null) {
            exposant = (coeff == 0) ? 0 : exposant; // Enregistre les termes nulles comme '0x^0'
            this.premierNoeud = new Noeud(coeff, exposant, null);
            return;
        }

        Noeud noeud = this.premierNoeud;
        Noeud precedent = null;
    
        // Parcour la liste pour trouver le premier terme avec un exposant plus petit ou égale à celui à ajouter
        // Note: les termes sont stockés de l'exposant le plus grand au plus petit. On veut donc ajouter le noeud
        // après tous les exposants plus grands.
        while (noeud != null && noeud.exposant > exposant) {
            precedent = noeud;
            noeud = noeud.suivant;
        }
    
        if (noeud != null && noeud.exposant == exposant) {
            noeud.coeff += coeff;

            if (noeud.coeff == 0) {
                retirer(noeud);
            }

        } else {
            Noeud nouveauNoeud = new Noeud(coeff, exposant, noeud);

            if (precedent == null) {
                this.premierNoeud = nouveauNoeud;
            } else {
                precedent.suivant = nouveauNoeud;
            }

            if (nouveauNoeud.coeff == 0) {
                retirer(nouveauNoeud);
            }
        }
    }

    /**
     * Retire un noeud spécifié de la liste chaînée (utile pour enlever
     * les termes avec coefficient 0).
     *
     * @param noeudToDelete le noeud à retirer
     */
    public void retirer(Noeud noeudToDelete) {
        // Si le polynome n'a aucun terme non-nulle on garde
        // quand meme un noeud de valeur 0 pour que 'p = 0'.
        if (noeudToDelete == this.premierNoeud) {
            noeudToDelete.setCoeff(0);
            noeudToDelete.setExposant(0);
            noeudToDelete.setSuivant(null);
        }

        Noeud noeud = this.premierNoeud;
        Noeud noeudSuivant;

        while ((noeudSuivant = noeud.getSuivant()) != null) {
            if (noeudSuivant == noeudToDelete) {
                noeud.setSuivant(noeudSuivant.getSuivant());
            }
            noeud = noeudSuivant;
        }
    }
    
    /**
     * Retourne un itérateur sur les noeuds de la liste chainée. Permet
     * d'utiliser les for-each loop et la méthode .forEach()
     *
     * @return un itérateur sur les noeuds de la liste chainée
     */
    @Override
    public Iterator<Noeud> iterator() {
        return new IterateurDeNoeud();
    }

    /**
     * Classe interne représentant un itérateur sur les noeuds de la liste chainée.
     */
    class IterateurDeNoeud implements Iterator<Noeud>{

        private Noeud noeud;
        
        /**
         * Vérifie s'il y a un noeud suivant le noeud actuel dans la liste chainée.
         *
         * @return true s'il y a un autre noeud après, false sinon
         */
        @Override
        public boolean hasNext() {
            if (noeud == null) {
                noeud = premierNoeud;
                return noeud != null;
            } else {
                noeud = noeud.suivant;
                return noeud != null;
            }
        }
        
        /**
         * Retourne le noeud suivant dans la liste chainée.
         *
         * @return le noeud suivant
         */
        @Override
        public Noeud next() {
            return noeud;
        }
    }
}