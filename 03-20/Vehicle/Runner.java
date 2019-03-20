public class Runner {
    public static void main(String[] args) {
        Car c = new Car("Ford");
        System.out.println(c.myInfo());
        Motorcycle m = new Motorcycle("Harley Davidson");
        System.out.println(m.myInfo());
        System.out.println(((Vehicle)m).myInfo());
    }
}