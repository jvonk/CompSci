import java.util.*;
public class Runner {
    public static void main (String[] args) {
        int[][] arr = new int[4][5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().ints(arr[i].length, 1, 51).toArray();
        }
        WarmUp w = new WarmUp(arr);
        w.print();
        System.out.println(w.findLargest());
    }
}