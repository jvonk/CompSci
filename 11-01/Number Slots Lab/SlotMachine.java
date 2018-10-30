import java.awt.Graphics;
import java.awt.Color;

public class SlotMachine {
    int num1;
    int num2;
    int num3;
    int balance;
    int oldBalance;
    int bet;

    public SlotMachine() {
        num1 = 0;
        num2 = 0;
        num3 = 0;
        balance = 100;
        oldBalance = 100;
        bet = 0;
    }

    public void drawMe(Graphics g, int counter) {

        // System.out.println(counter);
        if (balance > oldBalance) {
            g.setColor(Color.GREEN);
            g.fillOval(400-counter*(balance - oldBalance), 400-counter*(balance - oldBalance), 2*counter*(balance - oldBalance), 2*counter*(balance - oldBalance));
            g.setColor(Color.RED);
            g.drawString("YOU WIN!", 375, 375);
            for (int i = 0; i < (balance - oldBalance) * 100; i++) {
                if (i%20==19) {
                    g.drawString("YOU WIN!", (int) (Math.random()*800), (int) (Math.random()*600));
                }
                Color temp = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
                        (int) (Math.random() * 255));
                g.setColor(temp);
                g.drawLine(400, 400, 400 + (int) ((10 + 50*(balance - oldBalance) + 5 * counter) * (balance - oldBalance) / 10 * (Math.random() - 0.5)),
                        400 + (int) ((10 + 50*(balance - oldBalance) + 5 * counter) * (balance - oldBalance) / 10 * (Math.random() - 0.5)));
            }
        }
        // Colors
        Color blue = new Color(0, 0, 255);
        Color white = new Color(255, 255, 255);
        // Draw Slot Machine
        g.setColor(blue);
        g.fillRect(100, 100, 200, 100);
        // Draw numbers
        g.setColor(white);
        g.drawString(num1 + "" + num2 + "" + num3, 150, 150);
        g.drawString("Bet: " + bet, 150, 165);
        g.drawString("Balance: " + balance, 150, 180);
        g.drawString("YOU WON: " + (balance - oldBalance), 150, 135);
    }

    public void play() {
        if (balance >= bet && bet > 0) {
            num1 = (int) (Math.random() * 9 + 1);
            num2 = (int) (Math.random() * 9 + 1);
            num3 = (int) (Math.random() * 9 + 1);
            oldBalance = balance;
            balance -= bet;
            if (num1 == 7 && num2 == 7 && num3 == 7) {
                balance += 100 * bet;
            } else if (num1 == num2 && num2 == num3) {
                balance += 5 * bet;
            } else if (num1 == num2 || num2 == num3 || num1 == num3) {
                balance += 2 * bet;
            }
        }
    }

    public void setBet(int in) {
        bet = in;
    }
}
