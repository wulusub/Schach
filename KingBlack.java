import javax.swing.ImageIcon;
public class KingBlack {
    public ImageIcon image;
    public int posx,posy;
    

    public KingBlack(int x , int y){
        posx = x;
        posy = y;
        image = new ImageIcon("images/king_black.png");
    }

    public KingBlack(){
        image = new ImageIcon("images/king_black.png");
    }
}
