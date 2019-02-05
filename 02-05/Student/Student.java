import java.util.*;
public class Student implements Comparable {
    private String name;
    private int id;
    public Student(String a, int b) {
        name = a;
        id = b;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name + " : " + id;
    }
    @Override
    public int compareTo(Object b) {
        return this.name.compareTo(((Student)b).getName());
    }
}
