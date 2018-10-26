import java.util.Scanner;
public class Warmup {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[] n = new int[] {kb.nextInt(), 0};
        while (n[1] < n[0])
            System.out.println(++n[1]);
    }
}