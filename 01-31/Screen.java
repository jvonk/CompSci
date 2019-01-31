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
import java.awt.*;
import java.awt.font.TextAttribute;
import java.math.*;
import java.text.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.JFormattedTextField.*;
import javax.swing.event.*;
import javax.swing.text.InternationalFormatter;
public class Screen extends JPanel implements ActionListener {
    private ArrayList<Card> deck, player, dealer;
    private int wins, playerTotal, dealerTotal, adjust, dealerAdjust;
    private JButton newGame, hit, stay;
    private JTextField bet;
    private int width, height, currentBet = 1;
    private String text, dealt, tot;
    private boolean over = false;

    public Screen() {
        this.setLayout(null);
        deck = new ArrayList<Card>();
        player = new ArrayList<Card>();
        dealer = new ArrayList<Card>();
        for(int i = 0; i < 52; i++) {
            deck.add(new Card(i));
        }
        reset();
        Collections.shuffle(deck);
        text = "";
        dealt = "0";
        tot = "";
        wins = 10;
        width = (int)getPreferredSize().getWidth();
        height = (int)getPreferredSize().getHeight();
        newGame = new JButton("Bet " + currentBet);
        newGame.setBounds(width / 2 - 40, 10, 80, 30);
        newGame.addActionListener(this);
        this.add(newGame);
        hit = new JButton("Hit");
        hit.setBounds(width / 2 - 150, 10, 80, 30);
        hit.addActionListener(this);
        this.add(hit);
        stay = new JButton("Stand");
        stay.setBounds(width / 2 + 50, 10, 80, 30);
        stay.addActionListener(this);
        this.add(stay);
        visibility(true);
        bet = new JTextField();
        bet.setBounds(200, 10, 50, 30);
        bet.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                String str = bet.getText();
                if(str != "") {
                    currentBet = Integer.parseInt(str);
                }
                if(currentBet > wins) {
                    currentBet = wins;
                }
                newGame.setText("Bet " + currentBet);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                String str = bet.getText();
                if(str != "") {
                    currentBet = Integer.parseInt(str);
                }
                if(currentBet > wins) {
                    currentBet = wins;
                }
                newGame.setText("Bet " + currentBet);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
            }
        });
        this.add(bet);
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
            g.drawString("GAME OVER, SCORE=" + wins, width / 2 - 180, 100);
            return;
        }
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        for(int i = 0; i < deck.size(); i++) {
            deck.get(i).drawMe(g, (i * 10) % (width - 150) + 150, 600 + (i / ((width - 150) / 10)) * 200, false);
        }
        for(int i = 0; i < player.size(); i++) {
            player.get(i).drawMe(g, (i * 60) % (width - 150) + 150, 200 + (i / ((width - 150) / 60)) * 200);
        }
        for(int i = 0; i < dealer.size(); i++) {
            if(i == 0) {
                dealer.get(i).drawMe(g, (i * 60) % (width - 150) + 150, 400 + (i / ((width - 150) / 60)) * 200);
            } else {
                dealer.get(i).drawMe(g, (i * 60) % (width - 150) + 150, 400 + (i / ((width - 150) / 60)) * 200, false);
            }
        }
        g.setColor(Color.BLACK);
        g.drawString("Score: " + wins, 30, 100);
        g.drawString("Bet: ", 30, 50);
        if(!tot.equals("")) {
            g.drawString("Total: " + tot, width - 400, 100);
        } else {
            g.drawString("Total: " + (playerTotal - adjust), width - 400, 100);
        }
        if(!dealt.equals("")) {
            g.drawString("Dealer: " + dealt, width - 400, 150);
        }
        g.setColor(Color.GREEN);
        g.drawString(text, width / 2 - 120, 100);
    }
    public void deal(boolean which) {
        Card c = deck.remove(0);
        if(which) {
            player.add(c);
        } else {
            dealer.add(c);
        }
        int[] values = new int[] {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        if(which) {
            playerTotal += values[c.getValue() % 13];
        } else {
            dealerTotal += values[c.getValue() % 13];
        }
        if(dealer.size() > 1 && which && (playerTotal - adjust) <= 21 && ((dealerTotal - dealerAdjust) < 17)) {
            deal(false);
        }
        adjust = 0;
        for(int i = 0; i < player.size(); i++) {
            if((playerTotal - adjust) <= 21) {
                break;
            }
            if((player.get(i).getValue() % 13) == 0) {
                adjust += 10;
            }
        }
        dealerAdjust = 0;
        for(int i = 0; i < dealer.size(); i++) {
            if((dealerTotal - dealerAdjust) <= 21) {
                break;
            }
            if((dealer.get(i).getValue() % 13) == 0) {
                dealerAdjust += 10;
            }
        }
        if(dealer.size() == 0) {
            dealt = "";
        } else if(dealer.size() == 1)  {
            dealt = String.valueOf(dealerTotal - dealerAdjust);
        }
    }
    public void visibility(boolean input) {
        if(hit == null || newGame == null || stay == null) {
            return;
        }
        hit.setVisible(!input);
        newGame.setVisible(input);
        stay.setVisible(!input);
    }
    public void reset() {
        deck.addAll(player);
        deck.addAll(dealer);
        Collections.shuffle(deck);
        player.clear();
        dealer.clear();
        playerTotal = 0;
        dealerTotal = 0;
        adjust = 0;
        dealerAdjust = 0;
        visibility(true);
    }
    public void check() {
        while(dealerTotal - dealerAdjust < 17 && (playerTotal - adjust) <= 21) {
            deal(false);
        }
        int[] values = new int[] {1, 1, 1, 2, 3, 5};
        if((playerTotal - adjust) > 21) {
            text = "YOU LOST";
        } else if((dealerTotal - dealerAdjust) > 21) {
            text = "YOU WON";
            wins += 2 * currentBet;
        } else if(playerTotal - adjust > dealerTotal - dealerAdjust) {
            text = "YOU WON";
            wins += 2 * currentBet;
        } else if(dealerTotal - dealerAdjust > playerTotal - adjust) {
            text = "YOU LOST";
        } else {
            text = "YOU TIED";
            wins += currentBet;
        }
        dealt = String.valueOf(dealerTotal - dealerAdjust);
        tot = String.valueOf(playerTotal - adjust);
        reset();
    }

    public void actionPerformed(ActionEvent e) {
        if(playerTotal == adjust && e.getSource() == newGame) {
            deck.addAll(player);
            deck.addAll(dealer);
            Collections.shuffle(deck);
            player.clear();
            dealer.clear();
            deal(true);
            deal(true);
            deal(false);
            deal(false);
            text = "";
            tot = "";
            String str = bet.getText();
            if(str != "") {
                currentBet = Integer.parseInt(str);
            }
            if(currentBet > wins) {
                currentBet = wins;
            }
            wins -= currentBet;
            visibility(false);
        } else if(e.getSource() == hit) {
            deal(true);
        } else if(e.getSource() == stay) {
            check();
        }
        if((playerTotal - adjust) >= 21 || (dealerTotal - dealerAdjust) > 21) {
            check();
        }
        repaint();
    }
}
