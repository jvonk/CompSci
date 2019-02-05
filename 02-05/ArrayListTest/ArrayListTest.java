import java.util.*;
public class ArrayListTest {
    public void scramble(ArrayList<Integer> in) {
        Collections.shuffle(in);
    }
    public void sort(ArrayList<Integer> in) {
        Collections.sort(in);
    }
    public void print(ArrayList<Integer> in) {
        in.stream().forEach(System.out::println);
        System.out.println();
    }
}
