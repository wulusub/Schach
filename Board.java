/*

@author Roman

@version 0407

 */

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Board{
    public JFrame frame;
    public JLabel cboard;

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

        JLabel king_black = new JLabel(new ImageIcon("images/king_white3.png"));
        king_black.setBounds(410, 10, 80 ,80 );

        // Brett als Label displayen
        cboard = new JLabel();
        cboard.setIcon(new ImageIcon("images/chessboard2.png"));
        cboard.setBounds(400,0,800,800);

        frame.add(king_black);
        frame.add(cboard);

        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new Board();
    }
}