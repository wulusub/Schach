/*

@author Roman

@version 1507

 */

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Board {
    public JFrame frame;
    public JLabel cboard;
    public JButton submit;
    public JTextField input;
    public JTextArea printline;
    public JLabel white_pawn_one_label, white_pawn_two_label, white_pawn_three_label, white_pawn_four_label,
            white_pawn_five_label, white_pawn_six_label, white_pawn_seven_label, white_pawn_eight_label,
            black_pawn_one_label, black_pawn_two_label, black_pawn_three_label, black_pawn_four_label,
            black_pawn_five_label, black_pawn_six_label, black_pawn_seven_label, black_pawn_eight_label,
            white_rook_one_label, white_rook_two_label, black_rook_one_label, black_rook_two_label,
            white_knight_one_label, white_knight_two_label, black_knight_one_label, black_knight_two_label,
            white_bishop_one_label, white_bishop_two_label, black_bishop_one_label, black_bishop_two_label,
            white_queen_label, black_queen_label, white_king_label, black_king_label;

    public Pawn white_pawn_one, white_pawn_two, white_pawn_three, white_pawn_four,
            white_pawn_five, white_pawn_six, white_pawn_seven, white_pawn_eight,
            black_pawn_one, black_pawn_two, black_pawn_three, black_pawn_four,
            black_pawn_five, black_pawn_six, black_pawn_seven, black_pawn_eight;
    public Rook white_rook_one, white_rook_two, black_rook_one, black_rook_two;
    public Knight white_knight_one, white_knight_two, black_knight_one, black_knight_two;
    public Bishop white_bishop_one, white_bishop_two, black_bishop_one, black_bishop_two;
    public Queen white_queen, black_queen;
    public King white_king, black_king;
    public int[][][] matrix_cords;
    public String[][] chessboard;
    public String pgn_position;
    public String input_move;

    public Board() {startSetup(); }
    public void startSetup(){
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

        pgn_position = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        addPGN(pgn_position);
        setupPieces();
        printBoard();

        frame.add(cboard);
        frame.setVisible(true);
    }

    public void addPGN(String pgn) {
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
    public void printBoard(){
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
                            switch (black_pawn_num){
                                case 1:
                                    black_pawn_one.changeCords(col, row);
                                    black_pawn_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
                                case 2:
                                    black_pawn_two.changeCords(col, row);
                                    black_pawn_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
                                case 3:
                                    black_pawn_three.changeCords(col, row);
                                    black_pawn_three_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
                                case 4:
                                    black_pawn_four.changeCords(col, row);
                                    black_pawn_four_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
                                case 5:
                                    black_pawn_five.changeCords(col, row);
                                    black_pawn_five_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
                                case 6:
                                    black_pawn_six.changeCords(col, row);
                                    black_pawn_six_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
                                case 7:
                                    black_pawn_seven.changeCords(col, row);
                                    black_pawn_seven_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
                                case 8:
                                    black_pawn_eight.changeCords(col, row);
                                    black_pawn_eight_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    black_pawn_num++;
                                    break;
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
                            switch (white_pawn_num){
                                case 1:
                                    white_pawn_one.changeCords(col, row);
                                    white_pawn_one_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
                                case 2:
                                    white_pawn_two.changeCords(col, row);
                                    white_pawn_two_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
                                case 3:
                                    white_pawn_three.changeCords(col, row);
                                    white_pawn_three_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
                                case 4:
                                    white_pawn_four.changeCords(col, row);
                                    white_pawn_four_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
                                case 5:
                                    white_pawn_five.changeCords(col, row);
                                    white_pawn_five_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
                                case 6:
                                    white_pawn_six.changeCords(col, row);
                                    white_pawn_six_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
                                case 7:
                                    white_pawn_seven.changeCords(col, row);
                                    white_pawn_seven_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
                                case 8:
                                    white_pawn_eight.changeCords(col, row);
                                    white_pawn_eight_label.setBounds(matrix_cords[col][row][0], matrix_cords[col][row][1], 80, 80);
                                    white_pawn_num++;
                                    break;
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
    public void inputEval(String text_input){
        text_input = text_input.toLowerCase();
        if(text_input.matches("[a-h][1-8]")){
            //..
        } else if (text_input.matches("(weißer|schwarzer)\\s+(bauer|könig|dame|turm|springer|läufer)\\s+(nach\\s+(vorne|hinten)|links|rechts|\\w\\d)")){
            String[] split = text_input.split("\\s+");
            String color = split[0];
            String piece = split[1];
            String move =  split[2];

            if (getPieceName(piece, color).equals("white_king")) {
                
            }

        } else if (text_input.matches("(weißer|schwarzer)\\s+(bauer|könig|dame|turm|springer|läufer)\\s+[a-h][1-8]")){

        } else {

        }
    }

    public int[] getPositionIndices(String position) {
        if (position.length() != 2) {
            throw new IllegalArgumentException("Invalid position format. Expected format: [a-h][1-8]");
        }

        char fileChar = position.charAt(0);
        char rankChar = position.charAt(1);

        if (fileChar < 'a' || fileChar > 'h' || rankChar < '1' || rankChar > '8') {
            throw new IllegalArgumentException("Invalid position. Valid positions are from a1 to h8.");
        }

        int file = fileChar - 'a';
        int rank = rankChar - '1';

        return new int[]{rank, file};
    }
    private String getPieceName(String piece, String color) {
        String figurenFarbe = color.equals("weißer") ? "white" : "black";
        switch (piece) {
            case "bauer":
                return figurenFarbe + "_pawn";
            case "könig":
                return figurenFarbe + "_king";
            case "dame":
                return figurenFarbe + "_queen";
            case "turm":
                return figurenFarbe + "_rook";
            case "springer":
                return figurenFarbe + "_knight";
            case "läufer":
                return figurenFarbe + "_bishop";
            default:
                return "";
        }
    }
    public void setupFrame(){
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
        printline.setBounds(910, 410, 200, 50);
        frame.add(printline);

        input = new JTextField();
        input.setPreferredSize(new Dimension(200, 50));
        input.setBounds(910, 510, 200, 50);
        frame.add(input);

        submit = new JButton("Eingabe");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputEval(input.getText());
            }
        });
        submit.setPreferredSize(new Dimension(200, 50));
        submit.setBounds(910, 610, 200, 50);
        frame.add(submit);
    }
    public void setupPieces(){
        // Black Pieces
        black_rook_one = new Rook(0,0, "ST80x80");
        black_rook_two = new Rook(0,0, "ST80x80");
        black_rook_one_label = new JLabel(black_rook_one.image);
        black_rook_two_label = new JLabel(black_rook_two.image);
        frame.add(black_rook_one_label);
        frame.add(black_rook_two_label);

        black_knight_one = new Knight(0,0, "SS80x80");
        black_knight_two = new Knight(0,0, "SS80x80");
        black_knight_one_label = new JLabel(black_knight_one.image);
        black_knight_two_label = new JLabel(black_knight_two.image);
        frame.add(black_knight_one_label);
        frame.add(black_knight_two_label);

        black_bishop_one = new Bishop(0,0, "SL80x80");
        black_bishop_two = new Bishop(0,0, "SL80x80");
        black_bishop_one_label = new JLabel(black_bishop_one.image);
        black_bishop_two_label = new JLabel(black_bishop_two.image);
        frame.add(black_bishop_one_label);
        frame.add(black_bishop_two_label);

        black_queen = new Queen(0,0, "SD80x80");
        black_queen_label = new JLabel(black_queen.image);
        frame.add(black_queen_label);

        black_king = new King(0,0, "SK80x80");
        black_king_label = new JLabel(black_king.image);
        frame.add(black_king_label);

        black_pawn_one = new Pawn(0,0, "SB80x80");
        black_pawn_two = new Pawn(0,0, "SB80x80");
        black_pawn_three = new Pawn(0,0, "SB80x80");
        black_pawn_four = new Pawn(0,0, "SB80x80");
        black_pawn_five = new Pawn(0,0, "SB80x80");
        black_pawn_six = new Pawn(0,0, "SB80x80");
        black_pawn_seven = new Pawn(0,0, "SB80x80");
        black_pawn_eight = new Pawn(0,0, "SB80x80");
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
        white_rook_one = new Rook(0,0, "WT80x80");
        white_rook_two = new Rook(0,0, "WT80x80");
        white_rook_one_label = new JLabel(white_rook_one.image);
        white_rook_two_label = new JLabel(white_rook_two.image);
        frame.add(white_rook_two_label);
        frame.add(white_rook_one_label);

        white_knight_one = new Knight(0,0, "WS80x80");
        white_knight_two = new Knight(0,0, "WS80x80");
        white_knight_one_label = new JLabel(white_knight_one.image);
        white_knight_two_label = new JLabel(white_knight_two.image);
        frame.add(white_knight_two_label);
        frame.add(white_knight_one_label);

        white_bishop_one = new Bishop(0,0, "WL80x80");
        white_bishop_two = new Bishop(0,0, "WL80x80");
        white_bishop_one_label = new JLabel(white_bishop_one.image);
        white_bishop_two_label = new JLabel(white_bishop_two.image);
        frame.add(white_bishop_one_label);
        frame.add(white_bishop_two_label);

        white_queen = new Queen(0,0, "WD80x80");
        white_queen_label = new JLabel(white_queen.image);
        frame.add(white_queen_label);

        white_king = new King(0,0, "WK80x80");
        white_king_label = new JLabel(white_king.image);
        frame.add(white_king_label);

        white_pawn_one = new Pawn(0,0, "WB80x80");
        white_pawn_two = new Pawn(0,0, "WB80x80");
        white_pawn_three = new Pawn(0,0, "WB80x80");
        white_pawn_four = new Pawn(0,0, "WB80x80");
        white_pawn_five = new Pawn(0,0, "WB80x80");
        white_pawn_six = new Pawn(0,0, "WB80x80");
        white_pawn_seven = new Pawn(0,0, "WB80x80");
        white_pawn_eight = new Pawn(0,0, "WB80x80");
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
    public void cleanBoard(){
        setupPieces();
    }

    public static void main(String[] args) {
        new Board();
    }
}