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
    public Screen() {
        this.setLayout(null);
        sm = new SlotMachine();
        
        spinButton = new JButton("Spin");
        spinButton.setBounds(150, 450, 100, 50);
        spinButton.addActionListener(this);
        this.add(spinButton);

        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sm.drawMe(g);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == spinButton) {
            sm.play();
        }
        repaint();
    }
}