public class Profile {
    private String employerName, employeeName;
    public Profile(String a, String b) {
        employerName = a;
        employeeName = b;
    }

    public String getInfo() {
        return getName()+" at "+getEmployer();
    }
    public String getEmployer() {
        return employerName;
    }
    public String getName() {
        return employeeName;
    }
}