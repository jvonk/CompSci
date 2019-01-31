import java.util.*;
public class Runner {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(3, "S"));
        cards.add(new Card(7, "D"));
        cards.add(new Card(10, "H"));
        for(Card card : cards) {
            System.out.println(card);
        }
    }
}
