public class Overloaded{
    private int age;
    private String name;
     
    public Overloaded(){
        this.age = 0;
        this.name = "blank";
    }
     
 
    public Overloaded(int age, String name){
        this.age = age;
        this.name = name;
    }
     
    public void print(){
        System.out.println("My name is " + name);
        System.out.println("I am " + age + " years old");
    }
     
    public void print(int age){
        System.out.println("My name is " + name);
        System.out.println("My age is " + age);
    }
     
    public void print(String name){
        this.name = name;
        print();
    }
 
}