import java.util.*;
public class Runner {
    public static void main(String[] args) {
        List<Career> cs = new ArrayList<>();
        cs.add(new Teacher("John"));
        cs.add(new Teacher("Heather"));
        cs.add(new PoliceOfficer());
        for (Career c : cs) {
            System.out.println(c.getInfo());
        }
    }
}