/*

@author Nick, Roman, Sönke, Mathis

@version 0407

 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Rook{
    public ImageIcon image;
    private int col, row;
    private int[][][] matrix;
    public boolean set;
    public Rook(int x , int y , String path , int[][][] matrix_board){
        col = x;
        row = y;
        matrix = new int[8][8][2];
        matrix = matrix_board;
        image = new ImageIcon("images/"+ path + ".png");
    }
    public int x(){
        return matrix[col][row][0];
    }
    public int y(){
        return matrix[col][row][1];
    }
    public void changeCords(int colx, int rowy){
        col = colx;
        row = rowy;
    }
}
