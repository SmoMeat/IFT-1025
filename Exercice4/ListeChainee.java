package Exercice4;

import java.util.Iterator;
import java.util.Optional;
import java.text.DecimalFormat;


public class ListeChainee implements Iterable<ListeChainee.Noeud> {

    private Noeud premierNoeud;

    class Noeud {
        public double coeff;
        public int exposant;
        public Noeud suivant;

        public Noeud(double coefficient, int exposant, Noeud suivant) {
            this.coeff = coefficient;
            this.exposant = exposant;
            this.suivant = suivant;
        }

        public double getCoeff() {
            return this.coeff;
        }

        public void setCoeff(double coeff) {
            this.coeff = coeff;
        }

        public int getExposant() {
            return this.exposant;
        }

        public void setExposant(int exposant) {
            this.exposant = exposant;
        }

        public Noeud getSuivant() {
            return this.suivant;
        }

        public void setSuivant(Noeud next) {
            this.suivant = next;
        }

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

    @Override
    public String toString() {
        Noeud noeud = this.premierNoeud;
        String str = noeud.toString();
        while ((noeud = noeud.getSuivant()) != null) {
            str += " + " + noeud.toString();
        }
        return str;
    }

    public int size() {
        int size = 0;

        Noeud n = this.premierNoeud;

        while(n != null) {
            size++;
            n = n.getSuivant();
        }

        return size;
    }

    public void ajouter(double coeff, int exposant) {
        if (this.premierNoeud == null) {
            exposant = (coeff == 0) ? 0 : exposant;
            this.premierNoeud = new Noeud(coeff, exposant, null);
            return;
        }
        Noeud noeud = this.premierNoeud;

        while (noeud.exposant > exposant) {
            if (noeud.getSuivant() != null) {
                noeud = noeud.getSuivant();
            } else {
                Noeud nouveauNoeud = new Noeud(0, exposant, null);
                noeud.suivant = nouveauNoeud;
                noeud = nouveauNoeud;
            }
        }
        
        noeud.suivant = (noeud.exposant != exposant)
                        ? new Noeud(noeud.coeff, noeud.exposant, noeud.getSuivant())
                        : noeud.getSuivant();
        noeud.coeff = (noeud.exposant != exposant)
                        ? coeff
                        : noeud.coeff + coeff;
        noeud.exposant = exposant;

        if (noeud.coeff == 0) {
            retirer(noeud);
        }
    }

    public void retirer(Noeud noeudToDelete) {
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
    
    public Iterator<Noeud> iterator() {
        return new NodeIterator();
    }

    class NodeIterator implements Iterator<Noeud>{
        private Noeud current;

        public boolean hasNext() {
            if (current == null) {
                current = premierNoeud;
                return Optional.ofNullable(current).isPresent();
            } else {
                current = current.suivant;
                return Optional.ofNullable(current).isPresent();
            }
        }

        public Noeud next() {
            return current;
        }
    }
}