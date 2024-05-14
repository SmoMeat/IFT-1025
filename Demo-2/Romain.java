public class Romain {
    private int valeurNombre;

    /**
     * Construit un nombre romain.
     * @param valeurNombre Entier qui sera converti en romain
     */
    public Romain(int valeurNombre) {
        this.valeurNombre = valeurNombre;
    }

    /**
     * Retourne la représentation romaine du nombre contenu dans l'objet.
     * @return Représentation romaine du nombre actuel
     */
    public String valeur() {
        return romain(valeurNombre);
    }

    /**
     * Additionner un nombre romain à l'objet actuel.
     * @param romain Nombre à ajouter
     */
    public void ajouter(Romain romain) {
        valeurNombre += romain.valeurNombre;
    }

    /**
     * Multiplier un nombre romain à l'objet actuel.
     * @param romain Nombre à multiplier
     */
    public void multiplier(Romain romain) {
        valeurNombre *= romain.valeurNombre;
    }

    /**
     * Retourne un texte correspondant à la numération romaine de n, qui doit
     * être un nombre entier entre 1 et 3999
     */
    private static String romain(int n) {

        return chiffre(n, 1000, "M", "?", "?")
                + chiffre(n, 100, "C", "D", "M")
                + chiffre(n, 10, "X", "L", "C")
                + chiffre(n, 1, "I", "V", "X");
    }

    /**
     * Retourne un texte correspondant au chiffre de n de poids puiss10.
     */
    private static String chiffre(int n, int puiss10, String un, String cinq, String dix) {

        // Retourne un texte correspondant au chiffre de n de poids puiss10.
        int c = (int) Math.floor(n / puiss10) % 10;

        if (c < 4) {
            return repeter(c, un);
        } else if (c == 4) {
            return "" + un + cinq;
        } else if (c < 9) {
            return cinq + repeter(c - 5, un);
        } else {
            return "" + un + dix;
        }
    }

    /**
     * Retourne un texte qui contient n répétitions du texte sujet (par exemple
     * repeter(3,"I") retourne "III").
     */
    private static String repeter(int n, String sujet) {

        // Retourne un texte qui contient n répétitions du texte sujet
        // (par exemple repeter(3,"I") retourne "III").
        String accum = "";

        for (int i = n; i > 0; i--) {
            accum += sujet;
        }

        return accum;
    }

    public static void main(String[] args) {
        Romain r1 = new Romain(10);
        Romain r2 = new Romain(4);

        System.out.println(r1.valeur());
        // => Affiche "X"

        System.out.println(r2.valeur());
        // => Affiche "IV"

        r1.ajouter(r2); // On ajoute 4 à 10

        System.out.println(r1.valeur());
        // => Affiche "XIV"

        r1.multiplier(r2); // On multiplie 14 par 4

        System.out.println(r1.valeur());
        // => Affiche "LVI"
    }
}