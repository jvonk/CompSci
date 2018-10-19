import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;


public class Screen extends JPanel implements ActionListener {
    private List<Bank> users = new ArrayList<>();
    private int current;
    private JTextField pinInput;
    private JButton checkPinButton;
    private JTextField amountInput;
    private JButton withdrawButton;
    private JButton depositButton;
    private JTextField nameInput;
    private JButton nameButton;
    private JButton signOutButton;
    
    public Screen() {
        setLayout(null);
        users.add(new Bank("John", 100.99, 1234));
        users.add(new Bank("Jen", 1000.01, 4321));
        users.add(new Bank("Jerry", 50.50, 1111));
        current=0;
        pinInput = new JTextField();
        pinInput.setBounds(150, 300, 100, 30);
        add(pinInput);

        amountInput = new JTextField();
        amountInput.setBounds(350, 300, 100, 30);
        add(amountInput);

        nameInput = new JTextField();
        nameInput.setBounds(550, 300, 100, 30);
        add(nameInput);

        // create button

        checkPinButton = new JButton("Login");
        checkPinButton.setBounds(150, 350, 100, 30);
        checkPinButton.addActionListener(this);
        add(checkPinButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(350, 350, 100, 30);
        withdrawButton.addActionListener(this);
        add(withdrawButton);


        depositButton = new JButton("Deposit");
        depositButton.setBounds(350, 400, 100, 30);
        depositButton.addActionListener(this);
        add(depositButton);

        nameButton = new JButton("Rename");
        nameButton.setBounds(550, 350, 100, 30);
        nameButton.addActionListener(this);
        add(nameButton);

        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(150, 450, 500, 30);
        signOutButton.addActionListener(this);
        add(signOutButton);

        setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color dark = new Color(50, 50, 50);
        g.setColor(dark);
        g.fillRect(0, 0, 800, 600);
        Color light = new Color(200, 200, 200);
        g.setColor(light);
        g.fillRect(100, 50, 600, 450);
        Color bl = new Color(0, 0, 0);
        g.setColor(bl);
        g.fillRect(25, 200, 50, 50);
        g.fillRect(25, 300, 50, 50);
        g.fillRect(25, 400, 50, 50);
        g.fillRect(725, 200, 50, 50);
        g.fillRect(725, 300, 50, 50);
        g.fillRect(725, 400, 50, 50);
        g.fillRect(25, 525, 750, 50);
        g.drawString("Name: " + users.get(current).getName(), 150, 200);
        g.drawString("Balance: " + users.get(current).getBalance(), 150, 220);
        g.drawString("Amount: ", 290, 320);
        g.drawString("PIN: ", 120, 320);
        g.drawString("Name: ", 505, 320);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == checkPinButton) {
            // get the pin from the text field
            String pinText = pinInput.getText();
            int pin = Integer.parseInt(pinText); // convert a String to an integer
            // make the sure the pin is correct
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).checkPin(pin)) {
                    current=i;
                }
            }            
            // if it is correct display the name and balance of the user
        }
        if (e.getSource() == withdrawButton) {
            String amountText = amountInput.getText();
            int amount = Integer.parseInt(amountText); // convert a String to an integer
            users.get(current).withdraw(amount);
        }
        if (e.getSource() == depositButton) {
            String amountText = amountInput.getText();
            int amount = Integer.parseInt(amountText); // convert a String to an integer
            users.get(current).deposit(amount);
        }
        if (e.getSource() == signOutButton) {
            users.get(current).checkPin(-1);
        }
        if (e.getSource() == nameButton) {
            String nameText = nameInput.getText();
            users.get(current).updateName(nameText);
        }
        repaint(); // update the screen
    }
}