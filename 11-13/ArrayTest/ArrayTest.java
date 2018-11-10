import java.util.Arrays;

public class ArrayTest {
  public static void arrayDemo1 () {
    System.out.println("Demo 1");
    int[] test = new int[5];
    System.out.println(test[0]=(int)(Math.random()*15+1));
    System.out.println(test[1]=(int)(Math.random()*15+1));
    System.out.println(test[2]=(int)(Math.random()*15+1));
    System.out.println(test[3]=(int)(Math.random()*15+1));
    System.out.println(test[4]=(int)(Math.random()*15+1));
  }
  public static void arrayDemo2 () {
   System.out.println("Demo 2");
   int[] test = new int[25];
    for (int i = 0; i < test.length; i++)
      System.out.println(test[i] = (int)(Math.random()*9+1));    
  }
  public static void arrayDemo3 () {      
    System.out.println("Demo 3");
    String[] test = new String[5];
    Arrays.fill(test, "TOTALLY RANDOM WORD");
    for(String str : test) System.out.println(str);
  }

}
