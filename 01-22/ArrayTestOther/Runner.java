import java.util.Random;
public class Runner {
    public static void main (String[] args) {
        ArrayTest a = new ArrayTest();
        int[] nums = new Random().ints(10, 1, 11).toArray();
        a.printArray(nums);
        a.scramble(nums);
        a.printArray(nums);
        a.sort(nums);
        a.printArray(nums);
        String[] words = new String[] {"a", "b", "c", "d", "e"};
        a.printArray(words);
        a.scramble(words);
        a.printArray(words);
        a.sort(words);
        a.printArray(words);
    }
}
