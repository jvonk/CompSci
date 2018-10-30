public class WarmUp {
    int num;
    public WarmUp (int in) {
        num=in;
    }
    public void count() {
        int c = 1;
        while (c <= num)
            System.out.println(c++);
    }
    public int getFactorial() {
        int res = 1, i = 1;
        while ( i <= num )
            res*=i++;
        return res;
    }
}