public class Diagram {
    public void demo1(int x, int y) {
        int t = x;
        x = y;
        y = t;
        System.out.println(x + " : " + y);
    }

    public void demo2(String a, String b) {
        String t = b;
        b = a;
        a = "java";
        System.out.println(a + " : " + b);
    }

    public void demo3(MyClass a, MyClass b) {
        MyClass t = a;
        t.changeC("dog");
        b.changeA(99);
        a = null;
        System.out.println(a);
        System.out.println(b);
    }
}
