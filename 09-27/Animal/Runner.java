import java.util.Scanner;

class Runner {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        Animal a = new Animal();
        a.printInfo();
        System.out.print("age: ");
        int age = kb.nextInt();
        System.out.print("animalType: ");
        String animalType = kb.next();
        Animal b = new Animal(age, animalType);
        b.printInfo();
    }
}