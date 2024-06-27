/**
 * @author Mathieu Ducharme
 * @email mathieu.ducharme@umontreal.ca
 * @matricule 20297456
 * 
 * L'exercice 4 consiste en l'implémentation d'une classe polynome qui
 * permet de définir un polynome comme '5.5x^9 + 9x^7 - x - 10' tel que
 * l'information est stockée sous forme de liste chainée.
 * 
 * *** Ce travail a été compilé avec javac 22.0.1 ***
 * 
 * >>> del Exercice4\*.class & javac Exercice4\Polynome.java && java Exercice4.Polynome
 */

package Exercice4;

import java.util.function.Consumer;

public class Polynome {

    ListeChainee polynome = new ListeChainee();

    /**
     * Additionne un terme cx^e au polynome.
     *
     * @param coeff coefficient c du terme à ajouter
     * @param exposant exposant e du terme à ajouter
     */
    public void ajouter(double coeff, int exposant) {
        polynome.ajouter(coeff, exposant);
    }

    /**
     * Addition d'un polynome par un autre. Cette fonction ne
     * modifie pas le polynome actuel.
     *
     * @param autre le polynome à additionner
     * @return un nouveau polynome contenant le résultat de
     * l'addition
     */
    public Polynome additionner(Polynome autre) {
        Polynome resultat = new Polynome();

        autre.forEach(terme -> resultat.ajouter(terme.getCoeff(), terme.getExposant()));
        polynome.forEach(terme -> resultat.ajouter(terme.getCoeff(), terme.getExposant()));

        return resultat;
    }
	
    /**
     * Multiplication par une constante. Cette fonction ne modifie pas
     * le polynome actuel.
     *
     * @param c constante multiplicative
     * @return un nouveau polynome correspondant au polynome actuel
     * (this) multiplié par une constante
     */
    public Polynome multiplier(double c) {
        Polynome resultat = new Polynome();

        polynome.forEach(terme -> resultat.ajouter(c * terme.getCoeff(), terme.getExposant()));

        return resultat;
    }

    /**
     * Multiplication d'un polynome par un autre. Cette fonction ne
     * modifie pas le polynome actuel.
     *
     * @param autre le polynome à multiplier
     * @return un nouveau polynome contenant le résultat de la
     * multiplication
     */
    public Polynome multiplier(Polynome autre) {
        Polynome resultat = new Polynome();

        for (ListeChainee.Noeud premierTerme : polynome) {
            autre.forEach(deuxiemeTerme -> {
                resultat.ajouter(
                    premierTerme.getCoeff() * deuxiemeTerme.getCoeff(),
                    premierTerme.getExposant() + deuxiemeTerme.getExposant()
                );
            });
        }

        return resultat;
    }

    /**
     * Retourne la dérivée sous la forme d'un nouveau polynome. Cette
     * fonction ne modifie pas le polynome actuel.
     *
     * @return la dérivée du polynome actuel sous la forme d'un
     * nouveau polynome
     */
    public Polynome derivee() {
        Polynome derivee = new Polynome();

        polynome.forEach(terme -> {
            derivee.ajouter(
                terme.getCoeff()  * terme.getExposant(),
                terme.getExposant() - 1
            );
        });

        return derivee;
    }

    /**
     * Applique une action à chaque terme du polynome. Permet d'itérerer
     * à travers les termes sans rendre public l'objet 'ListeChainee' qui
     * est lui réellement itérable.
     * 
     * @param action l'action à appliquer à chaque terme 
     */
    public void forEach(Consumer<ListeChainee.Noeud> action) {
        for (ListeChainee.Noeud noeud : polynome) {
            action.accept(noeud);
        }
    }

    /**
     * Retourne une représenbtation textuelle du polynome
     * 
     * @return un string réprésentant le polynome
     */
    @Override
    public String toString() {
        return polynome.toString();
    }

    /**
     * Fonction utilitaire pour tester la classe.
     *
     * @param test résultat du test unitaire
     * @param message description du test
     */
    public static void assertTest(boolean test, String message) {
        if(test) {
            System.out.println("OK: " + message);
        } else {
            System.out.println("ERREUR: " + message);
        }
    }

    /**
     * À compléter : quelques tests pour vous aider
     */
    public static void main(String[] args) {

        Polynome p = new Polynome();

        p = new Polynome();
        p.ajouter(10, 0);
        assertTest(p.toString().equals("10"), "Un seul terme (constante)");

        p = new Polynome();
        p.ajouter(10, 1);
        assertTest(p.toString().equals("10x"), "Un seul terme (exposant=1)");

        p = new Polynome();
        p.ajouter(10, 2);
        assertTest(p.toString().equals("10x^2"), "Un seul terme (exposant=2)");

        p.ajouter(5, 4);
        assertTest(p.toString().equals("5x^4 + 10x^2"), "Deux termes");

        p.ajouter(3, 2);
        assertTest(p.toString().equals("5x^4 + 13x^2"), "Ajouter à un terme déjà présent");

        p.ajouter(7, 0);
        assertTest(p.toString().equals("5x^4 + 13x^2 + 7"), "Ajouter une constante");

        p.ajouter(-22, 3);
        assertTest(p.toString().equals("5x^4 - 22x^3 + 13x^2 + 7"), "Ajouter un coefficient négatif");

        Polynome derivee = p.derivee();
        assertTest(derivee.toString().equals("20x^3 - 66x^2 + 26x"), "Dérivée");
        
        derivee = p.derivee().derivee().derivee().derivee();
        assertTest(derivee.toString().equals("120"), "Dérivée 4 fois");

        derivee = p.derivee().derivee().derivee().derivee().derivee()
                   .derivee().derivee().derivee().derivee().derivee();
        assertTest(derivee.toString().equals("0"), "Dérivée 10 fois");

        // TODO : écrire d'autres tests

        assertTest(p.additionner(p).toString().equals("10x^4 - 44x^3 + 26x^2 + 14"), "Addition #1");

        Polynome p1 = new Polynome();
        p1.ajouter(3, 0);
        p1.ajouter(-2, 1);
        p1.ajouter(1,3);
        assertTest(p1.toString().equals("1x^3 - 2x + 3"), "Définir un polynome p1");
        
        Polynome p2 = new Polynome();
        p2.ajouter(7, 0);
        p2.ajouter(4, 2);
        p2.ajouter(3, 3);
        assertTest(p2.toString().equals("3x^3 + 4x^2 + 7"), "Définir un polynome p2");

        Polynome p3 = p1.additionner(p2);
        assertTest(p3.toString().equals("4x^3 + 4x^2 - 2x + 10"), "Addition deux polynomes (p3 = p1 + p2)");

        Polynome p4 = p3.multiplier(2);
        assertTest(p4.toString().equals("8x^3 + 8x^2 - 4x + 20"), "Multiplication par une constante (p4 = 2 * p3)");
        
        Polynome p5 = p1.multiplier(p2);
        assertTest(p5.toString().equals("3x^6 + 4x^5 - 6x^4 + 8x^3 + 12x^2 - 14x + 21"), "Multiplication de deux polynomes (p5 = p1 * p2)");
        
        Polynome p6 = p5.derivee();
        assertTest(p6.toString().equals("18x^5 + 20x^4 - 24x^3 + 24x^2 + 24x - 14"), "Dérivée d'un polynome (p6 = p5')");
    }
}