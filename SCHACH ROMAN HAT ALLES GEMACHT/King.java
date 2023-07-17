/*

@author   Roman, Sönke

@version 1507

 */

import javax.swing.ImageIcon;
public class King{
    public ImageIcon image;
    private int col, row;
    private int[][][] matrix;
    public boolean set;
    public King(int x , int y , String path , int[][][] matrix_board){
        col = x;
        row = y;
        matrix = new int[8][8][2];
        matrix = matrix_board;
        image = new ImageIcon("images/"+ path + ".png");
    }
//Methode zur Rückgabe der Position
    public int x(){
        return matrix[col][row][0];    //Aufruf der Matrix zur Rückgabe der gespeicherten Position
    }
    public int y(){
        return matrix[col][row][1];    //Aufruf der Matrix zur Rückgabe der gespeicherten Position
    }
//Methode zur Koordinatenneuzuordnung
    public void changeCords(int colx, int rowy){
        col = colx;
        row = rowy;
    }
}
