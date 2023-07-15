/*

@author Roman

@version 1507

 */

import javax.swing.ImageIcon;
public class King extends Board{
    public ImageIcon image;
    public int col, row;
    public int posx = matrix_cords[col][row][0];
    public int posy = matrix_cords[col][row][1];
    public boolean set;
    public King(int x , int y , String path){
        set = false;
        col = x;
        row = y;
        image = new ImageIcon("images/"+ path + ".png");
    }

    public King() {
    }

    public void changeCords(int colx, int rowy){
        col = colx;
        row = rowy;
    }

    public void fwd() {
        if (row-1 >= 0) {
            row--;
        } else {
            throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");
        }

    }

    public void bwd() {
        if (row+1 <= 7) {
            row++;
        } else {
            throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");
        }
    }

    public void swl(){
        if (col-1 >= 0) {
            col--;
        } else {
            throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");
        }
    }

    public void swr(){
        if (col+1 >= 0) {
            col++;
        } else {
            throw new IllegalArgumentException("Figur kann nicht sich nicht außerhalb des Feldes bewegen!");
        }
    }

    public void diLU(){
        try {
            fwd();
            swl();
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            diLU();
        }
    }

    public void diRU(){
        try {
            fwd();
            swr();
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            diRU();
        }
    }

    public void diLL(){
        try {
            bwd();
            swl();
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            diLL();
        }
    }

    public void diRL(){
        try {
            bwd();
            swr();
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            diRL();
        }
    }
}
