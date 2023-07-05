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
    public String[][] board_position;
    public String pgn_position;

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

        board_position = new String[8][8];

        pgn_position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        boardPosition(pgn_position);

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
        int black_pawn_num=0;
        int white_pawn_num=0;

        for (int col=0; col<8; col++){
            for(int row=0; row<8; row++) {
                switch (pgn.charAt(i)) {
                    case (char) "r" -> {
                        if (black_rook_one.set != true) {
                            black_rook_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(black_rook_one);
                            black_rook_one.set = true;
                            i++;
                            continue;
                        }
                        black_rook_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_rook_two);
                        i++;
                    }
                    case (char) "n" -> {
                        if (black_knight_one.set != true) {
                            black_knight_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(black_knight_one);
                            black_knight_one.set = true;
                            i++;
                            continue;
                        }
                        black_knight_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_knight_two);
                        i++;
                    }
                    case (char) "b" -> {
                        if (black_bishop_one.set != true) {
                            black_bishop_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(black_bishop_one);
                            black_bishop_one.set = true;
                            i++;
                            continue;
                        }
                        black_bishop_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_bishop_two);
                        i++;
                    }
                    case (char) "q" -> {
                        black_queen.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_queen);
                        i++;
                    }
                    case (char) "k" -> {
                        black_king.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(black_king);
                        i++;
                    }
                    case (char) "p" -> {
                        switch (black_pawn_num){
                            case 0 -> {
                                black_pawn_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_one);
                                i++;
                            }
                            case 1 -> {
                                black_pawn_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_two);
                                i++;
                            }
                            case 2 -> {
                                black_pawn_three.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_three);
                                i++;
                            }
                            case 3 -> {
                                black_pawn_four.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_four);
                                i++;
                            }
                            case 4 -> {
                                black_pawn_five.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_five);
                                i++;
                            }
                            case 5 -> {
                                black_pawn_six.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_six);
                                i++;
                            }
                            case 6 -> {
                                black_pawn_seven.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_seven);
                                i++;
                            }
                            case 7 -> {
                                black_pawn_eight.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(black_pawn_eight);
                                i++;
                            }
                        }
                    }

                    // White Pieces
                    case (char) "R" -> {
                        if (white_rook_one.set != true) {
                            white_rook_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(white_rook_one);
                            white_rook_one.set = true;
                            i++;
                            continue;
                        }
                        black_rook_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_rook_two);
                        i++;
                    }
                    case (char) "N" -> {
                        if (white_knight_one.set != true) {
                            white_knight_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(white_knight_one);
                            white_knight_one.set = true;
                            i++;
                            continue;
                        }
                        white_knight_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_knight_two);
                        i++;
                    }
                    case (char) "B" -> {
                        if (white_bishop_one.set != true) {
                            white_bishop_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                            print(white_bishop_one);
                            white_bishop_one.set = true;
                            i++;
                            continue;
                        }
                        white_bishop_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_bishop_two);
                        i++;
                    }
                    case (char) "Q" -> {
                        white_queen.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_queen);
                        i++;
                    }
                    case (char) "K" -> {
                        white_king.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                        print(white_king);
                        i++;
                    }
                    case (char) "P" -> {
                        switch (white_pawn_num){
                            case 0 -> {
                                white_pawn_one.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_one);
                                i++;
                            }
                            case 1 -> {
                                white_pawn_two.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_two);
                                i++;
                            }
                            case 2 -> {
                                white_pawn_three.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_three);
                                i++;
                            }
                            case 3 -> {
                                white_pawn_four.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_four);
                                i++;
                            }
                            case 4 -> {
                                white_pawn_five.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_five);
                                i++;
                            }
                            case 5 -> {
                                white_pawn_six.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_six);
                                i++;
                            }
                            case 6 -> {
                                white_pawn_seven.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_seven);
                                i++;
                            }
                            case 7 -> {
                                white_pawn_eight.changeCords(board_matrix[col][row][0], board_matrix[col][row][1]);
                                print(white_pawn_eight);
                                i++;
                            }
                        }
                    }

                    default -> i += (int) pgn.charAt(i);
                }
            }
        }
    }

    public void print(){}

    public static void main(String[] args) {
        new Board();
    }
}