public class Dog extends Animal {
    public Dog (String a) {
        super(a);
    }
    @Override
    public void speak () {
        System.out.println("woof");
    }
    public void printInfo() {
        super.speak();
        System.out.println(super.getName());
        System.out.print("I make the sound ");
        this.speak();

    }
}