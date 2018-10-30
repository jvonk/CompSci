public class Menu {
    public String selectMenu1(int in) {
        if (in>=1 && in <=3) {
            return Character.toString((char)(in-1+'A'));
        }
        return "not valid";        
    }
    public String selectMenu2(int in) {
        switch (in) {
            case 1: return Character.toString((char)(in-1+'X'));
            case 2: return Character.toString((char)(in-1+'X'));
            case 3: return Character.toString((char)(in-1+'X'));
            default: return "not valid";        
        }
    }
    
}