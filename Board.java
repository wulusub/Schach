import javax.swing.*;

public class Board {
    /// Deklaration der Variablen
    public Square[][] board;
    public JFrame f_board;

    public Board(){
        /// Brett erstellen
        f_board = new Frame();
        f_board.setSize(1485 , 810);
        f_board.setLocation(100,100);

        for (int col=0; col<8; col++){
            for (int row=0; row<8; row++){
                boolean squareColor = (col + row)%2 != 0;
                board[col][row] = new Square(/,/, squareColor);    
            }
        }
    
        f_board.setVisible(true);
    }
}