/**
 * Runner
 * Instantiate ForTest
 * Call printCount() 
 * Call printCount(int) passing in any number.
 * Call printCount(int,int) passing in 5 and 20 respectively.
 * Call getFactorial(int) : passing in 5.  Store the result in a variable and Print it.
 */
public class Runner {
    public static void main(String[] args) {
        ForTest f = new ForTest();
        f.printCount();
        f.printCount(3);
        f.printCount(5, 20);
        int result = f.getFactorial(5);
        System.out.println(result);
    }    
}