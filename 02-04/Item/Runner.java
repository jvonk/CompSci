import java.util.*;

public class Runner {
    public static void main (String[] args) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item("pencil", 0.5));
        list.add(new Item("pen", 0.75));
        list.add(new Item("book", 9.99));
        list.add(new Item("cereal", 4.99));
        list.add(new Item("milk", 2.99));
        Collections.swap(list, 2, 4);
        System.out.println(list);
    }
}
