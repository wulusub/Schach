/*

@author alleine Roman

@version 1507

 */

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board {
    private JFrame frame;
    private JLabel cboard;
    private JButton submit;
    private JTextField input;
    private JTextArea printline;
    private JLabel white_pawn_one_label, white_pawn_two_label, white_pawn_three_label, white_pawn_four_label,
            white_pawn_five_label, white_pawn_six_label, white_pawn_seven_label, white_pawn_eight_label,
            black_pawn_one_label, black_pawn_two_label, black_pawn_three_label, black_pawn_four_label,
            black_pawn_five_label, black_pawn_six_label, black_pawn_seven_label, black_pawn_eight_label,
            white_rook_one_label, white_rook_two_label, black_rook_one_label, black_rook_two_label,
            white_knight_one_label, white_knight_two_label, black_knight_one_label, black_knight_two_label,
            white_bishop_one_label, white_bishop_two_label, black_bishop_one_label, black_bishop_two_label,
            white_queen_label, black_queen_label, white_king_label, black_king_label;

    private Pawn white_pawn_one, white_pawn_two, white_pawn_three, white_pawn_four,
            white_pawn_five, white_pawn_six, white_pawn_seven, white_pawn_eight,
            black_pawn_one, black_pawn_two, black_pawn_three, black_pawn_four,
            black_pawn_five, black_pawn_six, black_pawn_seven, black_pawn_eight;
    private Rook white_rook_one, white_rook_two, black_rook_one, black_rook_two;
    private Knight white_knight_one, white_knight_two, black_knight_one, black_knight_two;
    private Bishop white_bishop_one, white_bishop_two, black_bishop_one, black_bishop_two;
    private Queen white_queen, black_queen;
    private King white_king, black_king;
    private int[][][] matrix_cords;
    private String[][] chessboard;

    public Board() {startSetup(); }
    private void startSetup(){
        /// Setup des Frames
        setupFrame();

        chessboard = new String[8][8];

        /// Setup von der Brett-Matrix für Koordinaten
        matrix_cords = new int[8][8][2];
        for (int col=0; col<8; col++){
            for (int row=0; row < 8; row++){
                for(int tup=0 ;tup < 2;  tup++){
                    if(tup % 2 == 0){
                        matrix_cords[col][row][tup] = 410 + row * 100;
                        continue;
                    }
                    matrix_cords[col][row][tup] = 10 + col * 100;
                }
            }
        }

        String fen_position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        addFEN(fen_position);
        setupPieces();
        printBoard();

        frame.add(cboard);
        frame.setVisible(true);
    }
    private void addFEN(String pgn) {
        // Ersetze alle '/' durch leere Zeichen, um die Zeilen zu trennen
        pgn = pgn.replaceAll("/", "");

        int row = 0;
        int col = 0;

        for (int i = 0; i < pgn.length(); i++) {
            char c = pgn.charAt(i);

            if (Character.isLetter(c)) {
                chessboard[row][col] = String.valueOf(c);
                col++;
            }
            else if (Character.isDigit(c)) {
                int emptySpaces = Character.getNumericValue(c);
                for (int j = 0; j < emptySpaces; j++) {
                    chessboard[row][col] = "*";
                    col++;
                }
            }

            if (col >= 8) {
                row++;
                col = 0;
            }
        }
    }
    private void printBoard(){
        cleanBoard();

        int black_pawn_num = 1;
        int white_pawn_num = 1;
        // Überprüfe jedes Zeichen im chessBoard
        for (int col = 0; col < chessboard.length; col++) {
            for (int row = 0; row < chessboard[col].length; row++) {
                switch (chessboard[col][row]) {
                    case "r":
                        // Verarbeite den Fall, wenn das Zeichen "r" ist (Schwarz: Turm)
                        if(!black_rook_one.set) {
                            black_rook_one.changeCords(col, row);
                            black_rook_one.set = true;
                            black_rook_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        } else {
                            black_rook_two.changeCords(col, row);
                            black_rook_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                            black_rook_one.set = false;
                        }

                        break;
                    case "n":
                        // Verarbeite den Fall, wenn das Zeichen "n" ist (Schwarz: Springer)
                        if(!black_knight_one.set) {
                            black_knight_one.changeCords(col, row);
                            black_knight_one.set = true;
                            black_knight_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        } else {
                            black_knight_two.changeCords(col, row);
                            black_knight_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                            black_knight_one.set = false;
                        }
                        break;
                    case "b":
                        // Verarbeite den Fall, wenn das Zeichen "b" ist (Schwarz: Läufer)
                        if(!black_bishop_one.set) {
                            black_bishop_one.changeCords(col, row);
                            black_bishop_one.set = true;
                            black_bishop_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        } else {
                            black_bishop_two.changeCords(col, row);
                            black_bishop_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                            black_bishop_one.set = false;
                        }
                        break;
                    case "q":
                        // Verarbeite den Fall, wenn das Zeichen "q" ist (Schwarz: Königin)
                        black_queen.changeCords(col, row);
                        black_queen_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        break;
                    case "k":
                        // Verarbeite den Fall, wenn das Zeichen "k" ist (Schwarz: König)
                        black_king.changeCords(col, row);
                        black_king_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        break;
                    case "p":
                        // Verarbeite den Fall, wenn das Zeichen "p" ist (Schwarz: Bauer)
                        if(black_pawn_num <= 8){
                            switch (black_pawn_num) {
                                case 1 -> {
                                    black_pawn_one.changeCords(col, row);
                                    black_pawn_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                                case 2 -> {
                                    black_pawn_two.changeCords(col, row);
                                    black_pawn_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                                case 3 -> {
                                    black_pawn_three.changeCords(col, row);
                                    black_pawn_three_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                                case 4 -> {
                                    black_pawn_four.changeCords(col, row);
                                    black_pawn_four_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                                case 5 -> {
                                    black_pawn_five.changeCords(col, row);
                                    black_pawn_five_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                                case 6 -> {
                                    black_pawn_six.changeCords(col, row);
                                    black_pawn_six_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                                case 7 -> {
                                    black_pawn_seven.changeCords(col, row);
                                    black_pawn_seven_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                                case 8 -> {
                                    black_pawn_eight.changeCords(col, row);
                                    black_pawn_eight_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                }
                            }
                        }
                        break;
                    case "R":
                        if(!white_rook_one.set) {
                            white_rook_one.changeCords(col, row);
                            white_rook_one.set = true;
                            white_rook_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        } else {
                            white_rook_two.changeCords(col, row);
                            white_rook_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                            black_bishop_one.set = false;
                        }
                        break;
                    case "N":
                        // Verarbeite den Fall, wenn das Zeichen "N" ist (Weiß: Springer)
                        if(!white_knight_one.set) {
                            white_knight_one.changeCords(col, row);
                            white_knight_one.set = true;
                            white_knight_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        } else {
                            white_knight_two.changeCords(col, row);
                            white_knight_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                            white_knight_one.set = false;
                        }
                        break;
                    case "B":
                        // Verarbeite den Fall, wenn das Zeichen "B" ist (Weiß: Läufer)
                        if(!white_bishop_one.set) {
                            white_bishop_one.changeCords(col, row);
                            white_bishop_one.set = true;
                            white_bishop_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        } else {
                            white_bishop_two.changeCords(col, row);
                            white_bishop_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                            white_bishop_one.set = false;
                        }
                        break;
                    case "Q":
                        // Verarbeite den Fall, wenn das Zeichen "Q" ist (Weiß: Königin)
                        white_queen.changeCords(col, row);
                        white_queen_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        break;
                    case "K":
                        white_king.changeCords(col, row);
                        white_king_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                        break;
                    case "P":
                        // Verarbeite den Fall, wenn das Zeichen "P" ist (Weiß: Bauer)
                        if(white_pawn_num <= 8){
                            switch (white_pawn_num) {
                                case 1 -> {
                                    white_pawn_one.changeCords(col, row);
                                    white_pawn_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                                case 2 -> {
                                    white_pawn_two.changeCords(col, row);
                                    white_pawn_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                                case 3 -> {
                                    white_pawn_three.changeCords(col, row);
                                    white_pawn_three_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                                case 4 -> {
                                    white_pawn_four.changeCords(col, row);
                                    white_pawn_four_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                                case 5 -> {
                                    white_pawn_five.changeCords(col, row);
                                    white_pawn_five_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                                case 6 -> {
                                    white_pawn_six.changeCords(col, row);
                                    white_pawn_six_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                                case 7 -> {
                                    white_pawn_seven.changeCords(col, row);
                                    white_pawn_seven_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                                case 8 -> {
                                    white_pawn_eight.changeCords(col, row);
                                    white_pawn_eight_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                }
                            }
                        }
                        break;
                    case "*":
                        break;
                    default:
                        System.out.println("Default ist eingetreten");
                        break;
                }
            }
        }

    }
    private void inputEval(String text_input){
        if (!isValidFEN(text_input)){
            print("Invalider FEN");
        } else {
            print("Valider FEN");
            addFEN(text_input);
            printBoard();
        }
    }
    private boolean isValidFEN(String fen) {
        if (!fen.matches("^[rnbkqpRNBKQP12345678]+$")){
            return  false;
        }
        if (fen.split("/").length != 8){
            return false;
        }

        fen = fen.replaceAll("/", "");
        fen = fen.replaceAll("1", "");
        fen = fen.replaceAll("2", "");
        fen = fen.replaceAll("3", "");
        fen = fen.replaceAll("4", "");
        fen = fen.replaceAll("5", "");
        fen = fen.replaceAll("6", "");
        fen = fen.replaceAll("7", "");
        fen = fen.replaceAll("8", "");
        if(fen.length() > 32){
            return false;
        }

        return letterCount(fen, 'r') <= 2 && letterCount(fen, 'R') <= 2
                && letterCount(fen, 'N') <= 2 && letterCount(fen, 'N') <= 2 && letterCount(fen, 'b') <= 2 && letterCount(fen, 'B') <= 2
                && letterCount(fen, 'k') <= 1 && letterCount(fen, 'K') <= 1 && letterCount(fen, 'q') <= 1 && letterCount(fen, 'Q') <= 1;
    }
    private  int letterCount(String inputString, char c) {
        int count = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }
    private void setupFrame(){
        frame = new JFrame("Schach - Roman, Nick");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 840);
        frame.setLocation(100, 100);
        ImageIcon image = new ImageIcon("images/frame_icon.png");
        frame.setIconImage(image.getImage());
        frame.setResizable(false);
        frame.setLayout(null);

        // Setup des Brettes als Label
        cboard = new JLabel();
        cboard.setIcon(new ImageIcon("images/chessboard.png"));
        cboard.setBounds(400,0,800,800);

        printline = new JTextArea();
        printline.setPreferredSize(new Dimension(200, 50));
        printline.setBounds(1310, 410, 200, 50);
        printline.setEditable(false);
        frame.add(printline);

        input = new JTextField();
        input.setPreferredSize(new Dimension(200, 50));
        input.setBounds(1310, 510, 200, 50);
        frame.add(input);

        submit = new JButton("Eingabe");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputEval(input.getText());
            }
        });
        submit.setPreferredSize(new Dimension(200, 50));
        submit.setBounds(1310, 610, 200, 50);
        frame.add(submit);
    }
    private void setupPieces(){
        // Black Pieces
        black_rook_one = new Rook(0,0, "ST80x80", matrix_cords);
        black_rook_two = new Rook(0,0, "ST80x80", matrix_cords);
        black_rook_one_label = new JLabel(black_rook_one.image);
        black_rook_two_label = new JLabel(black_rook_two.image);
        frame.add(black_rook_one_label);
        frame.add(black_rook_two_label);

        black_knight_one = new Knight(0,0, "SS80x80", matrix_cords);
        black_knight_two = new Knight(0,0, "SS80x80", matrix_cords);
        black_knight_one_label = new JLabel(black_knight_one.image);
        black_knight_two_label = new JLabel(black_knight_two.image);
        frame.add(black_knight_one_label);
        frame.add(black_knight_two_label);

        black_bishop_one = new Bishop(0,0, "SL80x80", matrix_cords);
        black_bishop_two = new Bishop(0,0, "SL80x80", matrix_cords);
        black_bishop_one_label = new JLabel(black_bishop_one.image);
        black_bishop_two_label = new JLabel(black_bishop_two.image);
        frame.add(black_bishop_one_label);
        frame.add(black_bishop_two_label);

        black_queen = new Queen(0,0, "SD80x80", matrix_cords);
        black_queen_label = new JLabel(black_queen.image);
        frame.add(black_queen_label);

        black_king = new King(0,0, "SK80x80", matrix_cords);
        black_king_label = new JLabel(black_king.image);
        frame.add(black_king_label);

        black_pawn_one = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_two = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_three = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_four = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_five = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_six = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_seven = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_eight = new Pawn(0,0, "SB80x80", matrix_cords);
        black_pawn_one_label = new JLabel(black_pawn_one.image);
        black_pawn_two_label = new JLabel(black_pawn_two.image);
        black_pawn_three_label = new JLabel(black_pawn_three.image);
        black_pawn_four_label = new JLabel(black_pawn_four.image);
        black_pawn_five_label = new JLabel(black_pawn_five.image);
        black_pawn_six_label = new JLabel(black_pawn_six.image);
        black_pawn_seven_label = new JLabel(black_pawn_seven.image);
        black_pawn_eight_label = new JLabel(black_pawn_eight.image);
        frame.add(black_pawn_one_label);
        frame.add(black_pawn_two_label);
        frame.add(black_pawn_three_label);
        frame.add(black_pawn_four_label);
        frame.add(black_pawn_five_label);
        frame.add(black_pawn_six_label);
        frame.add(black_pawn_seven_label);
        frame.add(black_pawn_eight_label);


        // White Pieces
        white_rook_one = new Rook(0,0, "WT80x80", matrix_cords);
        white_rook_two = new Rook(0,0, "WT80x80", matrix_cords);
        white_rook_one_label = new JLabel(white_rook_one.image);
        white_rook_two_label = new JLabel(white_rook_two.image);
        frame.add(white_rook_two_label);
        frame.add(white_rook_one_label);

        white_knight_one = new Knight(0,0, "WS80x80", matrix_cords);
        white_knight_two = new Knight(0,0, "WS80x80", matrix_cords);
        white_knight_one_label = new JLabel(white_knight_one.image);
        white_knight_two_label = new JLabel(white_knight_two.image);
        frame.add(white_knight_two_label);
        frame.add(white_knight_one_label);

        white_bishop_one = new Bishop(0,0, "WL80x80", matrix_cords);
        white_bishop_two = new Bishop(0,0, "WL80x80", matrix_cords);
        white_bishop_one_label = new JLabel(white_bishop_one.image);
        white_bishop_two_label = new JLabel(white_bishop_two.image);
        frame.add(white_bishop_one_label);
        frame.add(white_bishop_two_label);

        white_queen = new Queen(0,0, "WD80x80", matrix_cords);
        white_queen_label = new JLabel(white_queen.image);
        frame.add(white_queen_label);

        white_king = new King(0,0, "WK80x80", matrix_cords);
        white_king_label = new JLabel(white_king.image);
        frame.add(white_king_label);

        white_pawn_one = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_two = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_three = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_four = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_five = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_six = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_seven = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_eight = new Pawn(0,0, "WB80x80", matrix_cords);
        white_pawn_one_label = new JLabel(white_pawn_one.image);
        white_pawn_two_label = new JLabel(white_pawn_two.image);
        white_pawn_three_label = new JLabel(white_pawn_three.image);
        white_pawn_four_label = new JLabel(white_pawn_four.image);
        white_pawn_five_label = new JLabel(white_pawn_five.image);
        white_pawn_six_label = new JLabel(white_pawn_six.image);
        white_pawn_seven_label = new JLabel(white_pawn_seven.image);
        white_pawn_eight_label = new JLabel(white_pawn_eight.image);
        frame.add(white_pawn_one_label);
        frame.add(white_pawn_two_label);
        frame.add(white_pawn_three_label);
        frame.add(white_pawn_four_label);
        frame.add(white_pawn_five_label);
        frame.add(white_pawn_six_label);
        frame.add(white_pawn_seven_label);
        frame.add(white_pawn_eight_label);
    }
    private void cleanBoard(){
        print("");
        setupPieces();
    }
    private void print(String msg){
        printline.setText("Console: ");
        printline.append(msg);
    }

    public static void main(String[] args) {
        new Board();
    }
}