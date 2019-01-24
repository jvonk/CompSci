import java.util.*;
import java.util.stream.*;
public class ArrayTest {
    public void printArray(int[] a) {
        for (int b : a) System.out.println(b);
        System.out.println();
    }
    public void printArray(String[] a) {
        for (String b : a) System.out.println(b);
        System.out.println();
    }
    public void scramble(String[] a) {
        List<String> b = Arrays.asList(a);
        Collections.shuffle(b);
        a = b.toArray(a);
    }
    public void scramble(int[] a) {
        List<Integer> b = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.shuffle(b);
        a = b.stream().mapToInt(i->i).toArray();
    }
    public void sort(String[] a) {
        List<String> b = Arrays.asList(a);
        Collections.sort(b);
        a = b.toArray(a);
    }
    public void sort(int[] a) {
        List<Integer> b = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(b);
        a = b.stream().mapToInt(i->i).toArray();
    }
}
