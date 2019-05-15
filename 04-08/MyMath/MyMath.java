public class MyMath {
    public void countDown(int a) {
        if (a<0) return;
        System.out.println(a);
        countDown(a-1);
    }
    public void countUp(int a) {
        if (a<1) return;
        countUp(a-1);
        System.out.println(a);
    }
    public int factorial(int a) {
        if (a==1) return 1;
        return a*factorial(a-1);
    }
}