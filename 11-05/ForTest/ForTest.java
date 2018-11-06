/*
 * ForTest
 * 
 * +printCount() : void - Write a for loop that counts from 1 to 100
 * inclusive.
 * 
 * 
 * +printCount(int) : void - Write a for loop that counts from 1 to the number
 * passed in inclusive. Assume that number passed in is positive.
 * 
 * 
 * +printCount(int,int) : void - Write a for loop that counts from the first
 * parameter to the second parameter inclusive. Assume the first parameter
 * passed will be smaller than the second.
 * 
 * 
 * +getFactorial(int) : int - Using a for loop calculate the factorial of the
 * number passed in and return it.
 */
public class ForTest {
    public void printCount() {
        for (int i = 1; i <= 100; i++)
            System.out.println(i);
    }
    public void printCount(int first) {
        for (int i = 1; i <= first; i++)
            System.out.println(i);
    }
    public void printCount(int first, int last) {
        for (int i = first; i <= last; i++)
            System.out.println(i);
    }
    public int getFactorial (int num) {
        int total = 1, count = 1;
        while (count<=num) 
            total*=count++;
        return total;
    }  
}