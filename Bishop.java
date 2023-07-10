/*
@author Mathis 
*/
import javax.swing.ImageIcon;
public class KnightBlack extends King {
   public ImageIcon image;
    public int posx,posy;
    

    public KnightBlack(int x , int y, String path, JFrame frame_con){
        super(x, y, path, frame_con);
        image = new ImageIcon("images/"+ path +".png");
    }

//Bewegen nach Vorne-Links
    public int[] fwd_DL(int distance){
        if(posy-distance*80 > 0 && posx-distance*80 > 400) {
            for(int i=0; i>distance; i++){
                diLU();
            }
            return new int[]{posx-distance*80, posy-distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Vorne-Rechts
    public int[] fwd_DR(){
        if(posy-distance*80 > 0 && posx+distance*80 < 1200){
            diRU();
            return new int[]{posx+distance*80, posy-distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Hinten-Links
    public int[] bwd_DL(){
        if(posx-distance*80 > 400 && posy+distance*80 < 800){
            diLL();
            return new int[]{posx-distance*80, posy+distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Hinten-Rechts
     public int[] bwd_DR(){
        if(posy+distance*80 < 800 && posx+distance*80 < 1200){
            diRL();
            return new int[]{posx+distance*80, posy+distance*80};
        } else{
            return new int[]{-1};
        }
    }

   
}
