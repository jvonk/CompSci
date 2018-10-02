import java.util.Scanner;

public class AnimalRunner {
    public static void main(String[] args) {
        Animal an = new Animal();
        Scanner kb = new Scanner(System.in);
        System.out.print("Animal type: ");
        String name = kb.next();
        System.out.print("Animal age: ");
        int age = kb.nextInt(); 
        an.setVariables( name, age );
        an.printInfo();
    }
}