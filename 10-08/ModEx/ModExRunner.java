import java.util.Scanner;
public class ModExRunner {
    public static void main (String[] args) {
        ModEx calc = new ModEx();
        Scanner kb = new Scanner(System.in);
        System.out.print("Integer please: ");
        int input = kb.nextInt();
        calc.checkOddOrEven(input);
        calc.checkPrime(8);
        calc.checkPrime(17);
        calc.checkPrime(587);
    }
}