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
   //Bewegen nach vorne
     public int[] one_fwd {
        if(posy-80 > 0) {
                fwd();
            
            return new int[]{posx, posy-80};
        } else{
            return new int[]{-1};
        }
    }
 //Bewegen von Startposition um Zwei nach vorne
     public int[] two_fwd {
        if(posy==560) {
                fwd();
                fwd();
            
            return new int[]{posx, posy-160};
        } else{
            return new int[]{-1};
        }
    }
 //Diagonales Bewegen Links-Oben (eigentlich schlagen)
 public int[] left_up{
  if(posx-80>0 && posy-80>0){
  diLU();
  return new int[]{posx-80;posy-80}
 } else{
            return new int[]{-1};
        }
  }
//Diagonales Bewegen Rechts_Oben (eigentlich schlagen)
public int[] right_up{
  if(posx+80<1200 && posy-80>0){
  diLU();
  return new int[]{posx+80;posy-80}
 } else {
            return new int[]{-1};
        }
  }
}
