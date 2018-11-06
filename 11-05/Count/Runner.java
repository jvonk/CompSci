/**
 * Runner
 */
public class Runner {
    public static void main(String[] args) {
        Count count = new Count();
        int num = count.getFactorial(5);
        System.out.println("num: "+num);
    }    
}