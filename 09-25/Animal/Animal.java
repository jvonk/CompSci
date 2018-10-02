public class Animal {
    private String animalType;
    private int age;
    public void setVariables(String animalType, int age) {
        this.animalType=animalType;
        this.age=age;
    }
    public void printInfo() {
        System.out.println("animalType: "+animalType);
        System.out.println("age: "+age);
    }
}