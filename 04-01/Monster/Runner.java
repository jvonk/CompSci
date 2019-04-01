import java.util.*;
public class Runner {
    public static void main(String[] args) {
        List<Monster> ms = new ArrayList<>();
        ms.add(new Vampire());
        ms.add(new Mummy());
        ms.add(new Witch());
        for (Monster m : ms) {
            m.getInfo();
            m.addCoins(5);
            System.out.println(m.getCount()+"\t"+m.getCoins());
        }
    }
}