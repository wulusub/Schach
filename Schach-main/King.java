/*

@author Roman

@version 0407

 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class King {
    public ImageIcon image;
    public int posx,posy;
    public boolean set;

    public King(int x , int y , String path, JFrame frame_con){
        set = false;
        posx = x;
        posy = y;
        image = new ImageIcon("images/"+ path + ".png");
    }
    
    public void print(int x, int y, String[][] boardPosition){
        
    }

    public int fwd() {
        if (posy-80 > 0) {
            posy -= 80;
            return -80;
        }
        throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");

    }

    public int bwd() {
        if (posy + 80 < 800) {
            posy += 80;
            return 80;
        }
        throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");
    }

    public int swl(){
        if(posx - 80 > 400){
            posx -= 80;
            return -80;
        }
        throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");
    }

    public int swr(){
        if(posx + 80 < 1200){
            posx += 80;
        }
        throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");
    }

    public int[] diLU(){
        try {
            return new int[]{fwd() , swl()};
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return diLU();
    }

    public int[] diRU(){
        try {
            return new int[]{fwd() , swr()};
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return diRU();
    }

    public int[] diLL(){
        try {
            return new int[]{bwd() , swl()};
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return diLL();
    }

    public int[] diRL(){
        try {
            return new int[]{bwd() , swr()};
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return diRL();
    }
}
