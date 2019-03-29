import java.util.*;
public class Runner {
    public static void main(String[] args) {
        List<School> ss = new ArrayList<>();
        ss.add(new MVHS("Mountain View High School", "3535 Truman Ave"));
        ss.add(new LAHS("Los Altos High School", "201 Almond Ave"));
        for (School s : ss) System.out.println(s.getName()+"\n"+s.getAddress());
    }
}