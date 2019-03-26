import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<Animal> as = new ArrayList<>();
        as.add(new Cat("Scratcher"));
        as.add(new Dog("Clifford"));
        as.add(new Bird("Dead"));
        for (Animal a : as) {
            a.printInfo();
        }
    }
}