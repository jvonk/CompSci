public class Runner {
    public static void main(String[] args) {
        Loop l = new Loop(10, 20);
        l.countWhile();
        int sum = l.getSum();
        System.out.println(sum);
    }
}