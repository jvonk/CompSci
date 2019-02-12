public class Runner1 {
    public static void main (String[] args) {
        Practice p = new Practice();
        System.out.println(p.getDomain("jen@mvla.net"));
        Card[] c = new Card[10];
        for (int i = 0; i < 10; i++) {
            c[i] = new Card((int)(Math.random()*5+1));
        }
        p.print(c);
        System.out.println(p.getLargest(c));
        p.scramble(c);
        p.print(c);
        p.sort(c);
        p.print(c);
        p.searchReplace(2, c);
        p.print(c);
    }
}
