
public class Runner {
    public static void main(String[] args) {
        Review r = new Review(5);
        r.printArray();
        int max = r.getLargest();
        System.out.println(max);
    }    
}