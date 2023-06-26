import javax.swing.JLabel;

public class Feld {
    public boolean sqaureColor;
    public Figur belegtVon;

    public JLabel lable;

    public Feld(boolean clr, String cords){
        sqaureColor = clr;
        lable = new JLabel(cords);
    }

    public JLabel getFeld(){
        return lable;
    }
}
