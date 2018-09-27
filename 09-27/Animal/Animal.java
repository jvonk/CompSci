public class Animal {
    private int age;
    private String animalType;
    public Animal() {
        this.animalType="blank";
        this.age=0;
    }
    public Animal(int age, String animalType) {
        this.age = age;
        this.animalType=animalType;
    }
    public void printInfo() {
        System.out.println("age: "+age+"\nanimalType: "+animalType);
    }
}