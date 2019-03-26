public abstract class Animal {
    private String name;
    public Animal(String n) {
        name = n;
    }
    public abstract String speak();
    public abstract String getColor();
    public String getName() {
        return name;
    }
    public void printInfo() {
        System.out.println(getName()+": "+speak()+" and is "+getColor());
    }
}