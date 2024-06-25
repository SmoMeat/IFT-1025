package Exercice4;

public class Polynome {

    ListeChainee polynome = new ListeChainee();

    /**
     * Additionne un terme cx^e au polynome.
     *
     * @param coeff coefficient c du terme à ajouter
     * @param exposant exposant e du terme à ajouter
     */
    public void ajouter(double coeff, int exposant) {
        polynome.add(coeff, exposant);
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

        // ...

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

        // ...

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

        // ...

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

        // ...

        return derivee;
    }

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
        System.out.println(p);
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
        assertTest(p.toString().equals("5x^4 + -22x^3 + 13x^2 + 7"), "Ajouter un coefficient négatif");


        Polynome derivee = p.derivee();
        assertTest(derivee.toString().equals("20x^3 + -66x^2 + 26x"), "Dérivée");

        derivee = p.derivee().derivee().derivee().derivee();
        assertTest(derivee.toString().equals("120"), "Dérivée 4 fois");

        derivee = p.derivee().derivee().derivee().derivee().derivee()
                   .derivee().derivee().derivee().derivee().derivee();
        assertTest(derivee.toString().equals("0"), "Dérivée 10 fois");

        // TODO : écrire d'autres tests
    }
}