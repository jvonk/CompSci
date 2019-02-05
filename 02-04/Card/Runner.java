import java.util.*;
import java.util.Collections;

public class Runner {
    public static void main (String[] args) {
        List<Card> cardList = new ArrayList<Card>();
        for (int i = 1; i < 5; i++) {
            cardList.add(new Card(i));
        }
        Collections.shuffle(cardList);
        for (Card c : cardList) {
            System.out.println(c);
        }
    }
}
