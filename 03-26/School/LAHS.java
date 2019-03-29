public class LAHS implements School {
    private String name, address;

    public LAHS (String a, String b) {
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