public class Cat extends Animal {
    public Cat(String a) {
        super(a);
    }
    @Override
    public void speak () {
        System.out.println("meow");
    }
    public void printInfo() {
        super.speak();
        System.out.println(super.getName());
        System.out.print("I make the sound ");
        this.speak();
    }
}