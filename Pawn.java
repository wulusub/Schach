/*

@author Robert

@version 0407

 */

 import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Pawn extends King {
    public ImageIcon image;
    public int posx,posy;
    public JFrame frame;

    public Pawn(int x , int y, String path, JFrame frame_con){
        super(x, y, path, frame_con);
        posx = x;
        posy = y;
        image = new ImageIcon("images/"+ path + ".png");
    }

    public int fwd() {
        if (posy-80 > 0) {
            posy -= 80;
            return -80;
        }
        throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");

    }

     //Exceptions fehlen (nur diagonal wenn man schlägt)
    public int[] diagLeftup(){
        try {
            return new int[]{fwd() , swl()};
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return diagLeftup();
    }

    //Exceptions fehlen (nur diagonal wenn man schlägt)
    public int[] diagRightup(){
        try {
            return new int[]{fwd() , swr()};
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return diagRightup();
    }
}
