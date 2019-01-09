public class StringTest {
    private String myText;
    public StringTest (String in) {
        myText=in;
    }
    private int getLength() {
        return myText.length();
    }
    public void printInfo() {
        System.out.println(myText+"\n"+getLength());
    }
    public void printChar(int i) {
        System.out.println(myText.charAt(i));
    }
    public void printLocation(String in) {
        System.out.println(myText.indexOf(in, 0));
    }
    public int countChar(char in) {
        return testString.chars().filter(ch -> ch == in).count();
    }
}