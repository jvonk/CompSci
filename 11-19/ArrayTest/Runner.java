public class Runner {
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest(5);
        test.print();
        int result = test.getSum();
        System.out.println(result);
    }
}