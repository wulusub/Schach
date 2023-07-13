/*
@author Mathis 
*/
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Bishop extends King {
   public ImageIcon image;
    public int posx,posy;
    

    public Bishop(int x , int y, String path, JFrame frame_con){
        super(x, y, path, frame_con);
        image = new ImageIcon("images/"+ path +".png");
    }

//Bewegen nach Vorne-Links
    public int[] fwd_DL(int distance){
        if(posy-distance*100 > 0 && posx-distance*100 > 400) {
            for(int i=0; i>distance; i++){
                diLU();
            }
            return new int[]{posx-distance*100, posy-distance*100};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Vorne-Rechts
    public int[] fwd_DR(int distance){
        if(posy-distance*100 > 0 && posx+distance*100 < 1200){
            diRU();
            return new int[]{posx+distance*100, posy-distance*100};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Hinten-Links
    public int[] bwd_DL(int distance){
        if(posx-distance*100 > 400 && posy+distance*100 < 800){
            diLL();
            return new int[]{posx-distance*100, posy+distance*100};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Hinten-Rechts
     public int[] bwd_DR(int distance){
        if(posy+distance*100 < 800 && posx+distance*100 < 1200){
            diRL();
            return new int[]{posx+distance*100, posy+distance*100};
        } else{
            return new int[]{-1};
        }
    }

   
}
