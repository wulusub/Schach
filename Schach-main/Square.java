import javax.swing.*;

public class Square{
    /// Deklaration der Variablen
    public boolean color;
    public int x;
    public int y;
    public Piece piece_on;
    public JLabel square;

    public Square(int cordx, int cordy, boolean set_color){
        /// Variablen
        x = cordx; 
        y = cordy;
        color = setColor;

        /// Label
        square = new JLabel();
        square.setBounds(x,y,50,50);
        Board.f_board.add(square);
    }

    public Square(int cordx, int cordy, boolean set_color, Piece set_piece){
        /// Variablen
        x = cordx; 
        y = cordy;
        color = setColor;
        piece_on = set_piece;
    
        /// Labels
        square = new JLabel(set_piece.piece_icon);
        square.setBounds(x,y,50,50);
        Board.f_board.add(square);
        
        // src: https://stackoverflow.com/questions/5260462/can-i-add-an-action-listener-to-a-jlabel
        square.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                labelEvent();
            }
        });
    }

    public void labelEvent(){}

}