public abstract class Monster {
    private String name;
    private static int count;
    private static int coins;
    public Monster(String a) {
        name = a;
    }
    public abstract String getFavFood();
    public String getName() {
        return "My name is " + name;
    }
    public static int getCount() {
        return count;
    }
    public static void addCoins(int a) {
        coins += a;
    }
    public static int getCoins() {
        return coins;
    }
    public void getInfo() {
        System.out.println(getName()+" and I like "+getFavFood());
    }
}