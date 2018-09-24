public class Animal {
    private String animalType;
    private int age;
    public void setVariables() {
        animalType="dog";
        age=5;
    }
    public void printInfo() {
        System.out.println("animalType: "+animalType);
        System.out.println("age: "+age);
    }
}