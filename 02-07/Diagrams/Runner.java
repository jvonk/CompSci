import java.util.ArrayList;

public class Runner {
    public static void main(String args[]) {
        int a;
        int b;
        String text1;
        String text2;
        //                          a    b      c
        MyClass obj1 = new MyClass(300, 500, "hello");
        MyClass obj2;
        Diagram myObject = new Diagram();
        //Diagram 1 - Look at slide 5 for an example
        //There should be no arrows for diagram 1.
        System.out.println("Diagram 1");
        a = 3;
        b = 6;
        //                 3 : 6
        System.out.println(a + " : " + b);
        //             6 : 3
        myObject.demo1(a, b);
        //                 3 : 6
        System.out.println(a + " : " + b);
        System.out.println("\n");
        //Diagram 2
        //Look at slide 15
        System.out.println("Diagram 2");
        ArrayList<String> myText = new ArrayList<String>();
        myText.add("hello");
        myText.add("World");
        //                     hello
        System.out.println(myText.get(0));
        obj1.changeB(myText);
        //                      cat
        System.out.println(myText.get(0));
        System.out.println("\n");
        //Diagram 3
        System.out.println("Diagram 3");
        //                  a    b      c
        obj1 = new MyClass(300, 500, "hello");
        //                  a   b    c
        obj2 = new MyClass(30, 50, "bye");
        //                 30 : 500 : hello
        System.out.println(obj1);
        //                 30 : 50 : bye
        System.out.println(obj2);
        //null
        //99 : 50 : bye
        myObject.demo3(obj1, obj2);
        //                 300 : 500 : dog
        System.out.println(obj1);
        //              99 : 50 : bye
        System.out.println(obj2);
        System.out.println("\n");
        //Diagram 4
        System.out.println("Diagram 4");
        text1 = "cat";
        text2 = "dog";
        //                 cat : dog
        System.out.println(text1 + " : " + text2);
        //                 java : cat
        myObject.demo2(text1, text2);
        //                 cat : dog
        System.out.println(text1 + " : " + text2);
    }
}
