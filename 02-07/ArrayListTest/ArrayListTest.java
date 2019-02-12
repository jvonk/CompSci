import java.util.*;
public class ArrayListTest {
    public void scramble(ArrayList<Item> in) {
        Collections.shuffle(in);
    }
    public void sort(ArrayList<Item> in) {
        Collections.sort(in);
    }
    public void printList(ArrayList<Item> in) {
        in.stream().forEach(System.out::println);
        System.out.println();
    }
}
