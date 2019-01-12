public class Split {
    private String email;
    public Split(String in) {
        email = in;
    }
    public String getName() {
        return email.substring(0, email.indexOf("@"));
    }
    public String getDomain() {
        return email.substring(email.indexOf("@")+1);
    }
    public String getLastNameMVLA(String in) {
        return in.substring(in.indexOf(".")+1, email.indexOf("@")-2);
    }
    public String toString() {
        return "address: "+email;
    }
}