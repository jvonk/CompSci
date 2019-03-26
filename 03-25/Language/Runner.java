import java.util.*;
public class Runner {
    public static void main(String[] args) {
        List<Language> ls = new ArrayList<>();
        ls.add(new English());
        ls.add(new French());
        ls.add(new Dutch());
        for (Language l : ls) {
            System.out.println(l.getAuthor()+"\n"+l.getHello()+"\n"+l.getBye()+"\n"+l.getThankYou()+"\n");
        }
    }
}