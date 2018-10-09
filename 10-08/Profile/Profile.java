public class Profile {
    private int age;
    private String name;
    public Profile(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public void printInfo() {
        System.out.println("age: "+age+"\nname: "+name);
    }
}