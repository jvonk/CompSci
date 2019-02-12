import java.util.*;

public class Runner {
    public static void main (String[] args) {
        ArrayListTest at = new ArrayListTest();
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(15.50, "Book"));
        itemList.add(new Item(999.99, "Laptop"));
        itemList.add(new Item(0.25, "Pencil"));
        at.printList(itemList);
        at.scramble(itemList);
        at.printList(itemList);
        at.sort(itemList);
        at.printList(itemList);
    }
}
