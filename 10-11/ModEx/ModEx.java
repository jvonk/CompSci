public class ModEx {
    private int number;
    public ModEx(int num) {
        number=num;
    }
    public void numCheck() {
        if (number%5==0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}