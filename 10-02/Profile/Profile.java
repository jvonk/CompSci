public class Profile {
    private String name = "";
    private int age = 0;
    public  Profile() {
        this.name="John";
        this.age=15;
    }
    public Profile(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public void printInfo() {
        System.out.println("name: "+name+"\nage: "+age);
    }
    public void printInfo(int id) {
        System.out.println("id: "+id);
        printInfo();
    }
}