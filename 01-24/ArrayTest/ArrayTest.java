import java.util.*;
import java.util.stream.*;
public class ArrayTest {
    private int[] nums;
    public ArrayTest(int in) {
        nums = new int[in];
        for (int i = 0; i < in; i++) nums[i] = (int) (Math.random()*10+1);
    }
    public void printArray() {
        for (int a: nums) System.out.println(a);
        System.out.println();
    }
    public void scramble () {
        List<Integer> a = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.shuffle(a);
        nums = a.stream().mapToInt(x -> x).toArray();
    }
    public void sort() {
        Arrays.sort(nums);
    }
}
