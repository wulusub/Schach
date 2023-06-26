

public class Brett {
    public Feld[][] brett;

    public Brett(){
        boolean bool = true;
        brett = new Feld[8][8];
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                brett[i][j] = new Feld(bool);
                bool = !bool;
            }
        }
    }
}