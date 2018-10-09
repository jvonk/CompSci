public class ModEx {
    public void checkOddOrEven(int in) {
        if (in%2==0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void checkPrime(int num) {
        if (isPrime(num)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}