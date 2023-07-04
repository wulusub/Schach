/*

@author Roman

@version 0407

 */

import javax.swing.ImageIcon;
import javax.swing.*;

public class Board{
    public JFrame frame;
    public JLabel cboard;
    public int[][][] board_matrix;

    public Board(){
        /// Frame erstellen
        frame = new JFrame("Schach - Roman, Nick");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  Height 
        frame.setSize(1600, 840);
        frame.setLocation(100, 100);
        ImageIcon image = new ImageIcon("images/frame_icon.jpg");
        frame.setIconImage(image.getImage());
        frame.setResizable(false);
        frame.setLayout(null);

        // Brett als Label displayen
        cboard = new JLabel();
        cboard.setIcon(new ImageIcon("images/chessboard.png"));
        cboard.setBounds(400,0,800,800);

        startSetup();

        frame.add(cboard);


        frame.setVisible(true);
    }

    public void startSetup(){
        /// Setup von der Brett Matrix
        board_matrix = new int[8][8][2];
        for (int col=0; col<8; col++){
            for (int row=0; row < 8; row++){
                for(int tup=0 ;tup < 2;  tup++){
                    if(tup % 2 == 0){
                        board_matrix[col][row][tup] = 410 + row * 100;
                        continue;
                    }
                    board_matrix[col][row][tup] = 10 + col * 100;
                }
            }
        }

        KingWhite kw = new KingWhite(board_matrix[7][4][0], board_matrix[7][4][1]);  // König platziert auf row=8; col=5; und (0|1) = (x|y) Koordinate
        JLabel king_white = new JLabel(kw.image);
        king_white.setBounds(kw.posx, kw.posy , 80 , 80);

        KnightBlack nbo = new KnightBlack(board_matrix[0][1][0], board_matrix[0][1][1]);
        JLabel knight_black_one = new JLabel(nbo.image);
        knight_black_one.setBounds(nbo.posx, nbo.posy, 80, 80);

        KnightBlack nbt = new KnightBlack(board_matrix[0][6][0], board_matrix[0][6][1]);
        JLabel knight_black_two = new JLabel(nbt.image);
        knight_black_two.setBounds(nbt.posx, nbt.posy, 80, 80);

        frame.add(king_white);
        frame.add(knight_black_one);
        frame.add(knight_black_two);

        /* Displaying Matrix
        for (int i=0; i<8; i++){
            for(int j=0; j<8; j++) {
                for(int k =0 ; k<2; k++){
                System.out.print(board_matrix[i][j][k] + " | ");
                }
            }
            System.out.println();
        }
        */
    }

    public static void main(String[] args) {
        new Board();
    }
}