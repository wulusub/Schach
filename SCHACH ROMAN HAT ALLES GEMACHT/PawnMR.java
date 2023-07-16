/*

@author Mathis

@version 0407



 import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class PawnMR extends King {
    public ImageIcon image;
    private int posx,posy;
    private JFrame frame;

    private PawnMR(int x , int y, String path, JFrame frame_con){
        super(x, y, path, frame_con);
        posx = x;
        posy = y;
        image = new ImageIcon("images/"+ path + ".png");
    }
   //Bewegen nach vorne
     private int[] one_fwd {
        if(posy-100 > 0) {
                fwd();
            
            return new int[]{posx, posy-100};
        } else{
            return new int[]{-1};
        }
    }
 //Bewegen von Startposition(nur eine Farbe bisher) um Zwei nach vorne
     private int[] two_fwd {
        if(posy==610) {
                fwd();
                fwd();
            
            return new int[]{posx, posy-200};
        } else{
            return new int[]{-1};
        }
    }
 //Diagonales Bewegen Links-Oben (eigentlich schlagen)
 private int[] left_up{
  if(posx-100>400 && posy-100>0){
  diLU();
  return new int[]{posx-100;posy-100
 } else{
            return new int[]{-1};
        }
  }
//Diagonales Bewegen Rechts_Oben (eigentlich schlagen)
private int[] right_up{
  if(posx+100<1200 && posy-100>0){
  diRU();
  return new int[]{posx+100;posy-100
 } else {
            return new int[]{-1};
        }
  }
}
*/