package terrain;

/**
 * Terrain
 */
public class Terrain {

    private int line,colonne ;
    public Terrain(int line ,int colonne){
        this.line = line;
        this.colonne = colonne;
    }
    public int getLine() {
        return line;
    }
    public int getColonne() {
        return colonne;
    }
}