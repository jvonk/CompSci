import java.util.*;
public class Runner {
    public static void main (String[] args) {
        Test t = new Test();
        t.printList();
        int res = t.search("dog");
        System.out.println(res);
        t.scramble();
        t.printList();
        t.sort();
        t.printList();
    }
}
