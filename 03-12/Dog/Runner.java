public class Runner {
    public static void main(String[] args) {
        Dog d1 = new Dog("Fido");
        d1.speak();
        //BigDog d2 = (BigDog)d1; doesn't work because it is casting up
        BigDog bd1 = new BigDog("Tiny");
        bd1.speak();
        Dog bd2 = (Dog)bd1;
        bd2.speak();
        Husky h1 = new Husky("Snow");
        h1.speak();
        Dog h2 = (Dog)h1;
        h2.speak();
        Husky h3 = (Husky)h1;
        h3.speak();
        BigDog h4 = (BigDog) h1;
        h4.speak(); //works because it is above Husky
    }
}