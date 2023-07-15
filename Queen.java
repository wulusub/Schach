/*

@author Robert, Sönke

@version 1007

 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Queen extends King {
    public ImageIcon image;
    public int posx,posy;
    public boolean set;
    

    public Queen(int x , int y, String path, JFrame frame_con){
        set = false;
        posx = x;
        posy = y;
        image = new ImageIcon("images/"+ path +".png");
    }

    
  

    //Bewegen nach Links-Oben
    public int[] left_up(int distance){
        if(posx-distance*80 > 400 && posy-distance*80 >0){
            diLU();
            return new int[]{posx-distance*80, posy-distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Links-Seite
    public int[] left_side(int distance){
        if(posx-distance*80 > 400){
            swl();
            return new int[]{posx-distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Links-Unten
     public int[] left_low(int distance){
        if(posx-distance*80 > 400 && posy+distance*80 < 800){
            diLL();
            return new int[]{posx-distance*80, posy+distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Rechts-Oben
    public int[] right_up(int distance){
        if(posx+distance*80 < 800 && posy-distance*80 >0){
            diRU();
            return new int[]{posx+distance*80, posy-distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Rechts-Seite
    public int[] right_side(int distance){
        if(posx+distance*80 < 800){
            swr();
            return new int[]{posx+distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Rechts-Unten
     public int[] right_low(int distance){
        if(posx+distance*80 < 800 && posy+distance*80 < 800){
            diRL();
            return new int[]{posx+160, posy+80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Oben
    public int[] straight_up(int distance){
        if( posy-distance*80 >0){
            fwd();
            return new int[]{posy-distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Unten
    public int[] straight_low(int distance){
        if( posy+distance*80 >0){
            bwd();
            return new int[]{posy+distance*80};
        } else{
            return new int[]{-1};
        }
    }

}
