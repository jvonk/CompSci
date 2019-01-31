public class Runner {
    public static void main(String[] args) {
        Test t = new Test();
        t.printList();
        int res = t.searchLargest();
        System.out.println(res+"\n");
        t.searchAndReplace(5);
        t.printList();
        t.searchAndRemove(2);
        t.printList();
        t.scramble();
        t.printList();
    }
}
