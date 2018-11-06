/**
 * Count
 */
public class Count {
    public int getFactorial (int num) {
        int total = 1, count = 1;
        while (count<=num) 
            total*=count++;
        return total;
    }    
}