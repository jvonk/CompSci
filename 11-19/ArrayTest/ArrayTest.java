public class ArrayTest {
    private int[] numbers;
    public ArrayTest (int n) {
        numbers = new int[n];
        for (int i = 0; i < n; i++) 
            numbers[i] = (int)(Math.random()*5+1);
    }
    public void print() {
        for (int num: numbers)
            System.out.println(num);
    }
    public int getSum() {
        int sum = 0;
        for (int num: numbers)
            sum+=num;
        return sum;
    }
}