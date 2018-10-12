import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class FormulasGraphics extends JPanel implements ActionListener {
    private JButton quadraticButton;
    private JTextField quadraticAInput;
    private JTextField quadraticBInput;
    private JTextField quadraticCInput;
    private String quadraticX = "";

    private JButton pythagoreanButton;
    private JTextField radiusInput;
    private JTextField aInput;
    private JTextField bInput;
    private double pythagorean = 0;

    private JButton rectangleButton;
    private JTextField wInput;
    private JTextField hInput;
    private double rectangleArea = 0;

    private JButton triangleButton;
    private JTextField s1Input;
    private JTextField s2Input;
    private JTextField angleInput;
    private double triangleArea = 0;

    public FormulasGraphics() {
        setLayout(null); // we are not using a layout

        quadraticButton = new JButton("Quadratic");
        quadraticButton.setBounds(50, 450, 100, 30); // Set the location and size
        add(quadraticButton);
        quadraticButton.addActionListener(this);

        quadraticAInput = new JTextField();
        quadraticAInput.setBounds(50, 50, 100, 30); // Set the location and size
        add(quadraticAInput);

        quadraticBInput = new JTextField();
        quadraticBInput.setBounds(50, 150, 100, 30); // Set the location and size
        add(quadraticBInput);

        quadraticCInput = new JTextField();
        quadraticCInput.setBounds(50, 250, 100, 30); // Set the location and size
        add(quadraticCInput);

        pythagoreanButton = new JButton("Pythagorean");
        pythagoreanButton.setBounds(200, 450, 100, 30); // Set the location and size
        add(pythagoreanButton);
        pythagoreanButton.addActionListener(this);

        aInput = new JTextField();
        aInput.setBounds(200, 50, 100, 30); // Set the location and size

        bInput = new JTextField();
        bInput.setBounds(200, 150, 100, 30); // Set the location and size

        add(aInput);
        add(bInput);


        rectangleButton = new JButton("Rectangle");
        rectangleButton.setBounds(350, 450, 100, 30); // Set the location and size
        add(rectangleButton);
        rectangleButton.addActionListener(this);

        wInput = new JTextField();
        wInput.setBounds(350, 50, 100, 30); // Set the location and size

        hInput = new JTextField();
        hInput.setBounds(350, 150, 100, 30); // Set the location and size

        add(wInput);
        add(hInput);


        triangleButton = new JButton("Triangle");
        triangleButton.setBounds(500, 450, 100, 30); // Set the location and size
        add(triangleButton);
        triangleButton.addActionListener(this);

        s1Input = new JTextField();
        s1Input.setBounds(500, 50, 100, 30); // Set the location and size

        s2Input = new JTextField();
        s2Input.setBounds(500, 150, 100, 30); // Set the location and size

        angleInput = new JTextField();
        angleInput.setBounds(500, 250, 100, 30); // Set the location and size

        add(s1Input);
        add(s2Input);
        add(angleInput);


        setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.WHITE);
        int[] prev = new int[] {0, 0};
        int[] current = new int[] {0, 0};
        for (int i = 0; i < 2000; i++) {
            prev=current.clone();
            current[0]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5);
            current[1]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5);
            g.drawLine(prev[0], prev[1], current[0], current[1]);
            current[0]+=800;
            current[1]+=600;
            current[0]%=800;
            current[1]%=600;
        }
        g.setColor(Color.RED);
        g.drawString("Quadratic", 50, 0);
        g.drawString("A: ", 50, 100);
        g.drawString("B: ", 50, 200);
        g.drawString("C: ", 50, 300);
        g.drawString("Xs are: " + quadraticX, 50, 400);

        g.drawString("Pythagorean", 200, 0);
        g.drawString("A: ", 200, 100);
        g.drawString("B: ", 200, 200);
        g.drawString("C is: " + Math.round(Math.sqrt(pythagorean)*1000.0)/1000.0, 200, 400);

        g.drawString("Rectangle Area", 350, 0);
        g.drawString("W: ", 350, 100);
        g.drawString("H: ", 350, 200);
        g.drawString("Area is: " + rectangleArea, 350, 400);

        g.drawString("Triangle Area", 500, 0);
        g.drawString("Side 1: ", 500, 100);
        g.drawString("Side 2: ", 500, 200);
        g.drawString("Angle (rad): ", 500, 300);
        g.drawString("Area is: " + Math.round(triangleArea*1000.0)/1000.0, 500, 400);
 
    }

    // actionPerformed gets called when an action happens
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quadraticButton) {
            // get the information from the textfield.
            String quadraticAText = quadraticAInput.getText();
            double a = Double.parseDouble(quadraticAText); // converts a string to a double
            String quadraticBText = quadraticBInput.getText();
            double b = Double.parseDouble(quadraticBText); // converts a string to a double
            String quadraticCText = quadraticCInput.getText();
            double c = Double.parseDouble(quadraticCText); // converts a string to a double
            // calculate the area of the circle
            quadraticX = String.valueOf((-b+Math.sqrt(Math.pow(b, 2.0)-4.0*a*c))/2.0/a);
            quadraticX+=" and ";
            quadraticX += String.valueOf((-b-Math.sqrt(Math.pow(b, 2.0)-4.0*a*c))/2.0/a);
        }
        if (e.getSource() == pythagoreanButton) {
            // get the information from the textfield.
            String aText = aInput.getText();
            double a = Double.parseDouble(aText); // converts a string to a double
 
            String bText = bInput.getText();
            double b = Double.parseDouble(bText); // converts a string to a double
 
            // calculate the area of the circle
            pythagorean = Math.pow(a, 2) + Math.pow(b, 2);
        } 
        if (e.getSource() == rectangleButton) {
            // get the information from the textfield.
            String wText = wInput.getText();
            double w = Double.parseDouble(wText); // converts a string to a double
 
            String hText = hInput.getText();
            double h = Double.parseDouble(hText); // converts a string to a double
 
            // calculate the area of the circle
            rectangleArea=w*h;
        } 
        if (e.getSource() == triangleButton) {
            // get the information from the textfield.
            String s2Text = s2Input.getText();
            double s2 = Double.parseDouble(s2Text); // converts a string to a double
 
            String s1Text = s1Input.getText();
            double s1 = Double.parseDouble(s1Text); // converts a string to a double

            String angleText = angleInput.getText();
            double angle = Double.parseDouble(angleText); // converts a string to a double

            // calculate the area of the circle
            triangleArea=s1*s2*0.5*Math.sin(angle);
        } 
        
        // display it graphically
        repaint(); // redraws the screen
    }
}