import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class test extends JPanel{
    // globale Variablen
    public JPanel panel;

    public test(JPanel thisPanel) {
        panel = thisPanel;
    }

    public static void main(String[] args) {

        // Frame bauen
        JFrame f = new JFrame("Schach - Nick, Roman, Robert, Mathis, Sönke");
        f.setSize(1485 , 810);
        f.setLocation(100,100);
        
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("hehe"));    

        /*final JTextArea textArea = new JTextArea(10, 40);
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        final JButton button = new JButton("Click Me");
        f.getContentPane().add(BorderLayout.SOUTH, button);
        button.addActionListener(new ActionListener() {
    
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button was clicked\n");
    
            }
        });*/
    
        f.setVisible(true);
    
      }
}
