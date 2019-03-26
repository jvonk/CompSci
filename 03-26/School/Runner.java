public class Runner {
    public static void main(String[] args) {
        MVHS mvhs = new MVHS("Mountain View High School", "Truman Ave");
        System.out.println(mvhs.getName()+"\n"+mvhs.getAddress());
    }
}