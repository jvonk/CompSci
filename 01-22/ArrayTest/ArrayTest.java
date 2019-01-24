public class ArrayTest {
    private String[] words;
    public ArrayTest() {
        words = new String[] {"dog", "cat", "mouse", "hare", "rat"};
    }
    public void printWords() {
        for (String a : words) System.out.println(a);
        System.out.println();
    }
    public void swapWords(int a, int b) {
        String t = words[a];
        words[a] = words[b];
        words[b] = t;
    }
}
