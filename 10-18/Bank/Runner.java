import javax.swing.JFrame; 
public class Runner { 
    public static void main(String[] args) {
        JFrame fr = new JFrame("Bank");
        Screen sc = new Screen();
        fr.add(sc); //adds the jPanel into the jFrame, adds the canvas into the window frame
        fr.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}    