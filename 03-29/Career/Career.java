public class Career {
    private String name;
    private double salary;
    public Career (String a, double b) {
        name = a;
        salary = b;
    }

    public String getInfo() {
        return getName()+" is paid "+getSalary();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}