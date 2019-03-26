public class MVHS implements School {
    private String name, address;

    public MVHS(String a, String b) {
        name = a;
        address = b;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}