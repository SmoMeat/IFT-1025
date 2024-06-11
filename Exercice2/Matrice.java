/**
 * @author Mathieu Ducharme
 * @email mathieu.ducharme@umontreal.ca
 * @matricule 20297456 
 * 
 * Cette classe permet d'instancier des matrices de taille m par n
 * ou une matrice identité de taille m par m et d'effectuer des
 * opérations élémentaires d'algèbre linéaire.
 */

package Exercice2;

import java.util.Arrays;

public class Matrice {
    
    private int numLines;
    private int numCols;
    private double[][] matrix;
    
    /**
     * Constructeur de la matrice
     * @param lignes taille verticale de la matrice à définir
     * @param cols taille horizontale de la matrice à définir
     */
    public Matrice(int lignes, int cols) {
        this.numLines = lignes;
        this.numCols = cols;
        this.matrix = new double[lignes][cols];

        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, 0));
    }

    /**
     * Additionne la valeur n dans toutes les cellules de la matrice
     * @param n valeur à ajouter à  tous les éléments
     * @return void (modifie l'objet)
     */
    public void additionnerScalaire(double n) {
        for (int i=0; i<this.numLines; i++) {
            for (int j=0; j<this.numCols; j++) {
                this.matrix[i][j] += n;
            }
        }
    }

    /**
     * Multiplie la valeur n avec toutes les cellules de la matrice
     * @param n valeur à multiplier à tous les éléments
     * @return void (modifie l'objet)
     */
    public void multiplierScalaire(double n) {
        for (int i=0; i<this.numLines; i++) {
            for (int j=0; j<this.numCols; j++) {
                this.matrix[i][j] *= n;
            }
        }
    }

    /**
     * Calcule le produit matriciel entre deux matrices
     * @param m matrice qu'on veut multiplier à droite
     * @return la nouvelle matrice résultante
     */
    public Matrice dotProduct(Matrice m) {
        if (this.numCols != m.getNumLines()) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

        Matrice toReturn = new Matrice(this.numLines, m.getNumCols());

        for (int i=0; i<toReturn.getNumLines(); i++) {
            for (int j=0; j<toReturn.getNumCols(); j++) {
                for (int k=0; k<m.getNumLines(); k++) {
                    double value = toReturn.getCell(i, j) + this.getCell(i, k) * m.getCell(k, j);
                    toReturn.setCell(i, j, value);
                }
            }
        }

        return toReturn;
    }

    /**
     * Permet d'accéder à la valeur d'une cellule
     * @param ligne numero de ligne de la cellule
     * @param col numero de colonne de la cellule
     * @return la valeur (double) stocké à cette emplacement
     */
    public double getCell(int ligne, int col) {
        return this.matrix[ligne][col];
    }

    /**
     * Permet de modifier la valeur d'une cellule
     * @param ligne numero de ligne de la cellule
     * @param col numero de colonne de la cellule
     * @param valeur double qu'on veut insérer dans la cellule
     */
    public void setCell(int ligne, int col, double valeur) {
        this.matrix[ligne][col] = valeur;
    }

    /**
     * Permet d'avoir seulement un ligne (vecteur) de la matrice
     * @param ligne numero de ligne qu'on veut isolé
     * @return la ligne choisie sous forme de Vecteur
     */
    public Vecteur getLine(int ligne) {
        return new Vecteur(this.matrix[ligne]);
    }

    /**
     * Permet d'avoir seulement une colonne (vecteur) de la matrice
     * @param col numero de la colonne qu'on veut isolé
     * @return la colonne choisie sous forme de Vecteur
     */
    public Vecteur getCol(int col) {
        Matrice transposedMatrix = this.transpose();
        return transposedMatrix.getLine(col);
    }

    /**
     * Affiche à la console la matrice entre crochets. Le format ressemble à:
     * [ 1.0 2.0 ]
     * [ 13.0 14.0 ]
     */
    public void afficher() {
        for (double[] row : this.matrix) {
            System.out.println(Arrays.toString(row)
                                    .replace(",", "")
                                    .replace("[", "[ ")
                                    .replace("]", " ]"));
        }
    }

    /**
     * Calcule la matrice transposée (les lignes deviennent des colonnes)
     * @return la matrice transposée (ne modifie pas l'original)
     */
    public Matrice transpose() {
        Matrice toReturn = new Matrice(this.numLines, this.numCols);

        for (int i=0; i<this.numLines; i++) {
            for (int j=0; j<this.numCols; j++) {
                toReturn.setCell(i, j, this.getCell(j, i));
            }
        }

        return toReturn;
    }

    /**
     * Permet de créer une nouvelle matrice de taille N avec la diagonnale
     * remplie de 1 et le reste rempli de 0.
     * @param n taille de la matrice à instancier
     * @return la matrice identité de taille n x n
     */
    public static Matrice identite(int n) {
        Matrice toReturn = new Matrice(n, n);

        for (int i=0; i<toReturn.getNumLines(); i++) {
            for (int j=0; j<toReturn.getNumCols(); j++) {
                toReturn.setCell(i, j, i==j ? 1 : 0);
            }
        }
        return toReturn;
    }

    /**
     * Permet de connaitre la taille (lignes) de la matrice
     * @return nombre de lignes de la matrice 
     */
    public int getNumLines() {
        return this.numLines;
    }

    /**
     * Permet de connaitre la taille (colonnes) de la matrice
     * @return nombre de colonnes de la matrice 
     */
    public int getNumCols() {
        return this.numCols;
    }
}
