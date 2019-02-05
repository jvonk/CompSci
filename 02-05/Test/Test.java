import java.util.*;
public class Test {
    private ArrayList<String> wordList = new ArrayList<String>();
    public Test() {
        wordList.add("cat");
        wordList.add("fish");
        wordList.add("dog");
        wordList.add("mouse");
        wordList.add("hare");
    }
    public void scramble() {
        Collections.shuffle(wordList);
    }
    public void sort() {
        Collections.sort(wordList);
    }
    public void printList() {
        wordList.stream().forEach(System.out::println);
        System.out.println();
    }
    public int search(String in) {
        return wordList.indexOf(in);
    }
}
