import java.util.*;

public class Test {
    private ArrayList<Integer> numList = new ArrayList<Integer>();
    public Test() {
        for (int i = 0; i < 10; i++) {
            numList.add((int)(Math.random()*10+1));
        }
    }
    public void printList() {
        for (int i : numList) {
            System.out.println(i);
        }
        System.out.println();
    }
    public int searchSmallest() {
        return Collections.min(numList);
    }
    public void scramble() {
        Collections.shuffle(numList);
    }
    public void sort() {
        Collections.sort(numList);
    }
}
