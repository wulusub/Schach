import javax.swing.ImageIcon;
public class KingBlack {
    public ImageIcon image;
    public int posx,posy;
    

    public KingBlack(int x , int y){
        posx = x;
        posy = y;
        image = new ImageIcon("\\\\\\\\dc1.asg.schule\\\\home\\\\ROM.PETRC\\\\Desktop\\\\Inf\\\\Q11\\\\schach2906\\\\images\\\\king_black.png");
    }

    public KingBlack(){
        image = new ImageIcon("\\\\\\\\dc1.asg.schule\\\\home\\\\ROM.PETRC\\\\Desktop\\\\Inf\\\\Q11\\\\schach2906\\\\images\\\\king_black.png");
    }
}
