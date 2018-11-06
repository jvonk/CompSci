import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener {
    SlotMachine sm;
    JButton spinButton;
    JButton betOne;
    JButton betFive;
    JButton betTen;
    int counter = 0;
    public Screen() {
        this.setLayout(null);
        sm = new SlotMachine();
        
        spinButton = new JButton("Spin");
        spinButton.setBounds(150, 450, 100, 50);
        spinButton.addActionListener(this);
        this.add(spinButton);

        betOne = new JButton("Bet 1");
        betOne.setBounds(300, 450, 100, 50);
        betOne.addActionListener(this);
        this.add(betOne);

        betFive = new JButton("Bet 5");
        betFive.setBounds(450, 450, 100, 50);
        betFive.addActionListener(this);
        this.add(betFive);

        betTen = new JButton("Bet 10");
        betTen.setBounds(600, 450, 100, 50);
        betTen.addActionListener(this);
        this.add(betTen);

        this.setFocusable(true);
    }
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sm.drawMe(g, counter);
        for (int i = -1200; i <= 400; i+=10) {
            g.setColor(Color.RED);
            g.drawString("PLAY AND WIN", (i*10)%800+400, 200-i/2);
            g.setColor(Color.YELLOW);
            g.fillOval((int)(Math.sin((counter+i)/10.0)*100.0+300.0+i), (int)(Math.cos((counter+i)/10.0)*100.0+300.0-i), 20, 20);            
        }
    }

    public void animate() {
        while (true) {
            counter++;
            //System.out.println("*"+counter);
            counter%=50;
            // slow it down (wait)
            try {
                Thread.sleep(10); // millisecond
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            // redraw the screen
            repaint();
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == spinButton) {
            sm.play();
        }
        if (e.getSource() == betOne) {
            sm.setBet(1);
        } else if (e.getSource() == betFive) {
            sm.setBet(5);
        } else if (e.getSource() == betTen) {
            sm.setBet(10);
        }

        repaint();
    }
}