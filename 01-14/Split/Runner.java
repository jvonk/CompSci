public class Runner {
    public static void main(String[] args) {
        Split sp = new Split("john.smith@mvla.net");
        String res = sp.getName();
        System.out.println(res);
        System.out.println(res=sp.getDomain());
        System.out.println(res=sp.getLastNameMVLA("jane.doe@mvla.net"));
        System.out.println(sp);        
    }
}