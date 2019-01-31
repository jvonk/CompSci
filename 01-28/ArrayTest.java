public class ArrayTest {
    String[] words;
    public ArrayTest() {
        words = new String[] {"cat", "bird", "mouse", "rat", "dog"};
    }
    public void printWords() {
        for(String word : words) {
            System.out.println(word);
        }
    }
    public void swapWords(int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
