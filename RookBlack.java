/*

@author Nick, Roman

@version 0407

 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Frame;

public class Rook extends King{
    public ImageIcon image;
    public int posx,posy;
    public Frame frame;
    

    public Rook(int x , int y, String path, JFrame frame_con){
        posx = x;
        posy = y;
        image = new ImageIcon("images/"+ path + ".png");
        frame_con = (JFrame) frame;
    }

    //Bewegen nach Vorne
    public int[] fwd_one(int distance){
        if(posy-distance*80 > 0) {
            for(int i=0; i>distance; i++){
                fwd();
            }
            return new int[]{posx, posy-distance*80};
        } else{
            return new int[]{-1};
        }
    }

    //Bewegen nach Hinten
    public int[] bwd_one(int distance){
        if(posy+distance*80 < 800) {
            for(int i=0; i>distance; i++){
                bwd();
            }
            return new int[]{posx, posy+distance*80};
        } else {
            return new int[]{-1};
        }
    }

    //Bewegen nach Links
    public int[] swl_one(int distance){
        if(posx-distance*80 > 400) {
            for(int i=0; i<distance; i++){
                swl();
            }
            return new int[]{posx-distance*80, posy};
        } else {
            return new int[]{-1};
        }
    }
    
    //Bewegen nach Rechts
    public int[] swr_one(int distance){
        if(posx+distance*80 < 1200) {
            for(int i=0; i<distance; i++){
                swr();
            }
            return new int[]{posx+distance*80, posy};
        } else {
            return new int[]{-1};
        }
    }
}
