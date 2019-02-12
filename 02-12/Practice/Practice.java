import java.util.ArrayList;
public class Practice {
    public String getDomain(String in) {
        return in.substring(in.indexOf("@")+1, in.lastIndexOf('.'));
    }
    public void print(Card[] in) {
        for (Card c : in) {
            System.out.println(c);
        }
    }
    public void print(ArrayList<Card> in) {
        for (Card c : in) {
            System.out.println(c);
        }
    }
    public int getLargest (Card[] in) {
        int max = 0;
        for (Card c : in) {
            max = Math.max(max, c.getValue());
        }
        return max;
    }
    public int getSmallest (ArrayList<Card> in) {
        int min = Integer.MAX_VALUE;
        for (Card c : in) {
            min = Math.min(min, c.getValue());
        }
        return min;
    }
    public void scramble(Card[] in) {
        for (int i = 0; i < in.length; i++) {
            int j = (int)(Math.random()*in.length);
            Card t = in[i];
            in[i] = in[j];
            in[j] = t;
        }
    }
    public void scramble(ArrayList<Card> in) {
        for (int i = 0; i < in.size(); i++) {
            int j = (int)(Math.random()*in.size());
            Card t = in.get(i);
            in.set(i, in.get(j));
            in.set(j, t);
        }
    }
    public void sort(Card[] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (i==j || in[i].getValue()<=in[j].getValue()) continue;
                Card t = in[i];
                in[i] = in[j];
                in[j] = t;
            }
        }
    }
    public void sort(ArrayList<Card> in) {
        for (int i = 0; i < in.size(); i++) {
            for (int j = 0; j < in.size(); j++) {
                if (i==j || in.get(i).getValue()<=in.get(j).getValue()) continue;
                Card t = in.get(i);
                in.set(i, in.get(j));
                in.set(j, t);
            }
        }
    }
    public void searchReplace(int k, Card[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i].getValue()==1) {
                in[i]=new Card(k);
            }
        }
    }
    public void searchReplace(int k, ArrayList<Card> in) {
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i).getValue()==1) {
                in.set(i, new Card(k));
            }
        }
    }
    public void searchDelete(int k, ArrayList<Card> in) {
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i).getValue()==k) {
                in.remove(i--);
            }
        }
    }
}
