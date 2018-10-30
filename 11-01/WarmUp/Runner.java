public class Runner {
    public static void main(String[] args) {
        WarmUp w = new WarmUp(5);
        w.count();
        System.out.println(w.getFactorial());
    }
}