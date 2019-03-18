public class BigDog extends Dog {
    public BigDog(String a) {
        super(a);
    }
    @Override
    public String speak() {
        return super.speak()+"!!!!";
    }
}