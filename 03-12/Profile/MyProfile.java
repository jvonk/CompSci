public class MyProfile extends Profile {
    private int age;
    public MyProfile(String a, int b) {
        super(a);
        age=b;
    }
    @Override
    public String toString() {
        return super.toString()+"\tMy age is "+age;
    }
}