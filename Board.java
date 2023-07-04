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
    public String board_position;

    public Board() {startSetup(); }


    public void startSetup(){
        /// Setup des Frames
        frame = new JFrame("Schach - Roman, Nick");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 840);
        frame.setLocation(100, 100);
        ImageIcon image = new ImageIcon("images/frame_icon.jpg");
        frame.setIconImage(image.getImage());
        frame.setResizable(false);
        frame.setLayout(null);

        // Setup des Brettes als Label
        cboard = new JLabel();
        cboard.setIcon(new ImageIcon("images/chessboard.png"));
        cboard.setBounds(400,0,800,800);

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

        board_position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

        boardPosition(board_position);

        /// Weiße Figuren
        KingWhite white_king = new KingWhite(board_matrix[7][4][0], board_matrix[7][4][1]);  // König platziert auf row=8; col=5; und (0|1) = (x|y) Koordinate
        JLabel white_king_label = new JLabel(white_king.image);
        white_king_label.setBounds(white_king.posx, white_king.posy , 80 , 80);

        /// Schwarze Figuren
        KnightBlack black_knight_one = new KnightBlack(board_matrix[0][1][0], board_matrix[0][1][1]);
        JLabel black_knight_one_label = new JLabel(black_knight_one.image);
        black_knight_one_label.setBounds(black_knight_one.posx, black_knight_one.posy, 80, 80);

        KnightBlack black_knight_two = new KnightBlack(board_matrix[0][6][0], board_matrix[0][6][1]);
        JLabel black_knight_two_label = new JLabel(black_knight_two.image);
        black_knight_two_label.setBounds(black_knight_two.posx, black_knight_two.posy, 80, 80);

        frame.add(white_king_label);
        frame.add(black_knight_one_label);
        frame.add(black_knight_two_label);

        frame.add(cboard);

        frame.setVisible(true);
    }

    public void boardPosition(String pgn){
        int i=0;
        for (int col=0; col<8; col++){
            for(int row=0; row<8; row++) {
                switch (pgn.charAt(i)) {
                    case (char) "r" -> {
                        if (black_rook_one.set != true) {
                            black_rook_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(black_rook_one);
                            black_rook_one.set = true;
                            continue;
                        }
                        black_rook_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_rook_two);
                        continue;
                    }
                    case (char) "n" -> {
                        if (black_knight_one.set != true) {
                            black_knight_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(black_knight_one);
                            black_knight_one.set = true;
                            continue;
                        }
                        black_knight_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_knight_two);
                        continue;
                    }
                    case (char) "b" -> {
                        if (black_bishop_one.set != true) {
                            black_bishop_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(black_bishop_one);
                            black_bishop_one.set = true;
                            continue;
                        }
                        black_bishop_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_bishop_two);
                        continue;
                    }
                    case (char) "q" -> {
                        black_queen.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_queen);
                        continue;
                    }
                    case (char) "k" -> {
                        black_king.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_king);
                        continue;
                    }

                    // White Pieces
                    case (char) "R" -> {
                        if (white_rook_one.set != true) {
                            white_rook_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(white_rook_one);
                            white_rook_one.set = true;
                            continue;
                        }
                        black_rook_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_rook_two);
                        continue;
                    }
                    case (char) "N" -> {
                        if (white_knight_one.set != true) {
                            white_knight_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(white_knight_one);
                            white_knight_one.set = true;
                            continue;
                        }
                        white_knight_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_knight_two);
                        continue;
                    }
                    case (char) "B" -> {
                        if (white_bishop_one.set != true) {
                            white_bishop_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(white_bishop_one);
                            white_bishop_one.set = true;
                            continue;
                        }
                        white_bishop_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_bishop_two);
                        continue;
                    }
                    case (char) "Q" -> {
                        white_queen.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_queen);
                        continue;
                    }
                    case (char) "K" -> {
                        white_king.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_king);
                        continue;
                    }
                    default -> i += (int) pgn.charAt(i);
                }
                i++;
            }
            i++;
        }
    }

    public void print(){}

    public static void main(String[] args) {
        new Board();
    }
}