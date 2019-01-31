import java.util.*;
public class ArrayTest {
    List<Integer> numList = new ArrayList<Integer>();
    public ArrayTest(int size) {
        for(int i = 0; i < size; i++) {
            numList.add((int)(Math.random() * 15 + 1));
        }
    }
    public void print() {
        for(int num : numList) {
            System.out.println(num);
        }
    }
    public void printBackwards() {
        for(int i = numList.size()-1; i >= 0; i--) {
            System.out.println(numList.get(i));
        }
    }
}
