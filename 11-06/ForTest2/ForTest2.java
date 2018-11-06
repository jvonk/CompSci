/*
 * ForTest
 * 
 * +printCount(int,int) : void - Write a for loop that counts from the first parameter to the second parameter inclusive.  Assume the first parameter passed will be smaller than the second. 
 * 
 * +getSum(int) : int - Using a for loop add up all the numbers from 1 to that number inclusive.  Return the result.
 */
public class ForTest2 {
    public void printCount(int first, int last) {
        for (int i = first; i <= last; i++)
            System.out.println(i);
    }

    public int getSum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++)
            sum += i;
        return sum;
    }
}