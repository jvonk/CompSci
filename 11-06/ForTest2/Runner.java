/**
 * Runner
 * 
 * Instantiate ForTest2
 * 
 * Call printCount(int,int) passing in 3 and 10 respectively.
 * 
 * Call getSum(int) : passing in 5.  Store the result in a variable and Print it.
 */
public class Runner {
    public static void main(String[] args) {
        ForTest2 f = new ForTest2();
        f.printCount(3, 10);
        int result = f.getSum(5);
        System.out.println(result);
    }    
}