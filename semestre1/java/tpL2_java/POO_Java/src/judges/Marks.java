import java.util.Arrays;

/**
 * Marks
 */
public class Marks {
protected int [][] notes ;
protected int juge , critere ,hautNote ;

    public Marks(int juge , int critere ,int hautNote){
        notes = new int[juge][critere] ;
        this.juge = juge ;
        this.critere = critere ;
        this.hautNote =hautNote ;
    }
public void setMark(int juge ,int critere ,int note){
    notes[juge][critere] = note ;
}
public int getMark(int j , int c){
    return notes[j][c] ;
}
public float average(int critere){
    int[] n = notes[critere] ;
    int min =Arrays.stream(n).min().getAsInt();
    int max=Arrays.stream(n).max().getAsInt();
    int indexMin=Arrays.asList(n).indexOf(min);
    int indexMax=Arrays.asList(n).indexOf(max);
    n[indexMin] = 0 ;
    n[indexMax] = 0 ;
    float moy = 0 ;
    for(int note : n){
        moy=moy+note ;
    }
 return moy/(n.length-2) ;
}
}