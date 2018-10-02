import javax.swing.JFrame;
public class GraphicsRunner {
 
    public static void main( String args[] ) {
        //(1) What does the constructor of JFrame takes in? What does it do?
        //It takes in a name for the JFrame
        JFrame frame = new JFrame("Circle5");
 
        //Create JPanel object and add it to the frame

        Circles canvas = new Circles();
        frame.add(canvas);
 
        //(2) What do you think this command does?
        //It Exits the JFrame when you try to close it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //(3) What happens when you remove the code below?
        //It doesn't work
        //Try and Test.
        frame.pack();
 
        //(4) What does setVisible do? What happens when you remove the code below?
        //It shows nothing because it is not visible yet. 
        //Try and Test.
        frame.setVisible(true);
 
    }
 
}