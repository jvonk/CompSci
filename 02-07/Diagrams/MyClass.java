import java.util.ArrayList;

public class MyClass {
    private int a;
    private int b;
    private String c;

    public MyClass(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void changeC(String input) {
        this.c = input;
    }

    public void changeA(int input) {
        this.a = input;
    }

    public String toString() {
        String str = (a + " : " + b + " : " + c);
        return str;
    }

    public void changeB(ArrayList<String> test) {
        test.set(0, "cat");
    }
}
