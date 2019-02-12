import java.util.ArrayList;
public class Runner2 {
    public static void main (String[] args) {
        Practice p = new Practice();
        ArrayList<Card> c = new ArrayList<Card>();
        for (int i = 0; i < 10; i++) {
            c.add(new Card((int)(Math.random()*5+1)));
        }
        p.print(c);
        System.out.println(p.getSmallest(c));
        p.scramble(c);
        p.print(c);
        p.sort(c);
        p.print(c);
        p.searchReplace(2, c);
        p.print(c);
        p.searchDelete(5, c);
        p.print(c);
    }
}
