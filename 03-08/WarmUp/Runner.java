import java.util.*;
public class Runner {
    public static void main(String[] args) {
        int[][] a = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = (int)(Math.random()*50+1);
            }
        }
        WarmUp w = new WarmUp(a);
        w.print();
        w.replaceLargest();
        w.print();
    }
}