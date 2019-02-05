import java.util.*;
public class Runner {
    public static void main (String[] args) {
        List<Student> l = new ArrayList<Student>();
        l.add(new Student("Henry", 1234));
        l.add(new Student("Jose", 5321));
        l.add(new Student("Carla", 1921));
        l.add(new Student("Nancy", 54198));
        Collections.sort(l);
        for (Student s : l) {
            System.out.println(s);
        }
    }
}
