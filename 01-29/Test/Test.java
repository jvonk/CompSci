import java.util.*;
public class Test {
    List<Integer> numList;
    public Test() {
        numList = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            numList.add((int)(Math.random() * 10 + 1));
        }
    }
    public void printList() {
        for(int num : numList) {
            System.out.println(num);
        }
        System.out.println();
    }
    public int searchLargest() {
        return Collections.max(numList);
    }
    public void searchAndReplace(int in) {
        int i = 0;
        while ((i=numList.indexOf(in))!=-1) {
            numList.set(i, 1000);
        }
    }
    public void searchAndRemove(int in) {
        int i = 0;
        while ((i=numList.indexOf(in))!=-1) {
            numList.remove(i);
        }
    }
    public void scramble() {
        Collections.shuffle(numList);
    }
}
