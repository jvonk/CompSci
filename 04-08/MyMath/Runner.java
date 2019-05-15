public class Runner {
    public static void main(String[] args) {
        MyMath m = new MyMath();
        m.countDown(5);
        m.countUp(10);
        System.out.println(m.factorial(5));
    }
}