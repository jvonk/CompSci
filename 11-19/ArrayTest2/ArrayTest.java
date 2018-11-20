import java.util.Scanner;
import java.util.Arrays;

public class ArrayTest {
    int[] numbers;
    String[] strs;
    Scanner kb = new Scanner(System.in);
    public void r (int a) {
        numbers = new int[a];
        for (int i = 0; i < numbers.length; i++) 
            numbers[i] = (int)(Math.random()*9+1);
        for (int num: numbers)
            System.out.println(num);
    }
    public void arrayDemo6 () {
        System.out.println("\nDemo 6");
        r(10);
        System.out.print("number to set to 0: ");
        numbers[kb.nextInt()] = 0;
        for (int num: numbers)
            System.out.println(num);
    }
    public void arrayDemo7 () {
        System.out.println("\nDemo 7");
        strs = new String[] {"a", "bee", "see", "deaf", "eight", "forte", "gee", "ache", "I", "jay"};
        System.out.println(String.join("\n", strs));
        System.out.print("number to set to 522: ");
        strs[kb.nextInt()] = "522";
        System.out.println(String.join("\n", strs));
    }

    public void arrayDemo8 (int a) {
        System.out.println("\nDemo 8");
        r(a);
    }


    public void arrayDemo9 () {
        System.out.println("\nDemo 9");
        strs = new String[] {"a", "bee", "see", "deaf", "eight", "forte", "gee", "ache", "I", "jay"};
        System.out.println(String.join("\n", strs));
        System.out.print("String to find: ");
        int index = Arrays.asList(strs).indexOf(kb.next());
        System.out.println((index>0)?("found: "+index):"");
    }
}