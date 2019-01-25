import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.*;

public class Screen extends JPanel implements ActionListener {
    private ArrayList<Card> deck, player;
    private int score = 20, total, adjust;
    private JButton newGame, hit, stay;
    private int width, height;
    private String text;
    private boolean over = false;


    public Screen() {
        this.setLayout(null);
        deck=new ArrayList<Card>();
        for(int i = 0; i < 52; i++) {
            deck.add(new Card(i));
        }
        reset();
        Collections.shuffle(deck);
        text = "";
        width = (int)getPreferredSize().getWidth();
        height = (int)getPreferredSize().getHeight();
        newGame = new JButton("Start Game");
        newGame.setBounds(width/2-40, 10, 80, 30);
        newGame.addActionListener(this);
        this.add(newGame);
        hit = new JButton("Hit");
        hit.setBounds(width/2-150, 10, 80, 30);
        hit.addActionListener(this);
        this.add(hit);
        stay = new JButton("Stay");
        stay.setBounds(width/2+50, 10, 80, 30);
        stay.addActionListener(this);
        this.add(stay);
        visibility(true);
        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D)graphics;
        if(over) {
            g.setColor(Color.BLACK);
            g.drawString("GAME OVER, SCORE="+score, width/2-180, 100);
            return;
        }
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        for(int i = 0; i < player.size(); i++) {
            player.get(i).drawMe(g, (i*60)%(width-150)+150, 200+(i/ ((width-150)/60))*200);
        }
        g.setColor(Color.BLACK);
        g.drawString("Score: "+score, 30, 100);
        g.drawString("Total: "+(total-adjust), width-400, 100);
        g.setColor(Color.GREEN);
        g.drawString(text, width/2-120, 100);
    }
    public void deal() {
        if(deck.size()<=0) {
            over = true;
        }
        Card c = deck.remove(0);
        player.add(c);
        int[] values = new int[] {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        total+=values[c.getValue()%13];
        adjust = 0;
        for(Card d : player) {
            if(total-adjust<=21) {
                break;
            }
            if(d.getValue()%13==0) {
                adjust+=10;
            }
        }
    }
    public void visibility(boolean input) {
        if(hit==null || newGame==null || stay==null) {
            return;
        }
        hit.setVisible(!input);
        newGame.setVisible(input);
        stay.setVisible(!input);
    }
    public void reset() {
        player = new ArrayList<Card>();
        total = 0;
        adjust = 0;
        visibility(true);
    }
    public void check() {
        int[] values = new int[] {1, 1, 1, 2, 3, 5};
        if((total-adjust) <=21 && (total-adjust) >= 16) {
            score+=values[(total-adjust)-16];
            text = "YOU WIN +"+values[(total-adjust)-16];
        } else {
            text = "YOU LOSE";
        }
        reset();
    }
    public void actionPerformed(ActionEvent e) {
        if((total-adjust)==0 && e.getSource() == newGame) {
            score--;
            player = new ArrayList<Card>();
            deal();
            deal();
            text = "";
            visibility(false);
        } else if(e.getSource() == hit) {
            deal();
        } else if(e.getSource() == stay) {
            check();
        }
        if((total-adjust) >= 21) {
            check();
        }
        repaint();
    }
}
