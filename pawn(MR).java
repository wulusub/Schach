/*

@author Mathis

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

     public int[] one_fwd {
        if(posy-80 > 0) {
                fwd();
            
            return new int[]{posx, posy-80};
        } else{
            return new int[]{-1};
        }
    }
     public int[] two_fwd {
        if(posy==560) {
                fwd();
                fwd();
            
            return new int[]{posx, posy-160};
        } else{
            return new int[]{-1};
        }
    }

}
