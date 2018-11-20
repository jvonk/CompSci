public class Runner {
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest(5);
        test.print();
        int result = test.getProduct();
        System.out.println(result);
    }
}