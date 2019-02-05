import java.util.*;
public class Runner {
    public static void main (String[] args) {
        ArrayListTest a = new ArrayListTest();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            numList.add((int)(Math.random()*10+1));
        }
        a.print(numList);
        a.scramble(numList);
        a.print(numList);
        a.sort(numList);
        a.print(numList);
    }
}
