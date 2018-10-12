import javax.swing.JFrame;

public class Runner{
    public static void main(String[] args){
        JFrame fr = new JFrame("Formulas");
        FormulasGraphics fg = new FormulasGraphics();
        fr.add(fg);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack(); 
        fr.setVisible(true);
    }
}